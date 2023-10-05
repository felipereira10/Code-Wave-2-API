package classes_de_conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	/*private static caminho ="jdbc:mysql://localhost/db_senhas";
	private static user ="root";
	private static senha = "fatec";*/
	
	public static Connection faz_conexao() throws SQLException{
		
		
		try {
		
		Class.forName("com.mysql.jdbc.Driver");	
		
		return DriverManager.getConnection("jdbc:mysql://localhost/db_senhas","root","fatec");

		//return DriverManeger.getConnection(caminho,user,senha);
				
		 
		
			
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getException());
			
		}
		
	}
}
