package Desafios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exercicios.FabricaConexao;
import Exercicios.Pessoa;
import Exercicios.FabricaConexao;

public class DesafioConsultaPessoaComParametro {
	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner(System.in);
		Connection conexao = FabricaConexao.getConexao();

		String sql = "SELECT * FROM pessoas WHERE nome like ?";

		System.out.print("Informe o nome da pesquisa:");
		String nomePesquisa = entrada.nextLine();

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "%" + nomePesquisa + "%");
		ResultSet resultado = stmt.executeQuery();

		List<Pessoa> pessoas = new ArrayList<>();

		while (resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}

		pessoas.forEach(p -> System.out.println(p));
		System.out.println("Fim!");
		
		// Closes
		entrada.close();
		conexao.close();
		stmt.close();

	}

}
