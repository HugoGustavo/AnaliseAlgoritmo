package br.edu.ufu.bcc.aa.model.dao;

import java.util.Scanner;

import br.edu.ufu.bcc.aa.model.vo.Entrada;
import br.edu.ufu.bcc.aa.model.vo.Instancia;

public class TecladoEntradaDAO extends EntradaDAO {
	private Scanner scanner;

	@Override
	public Entrada get() {
		scanner = new Scanner(System.in);
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
}
