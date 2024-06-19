package br.com.izaiasvalentim.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.izaiasvalentim.cm.excecao.ExplosaoException;

public class Tabuleiro {

	// Definindo a estrutura do tabuleiro.
	private int linhas;
	private int colunas;
	private int minas;

	// Todos os campos do tabuleiro.
	private final List<Campo> campos = new ArrayList<>();

	public Tabuleiro(int linhas, int colunas, int minas) {

		// Cria um tabuleiro com a quantidade de linhas, colunas e minas informadas.
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;

		gerarCampos();
		associarVizinhos();
		sortearMinas();
	}

	public void abrir(int linha, int coluna) {
		
		try {
			campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna).findFirst()
					.ifPresent(c -> c.abrir());
		} catch (ExplosaoException e) {
			campos.forEach(c -> c.setAberto(true));
			throw e;
		}
	}

	private void gerarCampos() {
		// Gera a matriz de campos com as dimensões passadas no construtor do tabuleiro.
		
		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				campos.add(new Campo(linha, coluna));
			}
		}
	}

	public void alternarMarcacao(int linha, int coluna) {
		// Marca ou desmarca um campo na posição informada.
		
		campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna).findFirst()
				.ifPresent(c -> c.alternarMarcacao());
	}

	private void sortearMinas() {
		// Aleatoriza a posição das minas de acordo com o tamanho do tabuleiro(campos) e quantidade de minas.
		
		long minasArmadas = 0;
		Predicate<Campo> minado = c -> c.isMinado();

		do {
			int aleatorio = (int) (Math.random() * campos.size());
			campos.get(aleatorio).minar();
			minasArmadas = campos.stream().filter(minado).count();
		} while (minasArmadas < minas);
	}

	public boolean objetivoAlcancado() {
		return campos.stream().allMatch(c -> c.objetivoAlcancado());
	}

	public void reiniciar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearMinas();
	}

	private void associarVizinhos() {
		for (Campo c1 : campos) {
			for (Campo c2 : campos) {
				c1.adicionarVizinho(c2);
			}
		}
	}

	public String toString() {
		// Faz uma representação do tabuleiro em formato de String.

		StringBuilder sb = new StringBuilder();

		sb.append("  ");
		for (int c = 0; c < colunas; c++) {
			sb.append(" ");
			sb.append(c);
			sb.append(" ");
		}

		sb.append("\n");

		int i = 0;
		for (int l = 0; l < linhas; l++) {
			sb.append(l);
			sb.append(" ");
			for (int c = 0; c < colunas; c++) {
				sb.append(" ");
				sb.append(campos.get(i));
				sb.append(" ");
				i++;
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}