package br.edu.ufu.bcc.aa.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArquivoEntradaDAO {
	private String nomeArquivo;
	
	public ArquivoEntradaDAO(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public <T extends Comparable<T>> List<T> get() throws FileNotFoundException{
		FileReader arquivo = new FileReader(this.nomeArquivo);
		Scanner scanner = new Scanner(arquivo);
		scanner.useDelimiter(",| |\\n");
		List<T> lista = new ArrayList<>();
		while(scanner.hasNext()) {
			lista.add((T) new Integer(scanner.nextInt()));
		}
		return lista;
	}
}
