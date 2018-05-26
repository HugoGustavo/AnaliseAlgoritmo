package br.edu.ufu.bcc.aa.model.bo;

import br.edu.ufu.bcc.aa.model.vo.Comparador;
import br.edu.ufu.bcc.aa.model.vo.Entrada;

public class OrdenacaoLenta extends AlgoritmoOrdenacao {

	private void ordenar(Entrada entrada, int limiteInferior, int limiteSuperior, Comparador comparador) {
		if ( limiteInferior >= limiteSuperior )
			return;
		
		int meio = limiteInferior + ( limiteSuperior - limiteInferior) / 2;
		
		ordenar(entrada, limiteInferior, meio, comparador);
		ordenar(entrada, meio+1, limiteSuperior, comparador);
		
		if ( menor(entrada.get(limiteSuperior), entrada.get(meio), comparador) )
			trocar(entrada, limiteSuperior, meio);
		
		ordenar(entrada, limiteInferior, limiteSuperior-1, comparador);
	}
	
	@Override
	public void ordenar(Entrada entrada, Comparador comparador) {
		//assert estaOrdenado(entrada, comparador);
		ordenar(entrada, 0, entrada.tamanho()-1, comparador);
		//assert estaOrdenado(entrada, comparador);

	}

}
