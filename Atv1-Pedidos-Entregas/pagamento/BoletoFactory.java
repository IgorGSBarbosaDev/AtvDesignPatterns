package pagamento;

/** Cria a família de produtos de pagamento por boleto. */
public final class BoletoFactory implements PagamentoFactory {

    @Override
    public ValidadorPagamento criarValidador() {
        return new ValidadorBoleto();
    }

    @Override
    public EmissorRecibo criarEmissorRecibo() {
        return new ReciboBoleto();
    }
}
