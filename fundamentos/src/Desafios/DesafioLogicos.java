package Desafios;

public class DesafioLogicos {
    public static void main(String[] args) {
        // Realizar as verificações lógicas passadas na vídeo aula.

        boolean trabalhoTerca = true;
        boolean trabalhoQuinta = false;

        boolean tv50 = trabalhoTerca && trabalhoQuinta;
        boolean tv32 = trabalhoTerca ^ trabalhoQuinta;
        boolean sorvete = trabalhoTerca || trabalhoQuinta;

        System.out.println("Comprou TV 50: " + tv50);
        System.out.println("Comprou TV 32: " + tv32);
        System.out.println("Tomou sorvete: " + sorvete);

    }
}
