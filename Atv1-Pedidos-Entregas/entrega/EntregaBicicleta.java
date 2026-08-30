package entrega;

import modelo.Pedido;

/** Realiza entregas usando uma bicicleta. */
public final class EntregaBicicleta implements Entrega {

    @Override
    public int calcularPrazoEmDias() {
        return 2;
    }

    @Override
    public void realizarEntrega(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }
        System.out.println("Pedido " + pedido.getNumero() + " entregue por bicicleta.");
    }
}
