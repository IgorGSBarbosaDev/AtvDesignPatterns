package atv2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Um item e seu valor são imutáveis depois de adicionados à proposta. */
public final class ItemProposta {
    private final String descricao;
    private final int quantidade;
    private final BigDecimal valorUnitario;

    public ItemProposta(String descricao, int quantidade, BigDecimal valorUnitario) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("a descrição do item é obrigatória.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("a quantidade deve ser maior que zero.");
        }
        if (valorUnitario == null || valorUnitario.signum() < 0) {
            throw new IllegalArgumentException(
                    "o valor unitário é obrigatório e não pode ser negativo.");
        }

        this.descricao = descricao.trim();
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario.setScale(2, RoundingMode.HALF_UP);
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public BigDecimal getTotal() {
        return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public String toString() {
        return descricao + " (" + quantidade + " x " + valorUnitario + ")";
    }
}
