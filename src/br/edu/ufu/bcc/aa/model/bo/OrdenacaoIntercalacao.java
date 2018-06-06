package br.edu.ufu.bcc.aa.model.bo;

import br.edu.ufu.bcc.aa.model.vo.Comparador;
import br.edu.ufu.bcc.aa.model.vo.Entrada;
import br.edu.ufu.bcc.aa.model.vo.Instancia;

public class OrdenacaoIntercalacao extends AlgoritmoOrdenacao {
	private static final int DESLOCAMENTO = 7;
	private BuscaBinaria buscaBinaria = new BuscaBinaria();

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
	/*
	private void imprimir(Entrada entrada, int limiteInferior, int limiteSuperior) {
		for (int i = limiteInferior; i <= limiteSuperior; i++)
			System.out.println(entrada.get(i));
		System.out.println();
	}
	
	private void esperar() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			
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
	*/
	
	private void intercalar(Entrada entrada, int limiteInferior, int meio, int limiteSuperior, Comparador comparador) {
		//assert estaOrdenado(entrada, limiteInferior, meio, comparador);
		//assert estaOrdenado(entrada, meio+1, limiteSuperior, comparador);
		
		Entrada aux = new Entrada();
		aux.setTipo(entrada.getTipo());
		
		int i = limiteInferior;
		int j = meio+1;
		
		while ( i <= meio || j <= limiteSuperior ) {
			Instancia instancia;
			if ( i > meio ) {
				instancia = entrada.get(j++);
			} else if ( j > limiteSuperior ) {
				instancia = entrada.get(i++);
			} else if ( menor(entrada.get(i), entrada.get(j), comparador) ) {
				instancia = entrada.get(i++);
			} else {
				instancia = entrada.get(j++);
			}
			int posicao = buscaBinaria.executar(aux, 0, aux.tamanho()-1, instancia, comparador);
			aux.add(posicao, instancia);
		}
		copiar(aux, 0, entrada, limiteInferior, aux.tamanho());
		//assert estaOrdenado(entrada, limiteInferior, limiteSuperior, comparador);
	}
	
	private void ordenar(Entrada entrada, int limiteInferior, int limiteSuperior, Comparador comparador) {
		if ( limiteSuperior <= limiteInferior + DESLOCAMENTO ) {
			ordenacaoInsercao(entrada, limiteInferior, limiteSuperior, comparador);
			return;
		}
		
		int meio = limiteInferior + ( limiteSuperior - limiteInferior) / 2;
		ordenar(entrada, limiteInferior, meio, comparador);
		ordenar(entrada, meio+1, limiteSuperior, comparador);
		intercalar(entrada, limiteInferior, meio, limiteSuperior, comparador);
	}
	
	@Override
	public void ordenar(Entrada entrada, Comparador comparador) {
		ordenar(entrada, 0, entrada.tamanho()-1, comparador);
	}

}
