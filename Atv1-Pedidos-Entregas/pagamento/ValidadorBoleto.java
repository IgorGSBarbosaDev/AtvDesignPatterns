package pagamento;

import modelo.Pedido;

/** Valida pagamentos realizados por boleto. */
public final class ValidadorBoleto implements ValidadorPagamento {

    @Override
    public boolean validar(Pedido pedido) {
        boolean valido = pedido != null && pedido.getValor() > 0;
        if (valido) {
            System.out.println("Pagamento por boleto validado.");
        }
        return valido;
    }
}
