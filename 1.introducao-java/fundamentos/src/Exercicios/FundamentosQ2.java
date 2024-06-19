package Exercicios;

import java.util.Scanner;

public class FundamentosQ2 {
    public static void main(String[] args) {
        /*
            Criar um programa que leia a temperatura em Celsius e converta para Fahrenheit.
            30c -> 86F.
         */
        
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe a temperatura em Celsius: ");
        double temperaturaCelsius = entrada.nextDouble();
        entrada.close();

        double temperaturaEmF = temperaturaCelsius/(5.0/9.0) + 32;

        System.out.printf("%.1f Celsius em Fahrenheit é: %.1f", temperaturaCelsius, temperaturaEmF);
    }
}
