package Exercicios;

public class EstruturasQ2 {
    public static void main(String[] args) {
        // Criar um programa informa se o ano atual é um ano bissexto
        double ano = 2020;

        if ((ano % 4 == 0.0 && ano % 100 != 0.0) || ano % 400 == 0.0) {
            System.out.println(ano + " é bissexto");
        } else {
            System.out.println(ano + " não é bissexto");
        }
    }
}
