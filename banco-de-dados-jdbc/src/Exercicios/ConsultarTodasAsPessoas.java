package Exercicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarTodasAsPessoas {
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas";

		Statement stmt = conexao.createStatement();
		ResultSet retornoPessoas = stmt.executeQuery(sql);

		List<Pessoa> pessoas = new ArrayList<>();

		while (retornoPessoas.next()) {
			int codigo = retornoPessoas.getInt("codigo");
			String nome = retornoPessoas.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}
		
		pessoas.forEach(p -> System.out.println(p));
		
		// Fechando o stmt e conexao
		stmt.close();
		conexao.close();
	}
}
