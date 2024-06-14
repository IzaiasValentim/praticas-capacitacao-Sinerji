package Exercicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBancoDeDados {
	public static void main(String[] args) throws SQLException{
		
		String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
		
		String usuario = "root";
		String senha = "izaias123";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		// Os comandos SQL são realizados a partir do stmt.
		Statement stmt = conexao.createStatement();
		stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");
		
		conexao.close();
	}
}
