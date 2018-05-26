import java.io.FileNotFoundException;

import br.edu.ufu.bcc.aa.model.bo.AlgoritmoOrdenacao;
import br.edu.ufu.bcc.aa.model.bo.OrdenacaoIntercalacao;
import br.edu.ufu.bcc.aa.model.dao.ArquivoEntradaDAO;
import br.edu.ufu.bcc.aa.model.vo.Entrada;

public class Principal {
	public static void main(String[] args) throws FileNotFoundException {
		String nomeArquivo = args[0];
		ArquivoEntradaDAO dao = new ArquivoEntradaDAO(nomeArquivo);
		Entrada entrada = dao.get();
		AlgoritmoOrdenacao algoritmoOrdenacao = new OrdenacaoIntercalacao();
		algoritmoOrdenacao.executar(entrada);
		System.out.println(entrada);
	}
}
