package atv2;

import java.math.BigDecimal;

/** Configuração compartilhada apenas pelas classes que a recebem explicitamente. */
public final class ConfiguracaoComercial {
    private final String moedaPadrao = "BRL";
    private final BigDecimal limiteMaximoDesconto = new BigDecimal("15");

    private ConfiguracaoComercial() {
    }

    // O holder cria a instância quando solicitada e mantém a inicialização segura na JVM.
    private static class Holder {
        private static final ConfiguracaoComercial INSTANCIA = new ConfiguracaoComercial();
    }

    public static ConfiguracaoComercial getInstancia() {
        return Holder.INSTANCIA;
    }

    public String getMoedaPadrao() {
        return moedaPadrao;
    }

    public BigDecimal getLimiteMaximoDesconto() {
        return limiteMaximoDesconto;
    }
}
