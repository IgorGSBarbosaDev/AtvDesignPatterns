package pagamento;

import modelo.Pedido;

/** Define a operação de validação de um pagamento. */
public interface ValidadorPagamento {

    /** Informa se o pagamento do pedido pode ser considerado válido. */
    boolean validar(Pedido pedido);
}
