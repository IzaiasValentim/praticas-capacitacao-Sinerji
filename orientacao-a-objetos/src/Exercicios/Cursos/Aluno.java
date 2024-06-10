package Exercicios.Cursos;

import java.util.ArrayList;

public class Aluno {
    String nomeAluno;
    ArrayList <Curso> cursosDoAluno = new ArrayList<>();
    Aluno(String nomeAluno){
        this.nomeAluno = nomeAluno;
    }
    void verCursos(){
        int c = 0;
        System.out.println("Lista de cursos de "+this.nomeAluno+":");
        for(Curso curso : cursosDoAluno){
            System.out.println(c+1+"-"+curso.nomeCurso);
            c++;
        }
        System.out.println();
    }
}
