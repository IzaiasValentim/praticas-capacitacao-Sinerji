package Exercicios;

import java.util.Scanner;

public class EstruturasQ5 {
    public static void main(String[] args) {
        // Refatorar o exercício 04, utilizando a estrutura switch.

        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe o número: ");
        int numero = entrada.nextInt();
        entrada.close();

        int primo = 1;
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                primo = 0;
            }
        }
        switch (primo) {
            case 1:
                System.out.println(numero + " é primo.");
                break;
            case 0:
                System.out.println(numero + " não é primo.");
                break;
        }
    }
}
