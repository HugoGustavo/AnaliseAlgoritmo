package br.edu.ufu.bcc.aa.model.vo;

public class ComparadorBinario extends Comparador {
	public int comparacaoUnitaria(String binario1, String binario2) {
		int valor1 = Integer.parseInt(binario1, 2);
		int valor2 = Integer.parseInt(binario2, 2);
		
		if (valor1 < valor2) {
			return -1;
		} else if (valor1 == valor2) {
			return 0;
		} else {
			return 1;
		}
	}
}
