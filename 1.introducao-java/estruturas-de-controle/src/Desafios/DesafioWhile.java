package Desafios;

import java.util.Scanner;

public class DesafioWhile {
    public static void main(String[] args) {
        /*
            O programa deve calcular a média entre várias notas informadas.
        */

        Scanner entrada = new Scanner(System.in);
        int quantidadeDeNotas = 0;
        int nota = 0;
        int total = 0;

        while (nota != -1) {
            System.out.print("Informe a nota ou -1 para sair:");
            nota = entrada.nextInt();
            if(nota != -1){
                total += nota;
                quantidadeDeNotas++;
            }
        }
        double media = (double)total/quantidadeDeNotas;
        System.out.println("A média entre as notas informadas é: " + media);
        entrada.close();
    }
}
