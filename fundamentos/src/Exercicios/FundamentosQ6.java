package Exercicios;

import java.util.Scanner;

public class FundamentosQ6 {
    public static void main(String[] args) {
        /*
            Criar um programa que resolve equações do segundo grau (ax2 + bx + c = 0) utilizando a fórmula de Bhaskara.
            Use como exemplo a = 1, b = 12 e c = -13. Encontre o delta.
            delta = b2 - 4ac.
            x'' = -b +- sqrt(delta)/2a
        */

        Scanner  entrada = new Scanner(System.in);

        System.out.print("Informe a: ");
        int a = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Informe b: ");
        int b = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Informe c: ");
        int c = entrada.nextInt();
        entrada.close();

        int delta = (int) Math.pow(b,2) - 4*a*c;
        double x1 = (-b + Math.sqrt(delta))/(2*a);
        double x2 = (-b - Math.sqrt(delta))/(2*a);

        System.out.printf("Resultados: delta = %d x' = %.1f x'' = %.1f",delta, x1, x2);
    }
}
