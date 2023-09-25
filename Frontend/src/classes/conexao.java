/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Manhã
 */
public class conexao {
 
      public static Statement statement = null;

         // String com o caminho onde está o banco de dados
            String URL = "jdbc:mysql://localhost:3307/bd_login";
        // Login
           String usuario = "root";
        // Senha
           String senha = "usbw";
       // Variavel para o comando SQL
           private Statement stm = null;
       // Variavel para a conexão
          public Connection conecta = null;

      // Métodos Conectar e Desconectar Banco de Dados 

        public void conectar() throws ClassNotFoundException, SQLException 
       {
       
           // Carga do driver de conexão
              Class.forName("com.mysql.jdbc.Driver");
           // Fazendo a conexão
              conecta = DriverManager.getConnection(URL, usuario, senha);
             statement = (Statement) conecta.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
             ResultSet.CONCUR_UPDATABLE);
             
       }

       public void desconectar() throws SQLException
       {
           
            // Fechando a conexão
               conecta.close();
       }
   
      public static int runSQL(String sql) 
      {
           int qtdreg = 0;
     
           try
          {
               qtdreg = statement.executeUpdate(sql);
          }
          catch(SQLException sqlex)
         {
           System.out.println("Erro acesso ao BD"+ sqlex);
         }

         return qtdreg;
      }
   }


    

