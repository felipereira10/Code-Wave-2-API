package net.codewave.classes_de_conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	/*private static caminho ="jdbc:mysql://localhost/db_senhas";
	private static user ="root";
	private static senha = "fatec";*/
	
	public static Connection faz_conexao() throws SQLException, ClassNotFoundException {

			try {
				return DriverManager.getConnection("jdbc:mysql://localhost:3306/api", "root","102794");
			}catch (SQLException exception){
				throw new RuntimeException(exception);
			}

		//return DriverManeger.getConnection(caminho,user,senha);


	}
}
