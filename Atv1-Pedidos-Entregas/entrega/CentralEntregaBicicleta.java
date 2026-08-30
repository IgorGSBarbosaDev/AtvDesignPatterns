package entrega;

/** Cria entregas de bicicleta por meio do Factory Method. */
public final class CentralEntregaBicicleta extends CentralEntrega {

    @Override
    protected Entrega criarEntrega() {
        return new EntregaBicicleta();
    }
}
