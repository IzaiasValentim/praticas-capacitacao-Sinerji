package Exercicios;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMax {

    public static void main(String[] args) {
        Aluno a1 = new Aluno("Lucia", 5);
        Aluno a2 = new Aluno("Lana", 5.1);
        Aluno a3 = new Aluno("Gui", 8.1);
        Aluno a4 = new Aluno("Gabi", 10);

        List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4);

        Comparator<Aluno> melhorNota = (aluno1, aluno2) -> {
            if (aluno1.getNota() > aluno2.getNota()) return 1;
            if (aluno1.getNota() < aluno2.getNota()) return -1;
            return 0;
        };

        Comparator<Aluno> piorNota = (aluno1, aluno2) -> {
            if (aluno1.getNota() > aluno2.getNota()) return -1;
            if (aluno1.getNota() < aluno2.getNota()) return 1;
            return 0;
        };

        System.out.println(alunos.stream().max(melhorNota).get());
        System.out.println(alunos.stream().min(piorNota).get());

        System.out.println(alunos.stream().min(melhorNota).get());
        System.out.println(alunos.stream().max(piorNota).get());
    }
}
