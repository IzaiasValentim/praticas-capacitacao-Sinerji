package br.com.izaiasvalentim.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.izaiasvalentim.cm.excecao.ExplosaoException;

public class Campo {
	// Linhas e Colunas do campo.
	private final int linha;
	private final int coluna;

	// Estados que um capo pode estar.
	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;

	// Campos adjacentes a um campo.
	private List<Campo> vizinhos = new ArrayList<>();

	Campo(int linha, int coluna) {

		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public boolean adicionarVizinho(Campo vizinho) {
		/*
		 * Lógica que define se um campo é ou não vizinho do outro, em linha, coluna ou
		 * diagonal.
		 */
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;

		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;

		if (deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else if (deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else {
			return false;
		}
	}

	void alternarMarcacao() {
		// Ação de marcar um campo com possível mina.
		
		if (!aberto) {
			marcado = !marcado;
		}
	}

	boolean abrir() {
		// Revelar campo, pode ser o fim do jogo.
		
		if (!aberto && !marcado) {
			aberto = true;
			if (minado) {
				throw new ExplosaoException();
			}
			if (vizinhancaSegura()) {
				// Abre todos os campos seguros.
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		}
		return false;
	}

	boolean vizinhancaSegura() {
		// Verifica se a vizinhança está segura.
		
		return vizinhos.stream().noneMatch(v -> v.minado);
	}

	void minar() {
		minado = true;
	}
	
	public boolean isMinado() {
		return minado;
	}

	public boolean isMarcado() {
		return marcado;
	}
	
	void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public boolean isAberto() {
		return aberto;
	}

	boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;

		return desvendado || protegido;
	}

	long minasNaVizinhanca() {
		// Soma a quantidade de campos vizinhos que são minadas e as retorna.
		
		return vizinhos.stream().filter(v -> v.minado).count();
	}

	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
	}

	public String toString() {
		// Retorna a situação do campo de acordo com os estados booleanos verificados.
		
		if (marcado) {
			return "X";
		} else if (aberto && minado) {
			return "*";
		} else if (aberto && minasNaVizinhanca() > 0) {
			return Long.toString(minasNaVizinhanca());
		} else if (aberto) {
			return " ";
		} else {
			return "?";
		}
	}
}
