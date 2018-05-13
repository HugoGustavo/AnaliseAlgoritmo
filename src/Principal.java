import java.io.FileNotFoundException;
import java.util.List;

import br.edu.ufu.bcc.aa.model.bo.AlgoritmoOrdenacao;
import br.edu.ufu.bcc.aa.model.bo.OrdenacaoParImpar;
import br.edu.ufu.bcc.aa.model.dao.ArquivoEntradaDAO;

public class Principal {
	public static <T extends Comparable<T>> void main(String[] args) throws FileNotFoundException {
		String arquivo = "C:\\Users\\hugog\\eclipse-workspace\\AnaliseAlgoritmo\\modelos\\modelo9.txt";
		long tempo = 0;
		for (int i = 0; i < 1; i++) {
			ArquivoEntradaDAO dao = new ArquivoEntradaDAO(arquivo);
			
			List<T> entrada = (List<T>) dao.get();
			
			AlgoritmoOrdenacao<T> algoritmo = new OrdenacaoParImpar<T>();
			
			tempo += algoritmo.executar(entrada);
		}
		System.out.println("Tempo: " + tempo);
		
	}
}
