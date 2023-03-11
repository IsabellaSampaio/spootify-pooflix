package persistence;

import java.sql.*;
import dominio.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Gerenciador de conexão com o banco de dados - Personagem
 * Função: CRUD de Personagem
 */
public class DAOPersonagem {
    private Connection connection;

    public DAOPersonagem(Connection connection){
        this.connection = connection;
    }

    public int create(OBJPOOFlix obj){
        try {
            Personagem personagem = (Personagem) obj;	
            String sql = String.format("INSERT INTO personagem(idPersonagem, nomePersonagem) VALUES('%s', '%s')", personagem.getid(), personagem.getnome());
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOPersonagem.create" + e.getMessage());
			return -1;
        }
    }

    public List<Personagem> read() {
		try {
			List<Personagem> personagens = new ArrayList<Personagem>();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM personagem");
			while (rs.next()) {
                String id = rs.getString("idPersonagem");
                String nome = rs.getString("nomePersonagem");
				Personagem personagem = new Personagem(id,nome);
				
				personagens.add(personagem);
			}
			rs.close();
			return personagens;			
		} catch (SQLException e) {
			System.out.println("Problemas em DAOPersonagem.read" + e.getMessage());
			return null;
		}
	}

    public int update(OBJPOOFlix obj){
        try {
            Personagem personagem = (Personagem) obj;	
            String sql = null;

            if(personagem.getnome() != null)
                sql = String.format("UPDATE personagem set nomepersonagem = '"+ personagem.getnome() +"' where idpersonagem = " + personagem.getid());
            
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOPersonagem.update" + e.getMessage());
			return -1;
        }
    }

    public int delete(String id){
        try {
            String sql = String.format("DELETE FROM personagem WHERE idpersonagem = " + id);
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOPersonagem.delete" + e.getMessage());
			return -1;
        }
    }

    public Personagem getPersonagemByID(String id){
        String sql = String.format("SELECT * FROM personagem where idpersonagem = %s", id);

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Personagem personagem = null;
            
            while(rs.next()){
                String idpersonagem = rs.getString("idpersonagem");
                String nomepersonagem =  rs.getString("nomepersonagem");
                personagem = new Personagem(idpersonagem, nomepersonagem);
            }
            return personagem;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
   
}