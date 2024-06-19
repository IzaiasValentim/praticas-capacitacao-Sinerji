package Exercicios;

import java.util.Scanner;

public class FundamentosQ3 {
    public static void main(String[] args) {
        /*
            Criar um programa que leia o peso e a altura do usuário e imprima no console o IMC.
            imc = peso/altura*altura
        */
        
        Scanner entrada =  new Scanner(System.in);

        System.out.print("Informe o seu peso: ");
        double peso = Double.parseDouble(entrada.nextLine().replace(",","."));
        System.out.print("Informe sua altura: ");
        double altura =  Double.parseDouble(entrada.nextLine().replace(",","."));
        entrada.close();
        double imc = peso/Math.pow(altura,2);

        System.out.printf("Seu IMC é %.2f", imc);
    }
}
