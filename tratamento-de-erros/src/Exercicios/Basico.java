package Exercicios;

public class Basico {
    public static void main(String[] args) {
        // Este exercício serviu como aula introdutória aos erros e tratamento de exceções básicas.

        String nome = null;

        try {
            imprimirNome(nome);
        } catch (Exception excecaoNome) {
            // É uma má prática silenciar um erro. Ps: omitir a saída.
            System.out.println("Ocorreu um erro ao imprimir o nome");
        }

        try {
            // Gerando erros propositalmente. Divisão por 0.
            System.out.println(7 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }

        // Se o programa ocorrer bem, lidar com todas as exceções, chegará até aqui.
        System.out.println("Fim :)");
    }

    public static void imprimirNome(String nome) {
        // Gerando erros propositalmente
        // -> Solicitar uma posição específica que não existirá, nome será null.
        System.out.println(nome.charAt(3));
    }
}
