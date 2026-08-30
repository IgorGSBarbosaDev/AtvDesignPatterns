package pagamento;

import modelo.Pedido;

/** Emite recibos para pagamentos via PIX. */
public final class ReciboPix implements EmissorRecibo {

    @Override
    public String emitir(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }
        return "Recibo PIX emitido para " + pedido.getCliente() + ".";
    }
}
