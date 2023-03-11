package persistence;

import java.sql.*;

/**
 * Conexão geral com o banco de dados
 */
public class DBConnection {
    private String url;
    private String usuario;
    private String senha;
    Connection con = null;

    public DBConnection(String url, String usuario, String senha){
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Connection connection(){
        try{
            con = DriverManager.getConnection(url, usuario, senha);
        }catch (SQLException e){
            System.err.println("ERRO em DBConnection.connection: " + e.getMessage());
        }
        return con;
    }

    public Connection getConnection(){
        return con;
    }

    public void disconnect(){
        try {
            con.close();
        } catch (NullPointerException e) {
			System.err.println("ERRO em DBConnection.disconnect: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("ERRO em DBConnection.disconnect: " + e.getMessage());
		}
    }
}