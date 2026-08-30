package entrega;

import modelo.Pedido;

/** Realiza entregas usando uma moto. */
public final class EntregaMoto implements Entrega {

    @Override
    public int calcularPrazoEmDias() {
        return 1;
    }

    @Override
    public void realizarEntrega(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }
        System.out.println("Pedido " + pedido.getNumero() + " entregue por moto.");
    }
}
