package br.edu.ufu.bcc.aa.model.bo;

import br.edu.ufu.bcc.aa.model.vo.Comparador;
import br.edu.ufu.bcc.aa.model.vo.Entrada;
import br.edu.ufu.bcc.aa.model.vo.Instancia;

public class BuscaBinaria {
	public int indice(Entrada entrada, int limiteInferior, int limiteSuperior, Instancia instancia, Comparador comparador) {
		int meio=0;
		int comparacao;
		while ( limiteInferior != limiteSuperior ) {
			meio = limiteInferior + ( limiteSuperior - limiteInferior) / 2;
			comparacao = comparador.comparar(instancia, entrada.get(meio));
			if ( comparacao < 0 )
				limiteSuperior = meio - 1;
			else if ( comparacao > 0 )
				limiteInferior = meio + 1;
		}
		return limiteInferior;
	}
	
	public int executar(Entrada entrada, int limiteInferior, int limiteSuperior, Instancia instancia, Comparador comparador) {
		return indice(entrada, limiteInferior, limiteSuperior, instancia, comparador);
	}
}
