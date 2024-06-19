package Exercicios.ExemplosNumeroPar;

public class ParesTeste {

    public static void main(String[] args) {
        // Exercício feito em aula que simula o Map<Key,Value>.
        // Não respeita a ordem de inclusão.

        Pares<Integer, String> resultadoConcurso = new Pares<>();

        resultadoConcurso.adicionar(1, "Izaias");
        resultadoConcurso.adicionar(2, "Joao");
        resultadoConcurso.adicionar(3, "Sara");
        resultadoConcurso.adicionar(4, "Sabrina");
        // Esse substitui o Joao.
        resultadoConcurso.adicionar(2, "Duda");

        System.out.println("1-"+resultadoConcurso.getValor(1));
        System.out.println("2-"+resultadoConcurso.getValor(2));
        System.out.println("3-"+resultadoConcurso.getValor(3));
        System.out.println("4-"+resultadoConcurso.getValor(4));
    }
}
