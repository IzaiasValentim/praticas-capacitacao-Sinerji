package Desafios.DesafioBinaryOperator;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperadorBinario {
        public static void main(String[] args) {
                /*
                 * Calcular o preço real do produto após a aplicação dos filtros abaixo:
                 * 
                 * -> Imposto municipal de 8.5% para produtos >=2500 e menores que 2500 serão
                 * insentos.
                 * -> Frete 100 para produtos com preço >=3000 e Frete 50 para produtos com
                 * preço < 3000.
                 * -> Arredondar
                 * -> Formatar para o seguinte estilo: R$ valor
                 */

                // Criação de 2 produtos
                Produto teclado = new Produto("Teclado", 75.50, 0.02);
                Produto ipad = new Produto("Ipad", 3235.89, 0.13);


                // Aplicação do desconto com o uso da interface funcional
                // Function<E,R> que recebe uma entrada E e retorna o tipo R.
                Function<Produto, Double> precoFinal = produto -> produto.preco * (1 - produto.desconto);

                // Aplicação do imposto municipal de acordo com o preço do produto após o
                // desconto. É utilizado
                // UnaryOperator<T> que recebe um tipo e retorna o mesmo.
                UnaryOperator<Double> impostoMunicipal = preco -> preco >= 2500 ? preco * 1.085 : preco;

                // Aplicação do frete após o cálculo do desconto de frente.
                UnaryOperator<Double> frete = preco -> preco >= 3000 ? preco + 100 : preco + 50;

                UnaryOperator<Double> arredondar = preco -> Double
                                .parseDouble(String.format("%.2f", preco).replace(",", "."));

                Function<Double, String> formatar = preco -> ("R$ " + preco);

                // Calls e resultados
                String precoTeclado = precoFinal
                                .andThen(impostoMunicipal)
                                .andThen(frete)
                                .andThen(arredondar)
                                .andThen(formatar)
                                .apply(teclado);
                System.out.println("Preco final do teclado: " + precoTeclado);

                String precoIpad = precoFinal
                                .andThen(impostoMunicipal)
                                .andThen(frete)
                                .andThen(arredondar)
                                .andThen(formatar)
                                .apply(ipad);
                System.out.println("Preco final do ipad: " + precoIpad);
        }
}
