package br.edu.ufu.bcc.aa.model.bo;

import br.edu.ufu.bcc.aa.model.vo.Comparador;
import br.edu.ufu.bcc.aa.model.vo.Entrada;
import br.edu.ufu.bcc.aa.model.vo.Instancia;

public class OrdenacaoParImpar extends AlgoritmoOrdenacao {
	private boolean compararTrocar(Entrada entrada, int i, int j, Comparador comparador) {
		Instancia instancia1 = entrada.get(i);
		Instancia instancia2 = entrada.get(j);
		
		System.out.println(instancia1);
		System.out.println(instancia2);
		
		
		int diferenca = comparador.comparar(instancia1, instancia2);
		if ( diferenca > 0 ) {
			entrada.set(i, instancia2);
			entrada.set(j, instancia1);
			return true;
		}
		return false;
	}

	@Override
	public void ordenar(Entrada entrada, Comparador comparador) {
		long tamanho = entrada.tamanho();
		boolean ordenado = false;
		
		while (!ordenado) {
			ordenado = true;
			for (int i = 1; i <= tamanho-2; i=i+2) {
				if ( compararTrocar(entrada, i, i+1, comparador) ) {
					ordenado = false;
				}
			}
			
			for (int i = 0; i <= tamanho-2; i=i+2) {
				if ( compararTrocar(entrada, i, i+1, comparador) ) {
					ordenado = false;
				}
			}
		}
	}
}
