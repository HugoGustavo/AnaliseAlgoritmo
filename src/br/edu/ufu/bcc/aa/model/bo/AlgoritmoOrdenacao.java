package br.edu.ufu.bcc.aa.model.bo;

import br.edu.ufu.bcc.aa.model.vo.Comparador;
import br.edu.ufu.bcc.aa.model.vo.Entrada;
import br.edu.ufu.bcc.aa.model.vo.Instancia;

public abstract class AlgoritmoOrdenacao {
	public boolean estaOrdenado(Entrada entrada, Comparador comparador) {
		return estaOrdenado(entrada, 0, entrada.tamanho()-1, comparador);
	}
	
	public boolean estaOrdenado(Entrada entrada, int limiteInferior, int limiteSuperior, Comparador comparador) {
		for (int i = limiteInferior + 1; i <= limiteSuperior; i++)
			if ( menor(entrada.get(i), entrada.get(i-1), comparador ) )
				return false;
		return true;
	}
	
	public void trocar(Entrada entrada, int i, int j) {
		Instancia aux = entrada.get(i);
		entrada.set(i, entrada.get(j));
		entrada.set(j, aux);
	}
	
	public boolean menor(Instancia instancia1, Instancia instancia2, Comparador comparador) {
		return comparador.comparar(instancia1, instancia2) < 0;
	}
	
	public void executar(Entrada entrada) {
		ordenar(entrada, entrada.getComparador());		
	}
	
	public abstract void ordenar(Entrada entrada, Comparador comparador);

}
