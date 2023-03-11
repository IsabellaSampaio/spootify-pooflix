package persistence;

import java.sql.*;
import java.util.LinkedList;

import dominio.*;


/**
 * Gerenciador de conexão com o banco de dados - Performance
 * Função: CRUD de Performance
 */
public class DAOPerformance {
    private Connection connection;

    public DAOPerformance(Connection connection){
        this.connection = connection;
    }

    public int create(OBJPOOFlix obj){
        try {
            Performance performance = (Performance) obj;	
            String sql = String.format("INSERT INTO performance(fk_idepisodio, fk_idpersonagem, fk_idator) VALUES('%s', '%s', '%s')", performance.getidep(), performance.getidperson(), performance.getidator());
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOPerformance.create" + e.getMessage());
			return -1;
        }
    }

    public LinkedList<String> read() {
		try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT idepisodio, tituloepisodio, idpersonagem, nomepersonagem, idator, nomeator FROM performance " +
                                            "INNER JOIN episodio ON episodio.idepisodio = performance.fk_idepisodio " +
                                            "INNER JOIN personagem ON personagem.idpersonagem = performance.fk_idpersonagem " +
                                            "INNER JOIN ator ON ator.idator = performance.fk_idator");

            LinkedList<String> listaPerformances = new LinkedList<String>();
			while (rs.next()) {
                String idEpisodio = rs.getString("idepisodio");
                String episodio = rs.getString("tituloepisodio");
                String idPersonagem = rs.getString("idpersonagem");
                String personagem = rs.getString("nomepersonagem");
                String idAtor = rs.getString("idator");
                String ator = rs.getString("nomeator");

				String performance = String.format("Episódio(%s): %s,\n\n Personagem(%s): %s,\n\n - Ator(%s): %s\n\n", idEpisodio, episodio, idPersonagem, personagem, idAtor, ator);
				
				listaPerformances.add(performance);
			}
			rs.close();
			
			return listaPerformances;			
		} catch (SQLException e) {
			System.out.println("Problemas em DAOPerformance.read" + e.getMessage());
			return null;
		}
	}

    public int delete(String id){
        try {
            String sql = String.format("DELETE FROM performance WHERE fk_idpersonagem = " + id);
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOPerformance.delete" + e.getMessage());
			return -1;
        }
    }
}
