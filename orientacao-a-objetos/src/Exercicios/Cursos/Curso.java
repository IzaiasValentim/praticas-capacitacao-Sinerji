package Exercicios.Cursos;

import java.util.ArrayList;

public class Curso {
    String nomeCurso;
    ArrayList<Aluno>  listaDeAlunos = new ArrayList<>();

    Curso(String nome){
        this.nomeCurso = nome;
    }
    void matricularAluno(Aluno aluno){
        listaDeAlunos.add(aluno);
        aluno.cursosDoAluno.add(this);
    }

    void verAlunos(){
        int c = 0;
        System.out.println("Lista de alunos do curso de "+this.nomeCurso+":");
        for(Aluno aluno : listaDeAlunos){
            System.out.println(c+1+"-"+aluno.nomeAluno);
            c++;
        }
        System.out.println();
    }
}
