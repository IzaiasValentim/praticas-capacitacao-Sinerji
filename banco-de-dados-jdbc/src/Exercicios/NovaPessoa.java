package Exercicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
	public static void main(String[] args) throws SQLException {
		// Cadastro de uma pessoa na tabela de pessoas.

		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe o seu nome:");
		String nomePessoa = entrada.nextLine();

		/*
		 * Esse tipo de string abre riscos para ataques de segurança. Pois pode ser
		 * explorado a concatenação da String para gerar um comando válido no banco.
		 * String sqlInsert = "INSERT INTO pessoas (nome) VALUES ('" + nomePessoa +
		 * "')";
		 */
		Connection conexao = FabricaConexao.getConexao();

		// Abaixo é o método seguro:

		String sqlInsert = "INSERT INTO pessoas(nome) VALUES (?)";

		PreparedStatement stmt = conexao.prepareStatement(sqlInsert);
		stmt.setString(1, nomePessoa);
		/*
		 * Também pode ser feito para settar o código:
		 * "INSERT INTO pessoas(nome, codigo) VALUES (?,?)"; Para settar o código:
		 * stmt.setInt(2, valor);
		 */

		stmt.execute();
		System.out.println(nomePessoa + " adicionado com sucesso!");

		// Fechando o scanner, conexao e stmt.
		entrada.close();
		stmt.close();
		conexao.close();
	}
}
