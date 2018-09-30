package br.edu.ufu.bcc.aa.model.dao;

import java.util.List;

import br.edu.ufu.bcc.aa.model.vo.Entrada;
import br.edu.ufu.bcc.aa.model.vo.Instancia;
import br.edu.ufu.bcc.aa.model.vo.Tipo;

public abstract class EntradaDAO {
	public abstract Entrada get();
	
	protected void verificarTipoEntrada(Entrada entrada) {
		if ( tipoBinario(entrada) ) {
			entrada.setTipo(Tipo.BINARIO);
		} else if ( tipoInteiro(entrada) ) {
			entrada.setTipo(Tipo.INTEIRO);
		} else if ( tipoPontoFlutuante(entrada) ) {
			entrada.setTipo(Tipo.PONTO_FLUTUANTE);
		} else {
			entrada.setTipo(Tipo.STRING);
		}
	}
	
	protected boolean tipoBinario(Entrada entrada) {
		try {
			List<Instancia> instancias = entrada.getInstancias();
			
			for (Instancia instancia : instancias) {
				List<String> chaves = instancia.getChave();
				for(String chave : chaves) {
					Integer.parseInt(chave, 2);
				}
			}
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	protected boolean tipoPontoFlutuante(Entrada entrada) {
		try {
			List<Instancia> instancias = entrada.getInstancias();
			
			for (Instancia instancia : instancias) {
				List<String> chaves = instancia.getChave();
				for(String chave : chaves) {
					Double.parseDouble(chave);
					
				}
			}
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	protected boolean tipoInteiro(Entrada entrada) {
		try {
			List<Instancia> instancias = entrada.getInstancias();
			
			for (Instancia instancia : instancias) {
				List<String> chaves = instancia.getChave();
				for(String chave : chaves) {
					Integer.parseInt(chave);
				}
			}
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	
}
