package br.edu.ufu.bcc.aa.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import br.edu.ufu.bcc.aa.model.vo.Entrada;
import br.edu.ufu.bcc.aa.model.vo.Instancia;
import br.edu.ufu.bcc.aa.model.vo.Tipo;

public class ArquivoEntradaDAO {
	private String nomeArquivo;
	private Scanner scanner;
	
	public ArquivoEntradaDAO(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public Entrada get() throws FileNotFoundException {
		FileReader arquivo = new FileReader(this.nomeArquivo);
		scanner = new Scanner(arquivo);
		scanner.useDelimiter(",|\\s|\\n");
		
		Entrada entrada = new Entrada();
		
		while( scanner.hasNextLine() ) { // Para cada linha
			Instancia instancia = new Instancia();
			String[] tokens = scanner.nextLine().split(",|\\s|\\n");
			for (int i = 0; i < tokens.length-1; i++)
				instancia.getChave().add(tokens[i]);
			instancia.setDadoSatelite(tokens[tokens.length-1]);
			entrada.add(instancia);
		}
		verificarTipoEntrada(entrada);
		return entrada;
	}
	
	private void verificarTipoEntrada(Entrada entrada) {
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
	
	private boolean tipoBinario(Entrada entrada) {
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
	
	private boolean tipoPontoFlutuante(Entrada entrada) {
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
	
	private boolean tipoInteiro(Entrada entrada) {
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
