package pagamento;

import modelo.Pedido;

/** Processa pagamentos usando somente os produtos da fábrica recebida. */
public final class ServicoPagamento {

    private final PagamentoFactory pagamentoFactory;

    /** Cria o serviço com a fábrica da família de pagamento desejada. */
    public ServicoPagamento(PagamentoFactory pagamentoFactory) {
        if (pagamentoFactory == null) {
            throw new IllegalArgumentException("A fábrica de pagamento não pode ser nula.");
        }
        this.pagamentoFactory = pagamentoFactory;
    }

    /** Valida o pagamento e emite o recibo somente quando ele é válido. */
    public void processar(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }

        ValidadorPagamento validador = pagamentoFactory.criarValidador();
        EmissorRecibo emissor = pagamentoFactory.criarEmissorRecibo();

        if (validador.validar(pedido)) {
            System.out.println(emissor.emitir(pedido));
        }
    }
}
