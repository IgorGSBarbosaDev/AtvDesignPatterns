package pagamento;

import modelo.Pedido;

/** Valida pagamentos realizados via PIX. */
public final class ValidadorPix implements ValidadorPagamento {

    @Override
    public boolean validar(Pedido pedido) {
        boolean valido = pedido != null && pedido.getValor() > 0;
        if (valido) {
            System.out.println("Pagamento PIX validado.");
        }
        return valido;
    }
}
