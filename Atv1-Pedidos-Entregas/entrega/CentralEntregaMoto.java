package entrega;

/** Cria entregas de moto por meio do Factory Method. */
public final class CentralEntregaMoto extends CentralEntrega {

    @Override
    protected Entrega criarEntrega() {
        return new EntregaMoto();
    }
}
