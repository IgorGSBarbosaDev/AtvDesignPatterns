package entrega;

import modelo.Pedido;

/** Define o fluxo comum de despacho e o Factory Method de entrega. */
public abstract class CentralEntrega {

    /** Cria a modalidade de entrega definida pela central concreta. */
    protected abstract Entrega criarEntrega();

    /** Valida, cria, informa o prazo e realiza a entrega do pedido. */
    public final void despachar(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }

        Entrega entrega = criarEntrega();
        if (entrega == null) {
            throw new IllegalStateException("A central deve criar uma entrega.");
        }
        int prazo = entrega.calcularPrazoEmDias();
        String unidade = prazo == 1 ? "dia" : "dias";

        System.out.println("Prazo estimado: " + prazo + " " + unidade + ".");
        entrega.realizarEntrega(pedido);
    }
}
