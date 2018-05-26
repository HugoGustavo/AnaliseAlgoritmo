package br.edu.ufu.bcc.aa.model.vo;

public class ComparadorInteiro extends Comparador {
	public int comparacaoUnitaria(String inteiro1, String inteiro2) {
		int valor1 = Integer.parseInt(inteiro1);
		int valor2 = Integer.parseInt(inteiro2);
		
		if (valor1 < valor2) {
			return -1;
		} else if (valor1 == valor2) {
			return 0;
		} else {
			return 1;
		}
	}
}
