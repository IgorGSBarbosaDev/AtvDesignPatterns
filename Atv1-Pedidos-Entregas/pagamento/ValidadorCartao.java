package pagamento;

import modelo.Pedido;

/** Valida pagamentos realizados com cartão. */
public final class ValidadorCartao implements ValidadorPagamento {

    @Override
    public boolean validar(Pedido pedido) {
        boolean valido = pedido != null && pedido.getValor() > 0;
        if (valido) {
            System.out.println("Pagamento com cartão validado.");
        }
        return valido;
    }
}
