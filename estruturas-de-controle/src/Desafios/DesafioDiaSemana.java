package Desafios;

import java.util.Scanner;

public class DesafioDiaSemana {
    public static void main(String[] args) {

        /*
            Desenvolver um programa que receba o dia da semana por extenso e retorne o equivalente numérico.
        */

        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe o dia da semana em texto e com acentos:");
        String dia = entrada.nextLine();

        if(dia.equalsIgnoreCase("domingo")){
            System.out.println("Domingo é o 1º dia da semana");
        }else if(dia.equalsIgnoreCase("segunda")){
            System.out.println("Segunda é o 2º dia da semana");
        }else if(dia.equalsIgnoreCase("terça")){
            System.out.println("Terça é o 3º dia da semana");
        }else if(dia.equalsIgnoreCase("quarta")){
            System.out.println("Quarta é o 4º dia da semana");
        }else if(dia.equalsIgnoreCase("quinta")){
            System.out.println("Quinta é o 5º dia da semana");
        }else if(dia.equalsIgnoreCase("sexta")){
            System.out.println("Sexta é o 6º dia da semana");
        }else if(dia.equalsIgnoreCase("sábado")){
            System.out.println("Sabado é o 7º dia da semana");
        }
        entrada.close();
    }
}
