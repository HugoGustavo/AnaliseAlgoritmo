package br.edu.ufu.bcc.aa.model.vo;

import java.util.List;

public abstract class Comparador {
	public abstract int comparacaoUnitaria(String chave1, String chave2);
	
	public int comparar(Instancia instancia1, Instancia instancia2) {
		List<String> chaves1 = instancia1.getChave();
		List<String> chaves2 = instancia2.getChave();
		
		int i = 0;
		int j = 0;
		int comparacao = 0;
		while( i < chaves1.size() && j < chaves2.size() ) {
			String chave1 = chaves1.get(i++);
			String chave2 = chaves2.get(j++);
			
			comparacao = comparacaoUnitaria(chave1, chave2);
			if (comparacao != 0)
				 return comparacao;
		}
		
		if ( i < j ) {
			return -1;
		} else if ( i > j) {
			return 1;
		} else {
			return 0;
		}
	}
}
