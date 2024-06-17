package br.com.izaiasvalentim.app.calculo;

import br.com.izaiasvalentim.app.Calculadora;
import br.com.izaiasvalentim.app.calculo.interno.OperacoesAritmeticas;
import br.com.izaiasvalentim.app.logging.Logger;

public class CalculadoraImpl implements Calculadora {
	
	private String id = "abc";

	private OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();

	public double soma(double... numeros) {
		Logger.info("Somando...");
		return opAritmeticas.soma(numeros);
	}

	public String getId() {
		return id;
	}
}
