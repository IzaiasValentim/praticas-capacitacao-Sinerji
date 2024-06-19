package br.com.izaiasvalentim.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.izaiasvalentim.cm.modelo.Campo;

public class CampoTeste {

	// Criação de um campo geral.
	private Campo campo;

	// Esta anotação repete o bloco antes do início de cada teste.
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);

	}

	// Distancia1-> é a posição ao lado.
	// Distancia2-> é a posição de diagonal.

	@Test
	void testeVizinhoRealDistancia1Esquerda() {
		// Criação de um possível vizinho.
		Campo vizinho = new Campo(3, 2);

		// Verifição se o vizinho pode ser vizinho.
		boolean resultado = campo.adicionarVizinho(vizinho);

		// Comando do JUnit que testa se o retorno é verdadeiro.
		assertTrue(resultado);

	}

	@Test
	void testeVizinhoRealDistancia1Direita() {
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoRealDistancia1Acima() {
		Campo vizinho = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoRealDistancia1ABaixo() {
		Campo vizinho = new Campo(4, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoRealDistancia2() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho() {
		// Sabemos que esse campo não será vizinho.
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
}
