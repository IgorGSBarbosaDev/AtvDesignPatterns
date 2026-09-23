package atv2;

import java.math.BigDecimal;

/** Etapas necessárias para montar uma proposta comercial. */
public interface PropostaBuilder {
    PropostaBuilder iniciar(String cliente, String responsavel, int validadeEmDias);

    PropostaBuilder adicionarItem(ItemProposta item);

    PropostaBuilder aplicarDesconto(BigDecimal descontoPercentual);

    PropostaBuilder definirObservacoes(String observacoes);

    PropostaBuilder definirMoeda(String moeda);

    PropostaComercial construir();
}
