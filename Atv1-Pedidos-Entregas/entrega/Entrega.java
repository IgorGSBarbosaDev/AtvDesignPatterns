package entrega;

import modelo.Pedido;

/** Define as operações comuns de qualquer modalidade de entrega. */
public interface Entrega {

    /** Retorna o prazo estimado da modalidade em dias. */
    int calcularPrazoEmDias();

    /** Realiza a entrega do pedido. */
    void realizarEntrega(Pedido pedido);
}
