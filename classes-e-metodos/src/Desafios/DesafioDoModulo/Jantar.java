package Desafios.DesafioDoModulo;

public class Jantar {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Alguem", 60);
        Comida arroz = new Comida("Arroz",0.200);
        Comida macarrao = new Comida("Macarrao",0.100);
        Comida carne = new Comida("Bife", 0.100);
        // Peso dos alimentos em gramas.

        System.out.printf("%s seu peso antes da janta: %.2f kg's\n",pessoa.nome, pessoa.peso);

        pessoa.comer(arroz);
        pessoa.comer(macarrao);
        pessoa.comer(carne);

        System.out.printf("%s seu peso após a janta: %.2f kg's",pessoa.nome, pessoa.peso);
    }
}
