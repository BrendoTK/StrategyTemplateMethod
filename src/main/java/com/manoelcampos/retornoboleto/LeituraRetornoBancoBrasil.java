package com.manoelcampos.retornoboleto;

import java.time.LocalDate;

/**
 * Implementação da leitura de arquivos de retorno de boletos bancários no formato do Banco do Brasil.
 * Esta classe herda de {@link LeituraRetornoTemplate} e implementa o método {@link #processarLinhaArquivo(String)}.
 */
public class LeituraRetornoBancoBrasil extends LeituraRetornoTemplate {
    @Override
    protected Boleto processarLinhaArquivo(String linha) {
        final String[] vetor = linha.split(";");
        final var boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetor[0]));
        boleto.setCodBanco(vetor[1]);
        boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0, 0));
        boleto.setCpfCliente(vetor[4]);
        boleto.setValor(Double.parseDouble(vetor[5]));
        boleto.setMulta(Double.parseDouble(vetor[6]));
        boleto.setJuros(Double.parseDouble(vetor[7]));

        return boleto;
    }
}
