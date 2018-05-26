package br.edu.ufu.bcc.aa.model.vo;

import java.util.ArrayList;
import java.util.List;

public class Instancia implements Cloneable {
	private List<String> chave = new ArrayList<String>();
	private String dadoSatelite;
	
	public Instancia clone() {
		Instancia instancia = new Instancia();
		instancia.setChave(new ArrayList<String>(chave));
		instancia.setDadoSatelite(new String(dadoSatelite));
		return instancia;
	}
	public List<String> getChave() {
		return chave;
	}
	
	public void setChave(List<String> chave) {
		this.chave = chave;
	}
	
	public String getDadoSatelite() {
		return dadoSatelite;
	}
	
	public void setDadoSatelite(String dadoSatelite) {
		this.dadoSatelite = dadoSatelite;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(String c : chave) {
			stringBuilder.append(c + " ");
		}
		stringBuilder.append(dadoSatelite);
		return stringBuilder.toString();
	}
}
