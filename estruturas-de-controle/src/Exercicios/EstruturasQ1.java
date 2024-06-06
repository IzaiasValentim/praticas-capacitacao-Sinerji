package Exercicios;

public class EstruturasQ1 {
    public static void main(String[] args) {
        // Criar um programa que receba um número e verifique se ele está entre 0 e 10 e é par;
        int numero = 9;

        if (numero >= 0 && numero <= 10) {
            System.out.print("O número informado está entre 0 à 10 e ");
        } else {
            System.out.print("O número não está entre 0 à 10 e ");
        }
        if (numero % 2 == 0) {
            System.out.print("é par.");
        } else {
            System.out.print("não é par.");
        }
    }
}
