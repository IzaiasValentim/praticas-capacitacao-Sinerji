package Desafios;

import java.util.Scanner;

public class DesafioArray {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe a quantidade de notas: ");
        int quantidade = entrada.nextInt();

        double[] notas = new double[quantidade];
        for (int i = 0; i < quantidade; i++) {
            System.out.printf("Informe a %d nota: ", i + 1);
            notas[i] = entrada.nextDouble();
        }
        double total = 0.0;
        for (double nota : notas) {
            total += nota;
        }
        double media = total / quantidade;
        System.out.printf("A média das notas é: %.2f\n", media);

        entrada.close();
    }
}
