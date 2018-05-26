package br.edu.ufu.bcc.aa.model.bo;

import br.edu.ufu.bcc.aa.model.vo.Comparador;
import br.edu.ufu.bcc.aa.model.vo.Entrada;
import br.edu.ufu.bcc.aa.model.vo.Instancia;

public class OrdenacaoIntercalacao extends AlgoritmoOrdenacao {
	private static final int DESLOCAMENTO = 7;

	private void ordenacaoInsercao(Entrada entrada, int limiteInferior, int limiteSuperior, Comparador comparador) {
		for (int i = limiteInferior; i <= limiteSuperior; i++)
			for(int j = i; j > limiteInferior && menor(entrada.get(j), entrada.get(j-1), comparador); j--)
				trocar(entrada, j, j-1);
	}

	private void copiar(Entrada origem, int posicaoOrigem, Entrada destino, int posicaoDestino, int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			Instancia instancia = origem.get(posicaoOrigem+i);
			destino.set(posicaoDestino+i, instancia);
		}
	}
	
	private void intercalar(Entrada origem, Entrada destino, int limiteInferior, int meio, int limiteSuperior, Comparador comparador) {
		assert estaOrdenado(origem, limiteInferior, meio, comparador);
		assert estaOrdenado(origem, meio+1, limiteSuperior, comparador);
		
		int i = limiteInferior;
		int j = meio + 1;
		for (int k = limiteInferior; k <= limiteSuperior; k++ ) {
			if ( i > meio ) {
				destino.set(k, origem.get(j++));
			} else if ( j > limiteSuperior ) {
				destino.set(k,  origem.get(i++));
			} else if ( menor(origem.get(j), origem.get(i), comparador) ) {
				destino.set(k, origem.get(j++));
			} else {
				destino.set(k, origem.get(i++));
			}
		}
		assert estaOrdenado(destino, limiteInferior, limiteSuperior, comparador);
	}
	
	private void ordenar(Entrada origem, Entrada destino, int limiteInferior, int limiteSuperior, Comparador comparador) {
		if ( limiteSuperior <= limiteInferior + DESLOCAMENTO ) {
			ordenacaoInsercao(destino, limiteInferior, limiteSuperior, comparador);
			return;
		}
		
		int meio = limiteInferior + ( limiteSuperior - limiteInferior) / 2;
		ordenar(destino, origem, limiteInferior, meio, comparador);
		ordenar(destino, origem, meio+1, limiteSuperior, comparador);
	
		if ( !menor(origem.get(meio+1), origem.get(meio), comparador) ) {
			copiar(origem, limiteInferior, destino, limiteInferior, limiteSuperior - limiteInferior + 1);
		}
		
		intercalar(origem, destino, limiteInferior, meio, limiteSuperior, comparador);
	}
	
	@Override
	public void ordenar(Entrada entrada, Comparador comparador) {
		Entrada origem = entrada.clone();
		ordenar(origem, entrada, 0, entrada.tamanho()-1, comparador);
		assert estaOrdenado(entrada, comparador);

	}

}
