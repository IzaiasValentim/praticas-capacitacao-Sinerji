package Exercicios;

import java.util.Arrays;
import java.util.List;

public class ForeachAula {
    public static void main(String[] args) {
        List<String> aprovados = Arrays
                .asList("Izaias","Diega","Otávia");
        // Percorrer pelo foreach comum:
        System.out.println("Lista de aprovados(foreach comum): ");
        for(String nome : aprovados){
            System.out.println("-"+nome);
        }
        System.out.println("Lista de aprovados(com lambda): ");
        aprovados.forEach((nome) ->{
            System.out.println("()->"+nome);
        });
    }
}
