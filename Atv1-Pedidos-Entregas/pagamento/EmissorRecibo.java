package pagamento;

import modelo.Pedido;

/** Define a operação de emissão de recibo para um pedido. */
public interface EmissorRecibo {

    /** Retorna o texto do recibo referente ao pedido. */
    String emitir(Pedido pedido);
}
