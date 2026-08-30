package entrega;

import modelo.Pedido;

/** Realiza a retirada do pedido diretamente no estabelecimento. */
public final class EntregaRetirada implements Entrega {

    @Override
    public int calcularPrazoEmDias() {
        return 0;
    }

    @Override
    public void realizarEntrega(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }
        System.out.println("Pedido " + pedido.getNumero() + " retirado no estabelecimento.");
    }
}
