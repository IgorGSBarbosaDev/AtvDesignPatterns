package modelo;

/** Representa os dados essenciais de um pedido da plataforma. */
public final class Pedido {

    private final int numero;
    private final String cliente;
    private final String endereco;
    private final double valor;

    /** Cria um pedido com dados válidos para processamento e entrega. */
    public Pedido(int numero, String cliente, String endereco, double valor) {
        if (numero <= 0) {
            throw new IllegalArgumentException("O número do pedido deve ser positivo.");
        }
        if (valor <= 0 || Double.isNaN(valor) || Double.isInfinite(valor)) {
            throw new IllegalArgumentException("O valor do pedido deve ser positivo e finito.");
        }

        this.numero = numero;
        this.cliente = validarTexto(cliente, "O cliente");
        this.endereco = validarTexto(endereco, "O endereço");
        this.valor = valor;
    }

    /**Criando todos os metodos get e set
     * Retorna o número identificador do pedido. */
    public int getNumero() {
        return numero;
    }

    /** Retorna o nome do cliente do pedido. */
    public String getCliente() {
        return cliente;
    }

    /** Retorna o endereço associado ao pedido. */
    public String getEndereco() {
        return endereco;
    }

    /** Retorna o valor total do pedido. */
    public double getValor() {
        return valor;
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null) {
            throw new IllegalArgumentException(campo + " não pode ser nulo.");
        } else if (valor.isBlank()) {
            throw new IllegalArgumentException(campo + " não pode ser vazio.");
        }
        return valor;
    }
}
