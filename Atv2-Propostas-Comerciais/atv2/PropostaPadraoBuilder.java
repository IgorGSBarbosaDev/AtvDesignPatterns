package atv2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/** Builder concreto com validação e reinício após cada produto entregue. */
public final class PropostaPadraoBuilder implements PropostaBuilder {
    private final BigDecimal limiteMaximoDesconto;

    private String cliente;
    private String responsavel;
    private int validadeEmDias;
    private List<ItemProposta> itens = new ArrayList<>();
    private BigDecimal descontoPercentual = BigDecimal.ZERO;
    private String observacoes = "";
    private String moeda;
    private boolean iniciada;

    public PropostaPadraoBuilder(BigDecimal limiteMaximoDesconto) {
        if (limiteMaximoDesconto == null || limiteMaximoDesconto.signum() < 0) {
            throw new IllegalArgumentException("o limite de desconto não pode ser negativo.");
        }
        this.limiteMaximoDesconto = limiteMaximoDesconto;
    }

    @Override
    public PropostaPadraoBuilder iniciar(String cliente, String responsavel, int validadeEmDias) {
        reiniciar();
        this.cliente = cliente;
        this.responsavel = responsavel;
        this.validadeEmDias = validadeEmDias;
        this.iniciada = true;
        return this;
    }

    @Override
    public PropostaPadraoBuilder adicionarItem(ItemProposta item) {
        exigirMontagemIniciada();
        if (item == null) {
            throw new IllegalArgumentException("o item não pode ser nulo.");
        }
        itens.add(item);
        return this;
    }

    @Override
    public PropostaPadraoBuilder aplicarDesconto(BigDecimal descontoPercentual) {
        exigirMontagemIniciada();
        if (descontoPercentual == null) {
            throw new IllegalArgumentException("o desconto não pode ser nulo.");
        }
        this.descontoPercentual = descontoPercentual;
        return this;
    }

    @Override
    public PropostaPadraoBuilder definirObservacoes(String observacoes) {
        exigirMontagemIniciada();
        this.observacoes = observacoes == null ? "" : observacoes.trim();
        return this;
    }

    @Override
    public PropostaPadraoBuilder definirMoeda(String moeda) {
        exigirMontagemIniciada();
        if (moeda == null || moeda.isBlank()) {
            throw new IllegalArgumentException("a moeda é obrigatória.");
        }
        this.moeda = moeda.trim();
        return this;
    }

    @Override
    public PropostaComercial construir() {
        exigirMontagemIniciada();
        validar();

        PropostaComercial proposta = new PropostaComercial(
                cliente,
                responsavel,
                validadeEmDias,
                itens,
                descontoPercentual,
                observacoes,
                moeda);
        reiniciar();
        return proposta;
    }

    private void validar() {
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("o cliente é obrigatório.");
        }
        if (responsavel == null || responsavel.isBlank()) {
            throw new IllegalArgumentException("o responsável é obrigatório.");
        }
        if (validadeEmDias <= 0) {
            throw new IllegalArgumentException("a validade deve ser maior que zero.");
        }
        if (itens.isEmpty()) {
            throw new IllegalArgumentException("a proposta deve possuir pelo menos um item.");
        }
        if (moeda == null || moeda.isBlank()) {
            throw new IllegalArgumentException("a moeda é obrigatória.");
        }
        if (descontoPercentual.signum() < 0
                || descontoPercentual.compareTo(limiteMaximoDesconto) > 0) {
            throw new IllegalArgumentException(
                    "o desconto deve estar entre 0% e " + limiteMaximoDesconto + " %.");
        }
    }

    private void exigirMontagemIniciada() {
        if (!iniciada) {
            throw new IllegalStateException("inicie a proposta antes de configurá-la.");
        }
    }

    private void reiniciar() {
        cliente = null;
        responsavel = null;
        validadeEmDias = 0;
        itens = new ArrayList<>();
        descontoPercentual = BigDecimal.ZERO;
        observacoes = "";
        moeda = null;
        iniciada = false;
    }
}
