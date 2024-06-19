package Exercicios.Cursos;

public class Instituicao {
    public static void main(String[] args) {
        // Exemplo de classes que representam um relacionamente muitos para muitos.
        // Um curso pode ter muitos alunos. E um aluno pode estar em mais de um curso.

        // Instanciamento de dois cursos.
        Curso TI = new Curso("Tecnologia da informaçao");
        Curso Arquitetura = new Curso("Arquitetura");

        //  Instanciamento de dois alunos
        Aluno  umAlunoTI = new Aluno("Aluno um TI");
        Aluno  outroAlunoTI = new Aluno("Aluno dois TI e Arq ");
        Aluno alunoArq = new Aluno("Aluno tres Arquitetura");

        //Adição dos alunos nos seus cursos
        TI.matricularAluno(umAlunoTI);
        TI.matricularAluno(outroAlunoTI);

        Arquitetura.matricularAluno(alunoArq);
        Arquitetura.matricularAluno(outroAlunoTI);
        // Exemplo de saídas dos alunos em cada curso:
        TI.verAlunos();
        Arquitetura.verAlunos();

        // Exemplo de saídas dos cursos em que cada aluno  está  matriculado
        umAlunoTI.verCursos();
        outroAlunoTI.verCursos();
        alunoArq.verCursos();

    }
}
