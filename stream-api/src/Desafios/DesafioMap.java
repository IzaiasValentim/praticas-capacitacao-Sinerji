package Desafios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioMap {
    public static void main(String[] args) {
        // 1. Gerar uma string com o valor binário de cada número.
        // 2. Inverter a string
        // 3. Converter de volta para inteiro(String binária invertida -> inteiro).

        // Lista de números
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Uso da interface que recebe uma String e retorna uma String.
        UnaryOperator<String> inverter =
                s -> new StringBuilder(s).reverse().toString();
        // Uso da interface que recebe uma String do número binário e o retorna convertido em inteiro.
        Function<String, Integer> binarioParaInt =
                s -> Integer.parseInt(s, 2);

        nums.stream()
                // Inteiro -> String do número binário
                .map(Integer::toBinaryString)
                // Inverte a String
                .map(inverter)
                // Converte de binário para inteiro.
                .map(binarioParaInt)
                .forEach(System.out::println);
    }
}
