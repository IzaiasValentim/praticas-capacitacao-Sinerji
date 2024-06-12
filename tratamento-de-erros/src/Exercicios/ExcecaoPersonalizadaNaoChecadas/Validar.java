package Exercicios.ExcecaoPersonalizadaNaoChecadas;

import Exercicios.Aluno;

public class Validar {
    // Classe feita para validar os campos de um aluno.
    private Validar() {
    }

    public static void aluno(Aluno aluno) {
        // Exceções não checadas.

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
