package Exercicios;

import java.util.Scanner;

public class EstruturasQ9 {
    public static void main(String[] args) {
        // Crie um programa que recebe 10 valores e ao final imprima o maior número.

        Scanner entrada = new Scanner(System.in);
        int maiorNumero = 0;

        System.out.println("Digite 10 números:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            int numero = entrada.nextInt();

            if (numero > maiorNumero) {
                maiorNumero = numero;
            }
        }

        System.out.println("O maior número digitado foi: " + maiorNumero);
        entrada.close();
    }
}
