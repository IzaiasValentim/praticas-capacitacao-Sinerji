package Exercicios;

import java.util.Scanner;

public class EstruturasQ7 {
    public static void main(String[] args) {
        /*
         Criar um programa que enquanto estiver recebendo números positivos, imprime no console a soma dos números
         inseridos, caso receba um número negativo, encerre o programa. Tente utilizar a estrutura do while.
        */

        Scanner entrada = new Scanner(System.in);
        int soma = 0;
        int numero;

        System.out.println("Digite números positivos para somar. Digite um número negativo para encerrar.");

        while (true) {
            System.out.print("Digite um número: ");
            numero = entrada.nextInt();

            if (numero < 0) {
                break;
            }

            soma += numero;
            System.out.println("Soma atual: " + soma);
        }

        System.out.println("Soma final: " + soma);
        entrada.close();
    }
}
