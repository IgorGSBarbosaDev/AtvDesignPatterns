package pagamento;

/** Cria a família de produtos de pagamento com cartão. */
public final class CartaoFactory implements PagamentoFactory {

    @Override
    public ValidadorPagamento criarValidador() {
        return new ValidadorCartao();
    }

    @Override
    public EmissorRecibo criarEmissorRecibo() {
        return new ReciboCartao();
    }
}
