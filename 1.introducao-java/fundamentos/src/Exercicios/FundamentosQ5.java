package Exercicios;

import java.util.Scanner;

public class FundamentosQ5 {
    public static void main(String[] args) {
        /*
            Criar um programa que leia o valor da base e da altura de um triângulo e calcule a área.
            At = b * a/2
        */
        
        Scanner entrada =  new Scanner(System.in);

        System.out.print("Informe o valor da base do triangulo: ");
        double base = Double.parseDouble(entrada.nextLine().replace(",","."));
        System.out.print("Informe o valor da altura do triangulo: ");
        double altura =  Double.parseDouble(entrada.nextLine().replace(",","."));
        entrada.close();

        double areaTriangulo = base * altura/2;

        System.out.println("A área do triângulo é: "+areaTriangulo+" unidades de área.");

    }
}
