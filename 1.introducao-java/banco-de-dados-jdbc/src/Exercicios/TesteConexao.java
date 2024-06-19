package Exercicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
	public static void main(String[] args) throws SQLException {
		// Definição da string de conexão
		final String stringDeConexao = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
		
		// Credênciais de acesso ao banco de dados.
		final String usuarioConexao = "root";
		final String senhaConexao = "izaias123";
		
		// Realizando a conexâo
		// Gera uma exceção checada. Logo é necessário tratar ou declara no método main.
		Connection conexaoMysql = DriverManager.getConnection(stringDeConexao, usuarioConexao, senhaConexao);
		
		System.out.println("Conexão realizada com sucesso!");
		conexaoMysql.close();
	}
}
