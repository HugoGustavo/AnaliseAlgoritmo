package br.edu.ufu.bcc.aa.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import br.edu.ufu.bcc.aa.model.vo.Entrada;
import br.edu.ufu.bcc.aa.model.vo.Instancia;

public class ArquivoEntradaDAO extends EntradaDAO {
	private String nomeArquivo;
	private Scanner scanner;
	
	public ArquivoEntradaDAO(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public Entrada get() {
		try {
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
		} catch (IOException e) {
			throw new RuntimeException("Erro de leitura do arquivo: " + this.nomeArquivo);
		}
	}
}
