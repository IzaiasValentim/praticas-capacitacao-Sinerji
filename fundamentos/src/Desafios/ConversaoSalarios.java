package Desafios;

import java.util.Scanner;

public class ConversaoSalarios {
    public static void main(String[] args) {
        /*
            Ler e calcular a  média entre 3 salários informados.
        */
        
        Scanner entradaSalario = new Scanner(System.in);

        System.out.print("Informe o seu primeiro salário:");
        String salUm = entradaSalario.next().replace(",",".");

        System.out.print("Informe o seu segundo salário:");
        String salDois = entradaSalario.next().replace(",",".");

        System.out.print("Informe o seu terceiro salário:");
        String salTres = entradaSalario.next().replace(",",".");

        double salarioUm = Double.parseDouble(salUm);
        double salarioDois = Double.parseDouble(salDois);
        double salarioTres = Double.parseDouble(salTres);

        double  media = (salarioUm + salarioDois + salarioTres) /3;

        System.out.println("A média dos salários é: "+media);
        entradaSalario.close();
    }
}
