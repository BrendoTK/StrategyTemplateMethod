import com.manoelcampos.retornoboleto.LeituraRetornoBancoBrasil;
import com.manoelcampos.retornoboleto.LeituraRetornoBradesco;
import com.manoelcampos.retornoboleto.ProcessarBoletos;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Classe para ver o funcionamento da leitura de boletos.
 *
 * @author Brendo Braz Sales
 */
public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        // Testando a leitura do Banco do Brasil
        ProcessarBoletos processadorBB = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        URI caminhoArquivoBB = Principal.class.getResource("banco-brasil-1.csv").toURI();
        System.out.println("Lendo arquivo do Banco do Brasil " + caminhoArquivoBB + "\n");
        processadorBB.processar(caminhoArquivoBB);

        // Testando a leitura do Bradesco
        ProcessarBoletos processadorBradesco = new ProcessarBoletos(new LeituraRetornoBradesco());
        URI caminhoArquivoBradesco = Principal.class.getResource("bradesco-1.csv").toURI();
        System.out.println("Lendo arquivo do Bradesco " + caminhoArquivoBradesco + "\n");
        processadorBradesco.processar(caminhoArquivoBradesco);
    }
}
