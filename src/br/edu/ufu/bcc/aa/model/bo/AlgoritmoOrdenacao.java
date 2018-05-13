package br.edu.ufu.bcc.aa.model.bo;

import java.util.List;

public abstract class AlgoritmoOrdenacao<T extends Comparable<T>> {
	
	public long executar(List<T> entrada) {
		long inicio = System.currentTimeMillis();
		ordenar(entrada);
		long fim = System.currentTimeMillis();
		return (fim-inicio);		
	}
	
	public abstract void ordenar(List<T> entrada);

}
