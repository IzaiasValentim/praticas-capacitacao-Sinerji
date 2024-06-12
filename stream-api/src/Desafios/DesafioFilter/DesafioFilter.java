package Desafios.DesafioFilter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter {

	public static void main(String[] args) {
		/*
			Implementar uma pipeline que faça as seguintes operações:
				-> Filtrar produtos que estão em super promoção: desconto >= 30%
				-> Que estão com frete grátis
				-> Também filtrar pelo preço relevante: preco >=500
				* Ps: os valores dos produtos já estão com o desconto aplicado.
		 */

		// Instanciamento de alguns produtos.
		Produto p1 = new Produto("Fogão", 935.00, 0.15, 250);
		Produto p2 = new Produto("Notebook", 4750.89, 0.35, 0);
		Produto p3 = new Produto("Caderno", 45, 0.19, 0);
		Produto p4 = new Produto("Impressora", 1200, 0.40, 0);
		Produto p5 = new Produto("iPad", 6000, 0.29, 0);
		Produto p6 = new Produto("Relogio", 680, 0.12, 0);
		Produto p7 = new Produto("Monitor", 800, 0.31, 0);

		// Criação de uma lista que contenha todos os produtos.
		List<Produto> produtos = 
				Arrays.asList(p1, p2, p3, p4, p5, p6, p7);
		
		// Predicate que retorna true se o desconto for mais que 0.3.
		Predicate<Produto> superPromocao = p -> p.getDesconto() >= 0.3;

		// Predicate que retorna true se o frete for grátis.
		Predicate<Produto> freteGratis = p -> p.getValorFrete() == 0;

		// Predicate que retorna true se o preço for relevante, p>=500.
		Predicate<Produto> precoRelevante = p -> p.getPreco() >= 500;

		// Function que recebe o Produto e retorna a mensagem promocional.
		Function<Produto, String> chamadaPromocional =
				p -> "Aproveitem nossas promoções " + p.getNome() + " por R$" + p.getPreco();

		// Implementação da pipeline que realiza os tratamentos solicitados.
		produtos.stream()
			.filter(superPromocao)
			.filter(freteGratis)
			.filter(precoRelevante)
			.map(chamadaPromocional)
			.forEach(System.out::println);
		
	}
}
