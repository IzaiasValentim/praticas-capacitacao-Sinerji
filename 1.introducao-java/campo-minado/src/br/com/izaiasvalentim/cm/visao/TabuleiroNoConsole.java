package br.com.izaiasvalentim.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.izaiasvalentim.cm.excecao.ExplosaoException;
import br.com.izaiasvalentim.cm.excecao.SairException;
import br.com.izaiasvalentim.cm.modelo.Tabuleiro;

public class TabuleiroNoConsole {

	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);

	public TabuleiroNoConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;

		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;

			while (continuar) {
				cicloDoJogo();

				System.out.println("Quer partida? (S/n) ");
				String resposta = entrada.nextLine();

				if ("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reiniciar();
				}
			}
		} catch (SairException e) {
			System.out.println("Xau!");
		} finally {
			entrada.close();
		}
	}

	private void cicloDoJogo() {
		try {

			while (!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);

				String digitado = capturarValorDigitado("Digite (linha, coluna): ");

				Iterator<Integer> xy = Arrays.stream(digitado.split(",")).map(e -> Integer.parseInt(e.trim()))
						.iterator();

				digitado = capturarValorDigitado("1 - Abrir ou 2 - (Des)Marcar: ");

				if ("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				} else if ("2".equals(digitado)) {
					tabuleiro.alternarMarcacao(xy.next(), xy.next());
				}
			}

			System.out.println(tabuleiro);
			System.out.println("Parabéns, Você ganhou :)");
		} catch (ExplosaoException e) {
			System.out.println(tabuleiro);
			System.out.println("Você perdeu :c");
		}
	}

	private String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();

		if ("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}

		return digitado;
	}
}
