package Exercicios;

import java.util.Random;
import java.util.Scanner;

public class EstruturasQ6 {
    public static void main(String[] args) {
        /* Jogo da adivinhação: Tentar adivinhar um número entre 0 - 100. Armazene um numero aleatório em uma variável.
         O Jogador tem 10 tentativas para adivinhar o número gerado. Ao final de cada tentativa, imprima a quantidade
         de tentativas restantes, e imprima se o número inserido é maior ou menor do que o número armazenado.
        */

        Random random = new Random();
        Scanner entrada = new Scanner(System.in);

        int numeroAleatorio = random.nextInt(101);
        int numeroDeTentativas = 10;
        boolean ganhou = false;

        System.out.println("Adivinhe o número entre 0 e 100.");

        while (numeroDeTentativas > 0) {
            System.out.print("Palpite: ");
            int palpite = entrada.nextInt();
            numeroDeTentativas--;

            if (palpite == numeroAleatorio) {
                System.out.println("Você adivinhou o número correto.");
                ganhou = true;
                break;
            } else if (palpite > numeroAleatorio) {
                System.out.println("O número inserido é maior do que o número armazenado.");
            } else {
                System.out.println("O número inserido é menor do que o número armazenado.");
            }

            System.out.println("Você tem " + numeroDeTentativas + " tentativas restantes.");
        }

        if (!ganhou) {
            System.out.println("Suas tentativas acabaram. O número era :" + numeroAleatorio + ".");
        }

        entrada.close();
    }
}
