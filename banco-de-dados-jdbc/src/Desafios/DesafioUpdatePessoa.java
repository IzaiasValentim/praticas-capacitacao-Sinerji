package Desafios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Exercicios.FabricaConexao;
import Exercicios.Pessoa;

public class DesafioUpdatePessoa {
	public static void main(String[] args) throws SQLException {
		// Neste desafios devemos atualizar o registro do código informado. Alterando o
		// nome.

		Scanner entrada = new Scanner(System.in);
		Connection conexao = FabricaConexao.getConexao();

		// Entrada do código para pesquisa e limpeza do buffer.
		System.out.print("Informe o código da pessoa:");
		int codigoPesquisa = entrada.nextInt();
		entrada.nextLine();

		// Criando e realizando a primeira consulta pelo código.
		String sql = "SELECT nome FROM pessoas WHERE codigo = ?;";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, codigoPesquisa);
		ResultSet resultadoPesquisa = stmt.executeQuery();
		
		Pessoa pessoaPesquisada = null;
		
		if (resultadoPesquisa.next()) {
			
			String nome = resultadoPesquisa.getString("nome");
			pessoaPesquisada = new Pessoa(codigoPesquisa, nome);

			System.out.print(pessoaPesquisada.getNome() + " foi encontrada, informe o seu novo nome:");

			pessoaPesquisada.setNome(entrada.nextLine());
			
			// Encerrando o statement da primeira consulta.
			stmt.close();
			
			// Mudando o comando sql para realizar o update.
			sql = "UPDATE pessoas SET nome = ? WHERE codigo = ?;";
			
			// Aqui é criado um novo statement.
			stmt = conexao.prepareStatement(sql);
			
			// Passando os campos para a query.
			stmt.setString(1, pessoaPesquisada.getNome());
			stmt.setInt(2, pessoaPesquisada.getCodigo());
			
			// Executando.
			stmt.execute();

			System.out.println("Atualizada com sucesso!");
		} else {
			System.out.println("Não foi encontrada uma pessoa com o código[" + codigoPesquisa + "] informado");
		}

		entrada.close();
		stmt.close();
		conexao.close();

	}
}
