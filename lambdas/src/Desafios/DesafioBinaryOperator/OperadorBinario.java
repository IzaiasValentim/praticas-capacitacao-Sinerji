package Desafios.DesafioBinaryOperator;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperadorBinario {
    public static void main(String[] args) {
        /*
         * Calcular o preço real do produto
         * Imposto municipal >=2500 (8.5%) <2500 insento
         * Frete >=3000 (100) <3000(50)
         * Arredondar
         * Formatar: R$ valor
         */

        // Criação de 2 produtos
        Produto teclado = new Produto("Teclado", 75.50, 0.02);
        Produto ipad = new Produto("Ipad", 3235.89, 0.13);

        // Uso das interfaces disponibilizadas pelo java.
        Function<Produto, Double> precoFinal =
                produto -> produto.preco * (1 - produto.desconto);

        UnaryOperator<Double> impostoMunicipal =
                preco -> preco >= 2500 ? preco * 1.085 : preco;

        UnaryOperator<Double> frete =
                preco -> preco >= 3000 ? preco + 100 : preco + 50;

        UnaryOperator<Double> arredondar =
                preco -> Double.parseDouble(String.format("%.2f", preco).replace(",", "."));

        Function<Double, String> formatar =
                preco -> ("R$" + preco).replace(".", ",");

        // Calls e resultados
        String preco = precoFinal
                .andThen(impostoMunicipal)
                .andThen(frete)
                .andThen(arredondar)
                .andThen(formatar)
                .apply(teclado);
        System.out.println("Preco final do teclado:" + preco);

        String precoIpad = precoFinal
                .andThen(impostoMunicipal)
                .andThen(frete)
                .andThen(arredondar)
                .andThen(formatar)
                .apply(ipad);
        System.out.println("Preco final do teclado:" + precoIpad);
    }
}
