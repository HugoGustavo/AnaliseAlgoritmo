import br.edu.ufu.bcc.aa.model.bo.AlgoritmoOrdenacao;
import br.edu.ufu.bcc.aa.model.bo.OrdenacaoIntercalacao;
import br.edu.ufu.bcc.aa.model.dao.EntradaDAO;
import br.edu.ufu.bcc.aa.model.dao.TecladoEntradaDAO;
import br.edu.ufu.bcc.aa.model.vo.Entrada;

public class Principal {
	public static void main(String[] args) {
		EntradaDAO dao = new TecladoEntradaDAO();
		Entrada entrada = dao.get();
		AlgoritmoOrdenacao algoritmoOrdenacao = new OrdenacaoIntercalacao();
		algoritmoOrdenacao.executar(entrada);
		System.out.println(entrada);
	}
}
