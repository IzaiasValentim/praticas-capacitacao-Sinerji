package Exercicios;

public class CalculoTeste {
    public static void main(String[] args) {
        Calculo soma = (x, y) -> {
            return x + y;
        };
        Calculo multiplicacao = (x, y) -> {
            return x * y;
        };


        System.out.println("Soma: " + soma.executar(2, 2));
        System.out.println("Multiplicacao: " + multiplicacao.executar(2, 2));

        Calculo calc = (x,y) -> x*y;
    }
}
