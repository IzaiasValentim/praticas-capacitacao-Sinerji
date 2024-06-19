package Exercicios;
public class DAOTeste {

	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		String sql = "INSERT INTO pessoas (nome, codigo) VALUES (?, ?)";
		System.out.println(dao.incluir(sql, "Luis Izaias", 30));
		System.out.println(dao.incluir(sql, "Carlos", 31));
		System.out.println(dao.incluir(sql, "Samira", 32));
		
		dao.close();
	}
}
