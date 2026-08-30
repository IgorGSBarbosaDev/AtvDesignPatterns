package pagamento;

/** Define a fábrica para criação de uma família de produtos de pagamento. */
public interface PagamentoFactory {

    /** Cria o validador correspondente ao meio de pagamento. */
    ValidadorPagamento criarValidador();

    /** Cria o emissor de recibo correspondente ao meio de pagamento. */
    EmissorRecibo criarEmissorRecibo();
}
