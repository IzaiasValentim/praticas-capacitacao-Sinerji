package br.com.izaiasvalentim.app.financeiro;

import java.lang.reflect.Field;
import java.util.ServiceLoader;

import br.com.izaiasvalentim.app.Calculadora;

public class Teste {

	public static void main(String[] args) {
		
		Calculadora calc = ServiceLoader
				.load(Calculadora.class)
				.findFirst()
				.get();
		// Resultado da soma.
		System.out.println(calc.soma(2, 2, 2));

		try {
			Field fieldId = calc.getClass().getDeclaredFields()[0];
			fieldId.setAccessible(true);
			fieldId.set(calc, "def");
			fieldId.setAccessible(false);

			System.out.println(calc.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
