package pagamento;

/** Cria a família de produtos de pagamento via PIX. */
public final class PixFactory implements PagamentoFactory {

    @Override
    public ValidadorPagamento criarValidador() {
        return new ValidadorPix();
    }

    @Override
    public EmissorRecibo criarEmissorRecibo() {
        return new ReciboPix();
    }
}
