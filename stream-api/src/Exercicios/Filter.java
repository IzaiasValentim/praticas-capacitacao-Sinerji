package Exercicios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Filter {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("Ana", 7.5, false);
		Aluno a2 = new Aluno("Luis", 9.8, true);
		Aluno a3 = new Aluno("Diego", 8.8, true);
		Aluno a4 = new Aluno("Otavio", 4.4, true);

		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4);
		
		Predicate<Aluno> aprovado = a -> a.getNota() >= 7;
		Predicate<Aluno> bomComportamento = a -> a.isBomComportamento();
		Function<Aluno, String> saudacaoAprovado =
				a -> "Parabéns " + a.getNome() + "! Você foi aprovado(a).";
		
		alunos.stream()
			.filter(aprovado)
			.filter(bomComportamento)
			.map(saudacaoAprovado)
			.forEach(System.out::println);
	}
}
