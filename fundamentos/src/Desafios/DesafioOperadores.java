package Desafios;

public class DesafioOperadores {
    public static void main(String[] args) {
        // Implementar a expressão apresentada no vídeo.

        double potUm = Math.pow(6*(3+2),2);
        double potDois = Math.pow(((1-5)*(2-7))/2,2);
        double potTres = Math.pow(10,3);

        double potQuatro = Math.pow((potUm/(3*2) - potDois),3);

        double resultado = potQuatro/potTres;
        System.out.println("O resultado da expressão é:"+resultado);
    }
}
