import entrega.CentralEntrega;
import entrega.CentralEntregaBicicleta;
import entrega.CentralEntregaMoto;
import entrega.CentralEntregaRetirada;
import modelo.Pedido;
import pagamento.BoletoFactory;
import pagamento.CartaoFactory;
import pagamento.PagamentoFactory;
import pagamento.PixFactory;
import pagamento.ServicoPagamento;

/** Executa os cenários obrigatórios e a extensão do sistema. */
public final class Aplicacao {

    private Aplicacao() {
    }

    /** Ponto de entrada que demonstra a integração entre pagamento e entrega. */
    public static void main(String[] args) {
        Pedido pedidoPix = new Pedido(101, "Ana", "Rua das Flores, 101", 89.90);
        executarPedido(pedidoPix, new PixFactory(), new CentralEntregaMoto());

        Pedido pedidoCartao = new Pedido(102, "Carlos", "Avenida Central, 202", 149.90);
        executarPedido(pedidoCartao, new CartaoFactory(), new CentralEntregaBicicleta());

        Pedido pedidoBoleto = new Pedido(103, "Beatriz", "Rua do Comércio, 303", 59.90);
        executarPedido(pedidoBoleto, new BoletoFactory(), new CentralEntregaRetirada());
    }

    private static void executarPedido(
            Pedido pedido,
            PagamentoFactory pagamentoFactory,
            CentralEntrega centralEntrega) {
        System.out.println("PEDIDO " + pedido.getNumero());
        new ServicoPagamento(pagamentoFactory).processar(pedido);
        centralEntrega.despachar(pedido);
        System.out.println();
    }
}
