package entrega;

/** Cria retiradas no estabelecimento por meio do Factory Method. */
public final class CentralEntregaRetirada extends CentralEntrega {

    @Override
    protected Entrega criarEntrega() {
        return new EntregaRetirada();
    }
}
