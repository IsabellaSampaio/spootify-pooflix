package persistence;

import java.sql.*;
import dominio.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Gerenciador de conexão com o banco de dados - episódio
 * Função: CRUD de episódio
 */
public class DAOEpisodio {
    private Connection connection;

    public DAOEpisodio(Connection connection){
        this.connection = connection;
    }

    public int create(OBJPOOFlix obj){
        try {
            Episodio episodio = (Episodio) obj;	
            String sql = String.format("INSERT INTO episodio(idepisodio, fk_idserie, temporada, tituloepisodio, resumo) VALUES('%s', '%s', '%s', '%s', '%s')", episodio.getid(), episodio.getidserie(), episodio.gettemporada(), episodio.gettitulo(), episodio.getresumo());
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOEpisodio.create" + e.getMessage());
			return -1;
        }
    }

    public List<Episodio> read() {
		try {
			List<Episodio> episodios = new ArrayList<Episodio>();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM episodio");
			while (rs.next()) {
                String idepisodio = rs.getString("idepisodio");
                String idserie = rs.getString("fk_idserie");
                String temporada = rs.getString("temporada");
                String titulo = rs.getString("tituloepisodio");
                String resumo = rs.getString("resumo");

				Episodio episodio = new Episodio(idepisodio, titulo, temporada, resumo, idserie);
				
				episodios.add(episodio);
			}
			rs.close();			
			return episodios;			
		} catch (SQLException e) {
			System.out.println("Problemas em DAOEpisodio.read" + e.getMessage());
			return null;
		}
	}

    public int update(OBJPOOFlix obj){
        try {
            Episodio episodio = (Episodio) obj;	
            String sql = null;

            if(episodio.gettemporada() != null && episodio.gettitulo() != null && episodio.getresumo() != null){
                sql = String.format("UPDATE episodio set temporada = '"+ episodio.gettemporada() +"', tituloepisodio = '"+ episodio.gettitulo() +"', resumo = '"+ episodio.getresumo() +"' where idepisodio = " + episodio.getid());
            }else if(episodio.gettemporada() != null){
                sql = String.format("UPDATE episodio set temporada = '"+ episodio.gettemporada() +"' where idepisodio = " + episodio.getid());
            }else if(episodio.gettitulo() != null){
                sql = String.format("UPDATE episodio set tituloepisodio	= '"+ episodio.gettitulo() +"' where idepisodio = " + episodio.getid());
            }else if(episodio.getresumo() != null){
                sql = String.format("UPDATE episodio set resumo = '"+ episodio.getresumo() +"' where idepisodio = " + episodio.getid());
            }else{
                return -1;
            }

            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOEpisodio.update" + e.getMessage());
			return -1;
        }
    }

    public int delete(String id){
        try {
            String sql = String.format("DELETE FROM episodio WHERE idepisodio = " + id);
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOEpisodio.delete" + e.getMessage());
			return -1;
        }
    }

    public Episodio getEpisodioByID(String id){
        String sql = String.format("SELECT * FROM episodio where idepisodio = %s", id);

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Episodio episodio = null;
            
            while(rs.next()){
                String idepisodio = rs.getString("idepisodio");
                String idserie = rs.getString("fk_idserie");
                String temporada = rs.getString("temporada");
                String tituloepisodio = rs.getString("tituloepisodio");
                String resumo = rs.getString("resumo");

                episodio = new Episodio(idepisodio, tituloepisodio, temporada, resumo, idserie);
            }
            return episodio;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Serie getSerieByID(int id){
        String sql = String.format("SELECT * FROM serie where idserie = %s", id);

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Serie serie = null;
            
            while(rs.next()){
                String idSerie = rs.getString("idSerie");
                String titulo =  rs.getString("tituloSerie");
                int classeEtaria = Integer.parseInt(rs.getString("idade"));
                serie = new Serie(idSerie, titulo, classeEtaria);
            }
            return serie;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
