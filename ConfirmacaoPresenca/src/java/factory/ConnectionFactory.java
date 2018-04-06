/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private Connection con = null;
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //string de conexao com criacao de BD caso nao exista
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ConfirmacaoPresenca?createDatabaseIfNotExist=true", "root", null);
            return con;
        } catch (ClassNotFoundException ntf) {//excption de caso nao encontrar o dirve
            System.out.println("Problema com o Driver.");
        } catch (SQLException sql) {
            System.out.println("Problema com conexão com BD");//caso problemas com o banco de dados
        }
        return null;
    }

}
