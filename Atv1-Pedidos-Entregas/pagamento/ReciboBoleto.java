package pagamento;

import modelo.Pedido;

/** Emite recibos para pagamentos por boleto. */
public final class ReciboBoleto implements EmissorRecibo {

    @Override
    public String emitir(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }
        return "Recibo de boleto emitido para " + pedido.getCliente() + ".";
    }
}
