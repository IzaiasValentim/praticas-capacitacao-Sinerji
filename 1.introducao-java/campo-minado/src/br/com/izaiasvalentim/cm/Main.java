package br.com.izaiasvalentim.cm;

import br.com.izaiasvalentim.cm.modelo.Tabuleiro;
import br.com.izaiasvalentim.cm.visao.TabuleiroNoConsole;

public class Main {
	public static void main(String[] args) {
		// Cria o tabuleiro com a quantidade de linhas, colunas e minas passadas no construtor.
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
		
		// Inicia o jogo.
		new TabuleiroNoConsole(tabuleiro);
	}
}
