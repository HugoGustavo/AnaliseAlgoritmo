package br.edu.ufu.bcc.aa.model.bo;

import java.util.List;

public class OrdenacaoParImpar<T  extends Comparable<T>> extends AlgoritmoOrdenacao<T>{
	private void comparaTroca(List<T>lista, int i, int j) {
		T t1 = lista.get(i);
		T t2 = lista.get(j);
		int diferenca = t1.compareTo(t2);
		if ( diferenca > 0 ) {
			lista.set(i, t2);
			lista.set(j, t1);
		}
	}

	@Override
	public void ordenar(List<T> entrada) {
		long tamanho = entrada.size();
		boolean ordenado = false;
		
		while (!ordenado) {
			ordenado = true;
			for (int i = 1; i <= tamanho-2; i=i+2) {
				T t1 = entrada.get(i);
				T t2 = entrada.get(i+1);
				int diferenca = t1.compareTo(t2);
				if ( diferenca > 0 ) {
					entrada.set(i, t2);
					entrada.set(i+1, t1);
					ordenado = false;
				}
			}
			
			for (int i = 0; i <= tamanho-2; i=i+2) {
				T t1 = entrada.get(i);
				T t2 = entrada.get(i+1);
				int diferenca = t1.compareTo(t2);
				if ( diferenca > 0 ) {
					entrada.set(i, t2);
					entrada.set(i+1, t1);
					ordenado = false;
				}
			}
		}		
	}
	
	/*
	@Override
	public void ordenar(List<T> entrada) {
		long tamanho = entrada.size();
		
		for (int i = 0; i < tamanho; i ++) {
			if ( i % 2 == 0 ) {
				for (int j = 0; j <= (tamanho/2)-1; j++) {
					comparaTroca(entrada, (2*j), (2*j)+1);
				}
			} else {
				for (int j = 1; j <= (tamanho/2)-1; j++) {
					comparaTroca(entrada, (2*j)-1, (2*j));
				}
			}
		}
		
	}
	*/

}
