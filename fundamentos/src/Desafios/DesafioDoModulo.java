package Desafios;

import java.util.Scanner;

public class DesafioDoModulo {
    public static void main(String[] args) {
        /*
        Neste desafio o instrutor solicita o desenvolvimento de uma calculadora com o uso dos conhecimentos passados
        até o momento.
        */

        Scanner entrada = new Scanner(System.in);

        System.out.println("Qual operação deseja realizar: + - * / ?:");
        String operacao = entrada.nextLine();

        System.out.print("Informe o primeiro número: ");
        int primeiro = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Informe o segundo número: ");
        int segundo = entrada.nextInt();

        entrada.close();

        double resultado;
        resultado = operacao.equals("+") ?  primeiro+segundo:0;
        resultado = operacao.equals("-") ?  primeiro-segundo:resultado;
        resultado = operacao.equals("*") ?  primeiro*segundo:resultado;
        resultado = operacao.equals("/") ?  (double)primeiro/segundo:resultado;

        System.out.printf("%d %s %d  = %.1f", primeiro, operacao, segundo, resultado);

    }
}
