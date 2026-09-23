package atv2;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/** Ponto de composição e demonstração dos padrões Builder e Singleton. */
public final class Aplicacao {
    private Aplicacao() {
    }

    public static void main(String[] args) {
        ConfiguracaoComercial configuracao = ConfiguracaoComercial.getInstancia();
        ConfiguracaoComercial outraConfiguracao = ConfiguracaoComercial.getInstancia();

        System.out.println("Mesma configuração? " + (configuracao == outraConfiguracao));
        System.out.println("Moeda padrão: " + configuracao.getMoedaPadrao());

        // A configuração entra pelo ponto de composição e é passada às classes que precisam dela.
        PropostaPadraoBuilder builder = new PropostaPadraoBuilder(
                configuracao.getLimiteMaximoDesconto());
        DiretorPropostas diretor = new DiretorPropostas(builder, configuracao.getMoedaPadrao());

        PropostaComercial basica = diretor.criarPropostaBasica(
                "Loja Horizonte", "Ana Costa", 15);
        imprimirProposta("Proposta básica", basica);

        // Reutiliza o mesmo Builder; iniciar() limpa os dados da proposta anterior.
        PropostaComercial personalizada = builder.iniciar(
                        "Clínica Vida", "Bruno Lima", 30)
                .adicionarItem(new ItemProposta(
                        "Desenvolvimento do site", 1, new BigDecimal("2400.00")))
                .adicionarItem(new ItemProposta(
                        "Configuração de hospedagem", 1, new BigDecimal("450.00")))
                .adicionarItem(new ItemProposta(
                        "Treinamento", 2, new BigDecimal("300.00")))
                .aplicarDesconto(new BigDecimal("10"))
                .definirObservacoes("Proposta válida por 30 dias.")
                .definirMoeda(configuracao.getMoedaPadrao())
                .construir();
        imprimirProposta("Proposta personalizada", personalizada);

        try {
            builder.iniciar("Cliente sem itens", "Ana Costa", 10)
                    .definirMoeda(configuracao.getMoedaPadrao())
                    .construir();
        } catch (IllegalArgumentException excecao) {
            System.out.println("Validação: " + excecao.getMessage());
        }
    }

    private static void imprimirProposta(String titulo, PropostaComercial proposta) {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        formatoMoeda.setCurrency(java.util.Currency.getInstance(proposta.getMoeda()));

        System.out.println("\n" + titulo + ": " + proposta.getCliente());
        System.out.println("Responsável: " + proposta.getResponsavel());
        System.out.println("Validade: " + proposta.getValidadeEmDias() + " dias");
        for (ItemProposta item : proposta.getItens()) {
            System.out.println("- " + item);
        }
        System.out.println("Observações: " + proposta.getObservacoes());
        System.out.println("Subtotal: " + formatar(formatoMoeda, proposta.calcularSubtotal()));
        System.out.println("Desconto (" + proposta.getDescontoPercentual() + "%): "
                + formatar(formatoMoeda, proposta.calcularDesconto()));
        System.out.println("Total: " + formatar(formatoMoeda, proposta.calcularTotal()));
    }

    private static String formatar(NumberFormat formato, BigDecimal valor) {
        // Algumas combinações de locale e console usam espaço inseparável após o símbolo.
        return formato.format(valor).replace('\u00A0', ' ');
    }
}
