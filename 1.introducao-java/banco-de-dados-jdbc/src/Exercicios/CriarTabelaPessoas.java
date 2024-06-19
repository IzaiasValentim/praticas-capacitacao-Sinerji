package Exercicios;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoas {
	public static void main(String[] args) throws SQLException{
		Connection conexaoTabela = FabricaConexao.getConexao();
		
		String sqlGeral = "CREATE TABLE IF NOT EXISTS pessoas("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nome VARCHAR(80) NOT NULL"
				+ ");";
		
		Statement stmt = conexaoTabela.createStatement();
		stmt.execute(sqlGeral);

		System.out.println("Tabela criada com sucesso!");

		stmt.close();
		conexaoTabela.close();
	}
}
