package Desafios.DesafioDoPolimorfismo;

public class Jantar {
    public static void main(String[] args) {
        // Usar o polimorfismo dinâmico para fazer um jantar.

        Pessoa alguem = new Pessoa(75.450);

        Arroz arrozBranco = new Arroz(0.350);
        Feijao feijaoPreto = new Feijao(0.120);

        // Convidado antes do jantar:
        System.out.println("Peso antes do jantar "+alguem.getPeso()+"kgs");
        alguem.comer(arrozBranco);
        alguem.comer(feijaoPreto);
        System.out.println("Peso após do jantar "+alguem.getPeso()+"kgs");
        Sorvete sorvete = new Sorvete(0.250);
        alguem.comer(sorvete);
        System.out.println("Peso após a sobremesa "+alguem.getPeso()+"kgs");

    }
}
