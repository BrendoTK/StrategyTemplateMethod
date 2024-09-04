package com.manoelcampos.retornoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Implementação da leitura de arquivos de retorno de boletos bancários no formato do Bradesco.
 * Esta classe herda de {@link LeituraRetornoTemplate} e implementa o método {@link #processarLinhaArquivo(String)}.
 */
public class LeituraRetornoBradesco extends LeituraRetornoTemplate {
    @Override
    protected Boleto processarLinhaArquivo(String linha) {
        final String[] vetor = linha.split(";");
        final var boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetor[0]));
        boleto.setCodBanco(vetor[1]);
        boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
        boleto.setDataPagamento(LocalDateTime.parse(vetor[5], FORMATO_DATA_HORA));
        boleto.setCpfCliente(vetor[6]);
        boleto.setValor(Double.parseDouble(vetor[7]));
        boleto.setMulta(Double.parseDouble(vetor[8]));
        boleto.setJuros(Double.parseDouble(vetor[9]));

        return boleto;
    }
}
