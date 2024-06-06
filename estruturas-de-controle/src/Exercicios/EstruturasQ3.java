package Exercicios;

import java.util.Scanner;

public class EstruturasQ3 {
    public static void main(String[] args) {
        /*Criar um programa que receba duas notas parciais, calcular a média final. Se a nota do aluno for maior ou
        igual a 7.0 imprime no console "Aprovado", se a nota for menor que 7.0 e maior do que 4.0 imprime no console
        "Recuperação", caso contrário imprime no console "Reprovado".
        */
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe a primeira nota: ");
        double notaUm = Double.parseDouble(entrada.nextLine().replace(",","."));
        System.out.print("Informe a segunda nota: ");
        double notaDois = Double.parseDouble(entrada.nextLine().replace(",","."));
        entrada.close();

        double media = (notaUm+notaDois)/2;
        if(media >= 7.0){
            System.out.println("Aprovado, média: "+ media);
        }else if(media > 4){
            System.out.println("Recuperação, média:"+ media);
        }else{
            System.out.println("Reprovado, média:"+ media);
        }
    }
}
