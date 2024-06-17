package Desafios;

public class DesafioOperadores {
    public static void main(String[] args) {
        // Implementar a expressão apresentada no vídeo.

        double parteUm = Math.pow(6 * (3 + 2), 2);
        double parteDois = Math.pow(((1 - 5) * (2 - 7)) / 2, 2);
        double parteTres = Math.pow(10, 3);

        double parteQuatro = Math.pow((parteUm / (3 * 2) - parteDois), 3);

        double resultado = parteQuatro / parteTres;
        System.out.println("O resultado da expressão é: " + resultado);
    }
}
