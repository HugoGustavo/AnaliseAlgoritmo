package br.edu.ufu.bcc.aa.model.vo;

import java.util.ArrayList;
import java.util.List;

public class Entrada implements Cloneable {
	private List<Instancia> instancias = new ArrayList<Instancia>();
	private Tipo tipo;
	
	public Entrada clone() {
		Entrada entrada = new Entrada();
		List<Instancia> instancias = new ArrayList<Instancia>();
		for (Instancia i : this.instancias ) {
			instancias.add(i.clone());
		}
		entrada.setInstancias(instancias);
		entrada.setTipo(this.tipo);
		return entrada;
		
	}
	
	public List<Instancia> getInstancias() {
		return instancias;
	}
	
	public void setInstancias(List<Instancia> instancias) {
		this.instancias = instancias;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public int tamanho() {
		return this.instancias.size();
	}
	
	public Instancia get(int index) {
		return instancias.get(index);
	}
	
	public void set(int index, Instancia instancia) {
		this.instancias.set(index, instancia);
	}
	
	public void add(Instancia instancia) {
		this.instancias.add(instancia);
	}
	
	public Comparador getComparador() {
		switch( this.tipo ) {
			case BINARIO : return new ComparadorBinario();
			case INTEIRO : return new ComparadorInteiro();
			case PONTO_FLUTUANTE : return new ComparadorPontoFlutuante();
			default: return new ComparadorString();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Instancia i : instancias) {
			stringBuilder.append(i + "\n");
		}
		return stringBuilder.toString();
	}
}
