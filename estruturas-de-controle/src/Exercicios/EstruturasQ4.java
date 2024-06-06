package Exercicios;

import java.util.Scanner;

public class EstruturasQ4 {
    public static void main(String[] args) {
        // Criar um programa que receba um número e diga se ele é um número primo.

        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe o número: ");
        int numero = entrada.nextInt();
        entrada.close();

        boolean primo = true;
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                primo = false;
            }
        }
        if (primo) {
            System.out.println(numero + " é primo.");
        } else {
            System.out.println(numero + " não é primo.");
        }
    }
}
