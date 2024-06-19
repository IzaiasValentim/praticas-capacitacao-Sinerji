package Exercicios;

import java.util.Scanner;

public class FundamentosQ1 {
    public static void main(String[] args) {
        /*
            Criar um programa que leia a temperatura em Fahrenheit e converta para Celsius.
            86F -> 30 Celsius
        */
        
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe a temperatura em Fahrenheit: ");
        double temperaturaF = entrada.nextDouble();
        entrada.close();

        double temperaturaEmCelsius = (temperaturaF- 32) * (5.0/9.0);

        System.out.printf("%.1f F em Celsius é: %.1f", temperaturaF, temperaturaEmCelsius);
    }
}
