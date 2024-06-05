package Exercicios;

import java.util.Scanner;

public class FundamentosQ4 {
    public static void main(String[] args) {
        /*
            Criar um programa que leia um valor e apresente os resultados ao quadrado e ao cubo do valor.
        */
        
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int valor = entrada.nextInt();
        entrada.close();

        int quadrado = (int) Math.pow(valor, 2);
        int cubo = (int) Math.pow(valor, 3);
        System.out.printf("O quadrado  de %d é %d\n", valor, quadrado);
        System.out.printf("O cubo  de %d é %d", valor, cubo);
    }
}
