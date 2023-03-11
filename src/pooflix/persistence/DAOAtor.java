package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dominio.*;

/**
 * Gerenciador de conexão com o banco de dados - ator
 * Função: CRUD de ator
 */
public class DAOAtor {
    private Connection connection;

    public DAOAtor(Connection connection){
        this.connection = connection;
    }

    public int create(OBJPOOFlix obj){
        try {
            Ator ator = (Ator) obj;	
            String sql = String.format("INSERT INTO ator(idAtor, nomeAtor, nacionalidade) VALUES('%s', '%s', '%s')", ator.getid(), ator.getnome(), ator.getnacionalidade());
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOAtor.create" + e.getMessage());
			return -1;
        }
    }

    public List<Ator> read() {
		try {
			List<Ator> atores = new ArrayList<Ator>();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ator");
			while (rs.next()) {
                String id = rs.getString("idAtor");
                String nome = rs.getString("nomeAtor");
                String nacionalidade = rs.getString("nacionalidade");
				Ator ator = new Ator(id,nome,nacionalidade);
				
				atores.add(ator);
			}
			rs.close();			
			return atores;			
		} catch (SQLException e) {
			System.out.println("Problemas em DAOAtor.read" + e.getMessage());
			return null;
		}
	}

    public int update(OBJPOOFlix obj){
        try {
            Ator ator = (Ator) obj;	
            String sql = null;
            
            if(ator.getnome() != null && ator.getnacionalidade() != null){
                sql = String.format("UPDATE ator set nomeator = '"+ ator.getnome() +"', nacionalidade = '" + ator.getnacionalidade() +"' where idator = " + ator.getid());
            }else if(ator.getnome() != null)
                sql = String.format("UPDATE ator set nomeator = '"+ ator.getnome() +"' where idator = " + ator.getid());
            else if(ator.getnacionalidade() != null)
                sql = String.format("UPDATE ator set nacionalidade = '"+ ator.getnacionalidade() +"' where idator = " + ator.getid());
            else{
                return -1;
            }
            
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOAtor.update" + e.getMessage());
			return -1;
        }
    }

    public int delete(String id){
        try {
            String sql = String.format("DELETE FROM ator WHERE idator = " + id);
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOAtor.delete" + e.getMessage());
			return -1;
        }
    }

    public Ator getAtorByID(String id){
        String sql = String.format("SELECT * FROM ator where idator = %s", id);

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Ator ator = null;
            
            while(rs.next()){
                String idator = rs.getString("idator");
                String nome =  rs.getString("nomeator");
                String nacionalidade =  rs.getString("nacionalidade");
                ator = new Ator(idator, nome, nacionalidade);
            }
            return ator;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
   
}