package br.edu.ufu.bcc.aa.model.vo;

public class ComparadorPontoFlutuante extends Comparador {
	public int comparacaoUnitaria(String pontoFlutuante1, String pontoFlutuante2) {
		double valor1 = Double.parseDouble(pontoFlutuante1);
		double valor2 = Double.parseDouble(pontoFlutuante2);
		
		if (valor1 < valor2) {
			return -1;
		} else if (valor1 == valor2) {
			return 0;
		} else {
			return 1;
		}
	}
}
