package atv2;

import java.math.BigDecimal;
import java.util.List;

/** Receitas reutilizáveis para os formatos básico e completo da proposta. */
public final class DiretorPropostas {
    private final PropostaBuilder builder;
    private final String moedaPadrao;

    public DiretorPropostas(PropostaBuilder builder, String moedaPadrao) {
        if (builder == null) {
            throw new IllegalArgumentException("o Builder é obrigatório.");
        }
        if (moedaPadrao == null || moedaPadrao.isBlank()) {
            throw new IllegalArgumentException("a moeda padrão é obrigatória.");
        }
        this.builder = builder;
        this.moedaPadrao = moedaPadrao;
    }

    public PropostaComercial criarPropostaBasica(
            String cliente, String responsavel, int validadeEmDias) {
        return builder.iniciar(cliente, responsavel, validadeEmDias)
                .adicionarItem(new ItemProposta(
                        "Serviço de consultoria", 1, new BigDecimal("500.00")))
                .definirMoeda(moedaPadrao)
                .construir();
    }

    public PropostaComercial criarPropostaCompleta(
            String cliente,
            String responsavel,
            int validadeEmDias,
            List<ItemProposta> itens,
            BigDecimal descontoPercentual,
            String observacoes) {
        PropostaBuilder montagem = builder.iniciar(cliente, responsavel, validadeEmDias)
                .definirMoeda(moedaPadrao)
                .aplicarDesconto(descontoPercentual)
                .definirObservacoes(observacoes);
        if (itens != null) {
            for (ItemProposta item : itens) {
                montagem.adicionarItem(item);
            }
        }
        return montagem.construir();
    }
}
