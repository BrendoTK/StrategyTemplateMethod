package com.manoelcampos.retornoboleto;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe abstrata que define o Template Method para leitura de boletos.
 */
public abstract class LeituraRetornoTemplate implements LeituraRetorno {
    @Override
    public List<Boleto> lerArquivo(URI caminhoArquivo) {
        try {
            return Files.lines(Paths.get(caminhoArquivo))
                    .map(this::processarLinhaArquivo)  // Aplica a função processarLinhaArquivo a cada linha do arquivo
                    .collect(Collectors.toList());    // Coleta os resultados em uma lista
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método abstrato que deve ser implementado pelas subclasses
     * para processar as linhas específicas de cada formato de arquivo.
     *
     * @param linha a linha do arquivo a ser processada
     * @return um objeto {@link Boleto} criado a partir da linha processada
     */
    protected abstract Boleto processarLinhaArquivo(String linha);
}
