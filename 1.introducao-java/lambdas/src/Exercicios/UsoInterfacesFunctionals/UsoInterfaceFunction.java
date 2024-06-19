package Exercicios.UsoInterfacesFunctionals;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class UsoInterfaceFunction {
    public static void main(String[] args) {
        // Primeira forma:
        Function<Integer, String> parOuImpar =
                numero -> numero % 2 == 0 ? "Par" : "Ímpar";

        List<Integer> listaDeNumeros = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Número pares ou ímpares");
        listaDeNumeros.forEach(numero ->
                System.out.printf("\n%d é %s", numero, parOuImpar.apply(numero))
        );

        // Segunda forma:
        System.out.println("\nNumero pares ou ímpas com concatenação: ");
        Function<String, String> resultado =
                paridade -> "é " + paridade;
        listaDeNumeros.forEach(numero ->
                System.out.println(numero + " " + parOuImpar.andThen(resultado).apply(numero))
        );


    }
}
