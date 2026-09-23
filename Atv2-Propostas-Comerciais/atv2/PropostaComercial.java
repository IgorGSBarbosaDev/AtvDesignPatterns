package atv2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/** Produto final imutável entregue pelo Builder. */
public final class PropostaComercial {
    private final String cliente;
    private final String responsavel;
    private final int validadeEmDias;
    private final List<ItemProposta> itens;
    private final BigDecimal descontoPercentual;
    private final String observacoes;
    private final String moeda;

    PropostaComercial(
            String cliente,
            String responsavel,
            int validadeEmDias,
            List<ItemProposta> itens,
            BigDecimal descontoPercentual,
            String observacoes,
            String moeda) {
        this.cliente = cliente;
        this.responsavel = responsavel;
        this.validadeEmDias = validadeEmDias;
        // A cópia impede que alterações posteriores no Builder mudem o produto.
        this.itens = List.copyOf(itens);
        this.descontoPercentual = descontoPercentual;
        this.observacoes = observacoes;
        this.moeda = moeda;
    }

    public String getCliente() {
        return cliente;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public int getValidadeEmDias() {
        return validadeEmDias;
    }

    public List<ItemProposta> getItens() {
        return itens;
    }

    public BigDecimal getDescontoPercentual() {
        return descontoPercentual;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public String getMoeda() {
        return moeda;
    }

    public BigDecimal calcularSubtotal() {
        return itens.stream()
                .map(ItemProposta::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularDesconto() {
        return calcularSubtotal()
                .multiply(descontoPercentual)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal calcularTotal() {
        return calcularSubtotal().subtract(calcularDesconto());
    }
}
