package Exercicios.ExcecaoPersonalizadaNaoChecadas;

import Exercicios.Aluno;

public class TesteValidacoes {
    public static void main(String[] args) {
        /* No teste pode ser verificado se o aluno é nulo, se seu nome está vazio ou nulo ou
           também o intervalo da nota está entre 0 à 10. */
        try {

            Aluno primeiroAluno = new Aluno("Izaias", 6, true);
            Validar.aluno(primeiroAluno);
            Validar.aluno(null);

        } catch (StringVaziaException | NumeroForaIntervaloException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
