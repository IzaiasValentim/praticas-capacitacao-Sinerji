package Exercicios;

import java.util.Scanner;

public class EstruturasQ8 {
    public static void main(String[] args) {
        // Criar um programa que receba uma palavra e imprime no console letra por letra.

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = entrada.nextLine();

        System.out.println("Letras da palavra informada:");

        for (int i = 0; i < palavra.length(); i++) {
            System.out.println(palavra.charAt(i));
        }
        entrada.close();
    }
}
