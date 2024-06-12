package Exercicios.ExcecaoPersonalizadasChecadas;

import Exercicios.Aluno;

public class TesteValidacoes {
    public static void main(String[] args) {
        /* No teste pode ser verificado se o aluno é nulo, se seu nome está vazio ou nulo ou
           também o intervalo da nota está entre 0 à 10. */

        try {
            // Aqui, Validar.aluno() necessáriamente requer o tratamento de todas as exceções.
            Aluno primeiroAluno = new Aluno("Izaias", 6, true);
            Validar.aluno(primeiroAluno);

        } catch (StringVaziaException | NumeroForaIntervaloException e) {

            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            // opcional por IllegalArgumentException herda de RuntimeException.

            System.out.println(e.getMessage());
        }
        System.out.println("O aluno está ok");
        // A validação fora do try-catch vai apontar erro.
        // Validar.aluno(primeiroAluno);
    }
}
