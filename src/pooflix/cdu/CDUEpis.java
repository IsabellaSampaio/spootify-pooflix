package cdu;

import ui.*;
import dominio.*;
import java.sql.Connection;
import persistence.DAOEpisodio;

/**
 * Controlador de caso de uso de episódio 
 * Funções: Criar, Deletar, Atualizar, Ler dados de episódio
 */
public class CDUEpis extends CDU {
    private Episodio episodio = null;
    private FormEpisodio formEpisodio;
    Connection con;

    public CDUEpis(FormEpisodio formEpisodio, Connection con){
        this.formEpisodio = formEpisodio;
        this.formEpisodio.setcdue(this);
        this.con = con;
    }

    public void exec() {
        formEpisodio.exibe();
    }

    public void execUpdate(){
        formEpisodio.exibeAtualizarEpisodio();
    }

    public void execDelete(){
        formEpisodio.exibeDeletarEpisodio();
    }

    public String getNomeSerie(int idserie) {
        DAOEpisodio dao = new DAOEpisodio(con);
        Serie serie = dao.getSerieByID(idserie); 
        return serie.gettitulo();
    }

    public int salvarEpisodio() {
        String id = formEpisodio.getid();
        String idserie = formEpisodio.getidserie();
        String temporada = formEpisodio.gettemporada();
        String titulo = formEpisodio.gettitulo();
        String resumo = formEpisodio.getresumo();

        episodio = new Episodio(id, titulo, temporada, resumo, idserie);   
        DAOEpisodio dao = new DAOEpisodio(con);
        return dao.create(episodio);
    }

    public Episodio getEpisodio(String id){
        DAOEpisodio dao = new DAOEpisodio(con);
        return dao.getEpisodioByID(id);
    }

    public int atualizarEpisodio(){
        String id = formEpisodio.getid();
        String titulo = formEpisodio.gettitulo();
        String temporada = formEpisodio.gettemporada();
        String resumo = formEpisodio.getresumo();
        String idSerie = formEpisodio.getidserie();
    
        episodio = new Episodio(id, titulo, temporada, resumo, idSerie);
        DAOEpisodio dao = new DAOEpisodio(con);
        return dao.update(episodio);
    }

    public int deletarEpisodio(){
        String id = formEpisodio.getid();
        DAOEpisodio dao = new DAOEpisodio(con);
        return dao.delete(id);
    }
}