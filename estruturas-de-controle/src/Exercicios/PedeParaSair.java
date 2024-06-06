package Exercicios;

import java.util.Scanner;

public class PedeParaSair {
    public static void main(String[] args) {
        /* Exercício para criar um laço while infinito, mas com a opção de encerrar sua execução.*/
        Scanner entrada = new Scanner(System.in);

        String palavraChave = "";
        while(!palavraChave.equalsIgnoreCase("sair")){
            System.out.print("Qual a palavra mágica: ");
            palavraChave = entrada.nextLine();
        }
        System.out.print("Xau ^^)");
        entrada.close();
    }
}
