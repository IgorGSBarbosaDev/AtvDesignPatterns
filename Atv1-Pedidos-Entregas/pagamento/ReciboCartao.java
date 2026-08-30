package pagamento;

import modelo.Pedido;

/** Emite recibos para pagamentos com cartão. */
public final class ReciboCartao implements EmissorRecibo {

    @Override
    public String emitir(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }
        return "Recibo de cartão emitido para " + pedido.getCliente() + ".";
    }
}
