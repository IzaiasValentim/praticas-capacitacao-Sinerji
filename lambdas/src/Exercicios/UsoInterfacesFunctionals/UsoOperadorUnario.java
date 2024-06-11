package Exercicios.UsoInterfacesFunctionals;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UsoOperadorUnario {
    public static void main(String[] args) {
        UnaryOperator<Integer> dobro =
                numero -> numero*2;
        List<Integer> listaDeNumeros = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("O dobro da lista de números: ");
        listaDeNumeros.forEach(numero ->{
            System.out.printf("\nO dobro de %d é %d", numero, dobro.apply(numero));
        });
    }
}
