package Exercicios.ExcecaoPersonalizadasChecadas;

import Exercicios.Aluno;

public class Validar {
    private Validar() {

    }

    public static void aluno(Aluno aluno) throws
            IllegalArgumentException, StringVaziaException, NumeroForaIntervaloException {
        /* Já nesta validação está sendo apontado que o método poderá gerar exceções.
           Exigindo o tratamento de todas que herdam de Exception. */

        if (aluno == null) {
            throw new IllegalArgumentException("O aluno está nulo!");
        }
        if (aluno.nome == null || aluno.nome.trim().isEmpty()) {
            throw new StringVaziaException("nome");
        }
        if (aluno.nota < 0 || aluno.nota > 10) {
            throw new NumeroForaIntervaloException("nota");
        }
    }
}
