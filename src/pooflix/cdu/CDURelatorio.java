package cdu;

import ui.*;
import java.sql.*;
import dominio.*;
import persistence.*;
import java.util.List;

/**
 * Controlador de caso de uso de relatório geral 
 * Funções: Executa o relatório geral dos dados
 */
public class CDURelatorio extends CDU {
    private FormRelatorio formRelatorio;
    private Connection con;

    public CDURelatorio(FormRelatorio formRelatorio, Connection con){
        this.formRelatorio = formRelatorio;
        formRelatorio.setcdur(this);
        this.con = con;
    }

    public void exec(){
        formRelatorio.exibe();
    }

    public void processaOpcao(String opcao){
        switch(opcao) {
            case "1": querySerieTable(); break;
            case "2": queryEpisodioTable(); break;
            case "3": queryAtorTable(); break;
            case "4": queryPersonagemTable(); break;
            case "5": queryPerformanceTable(); break;
        }
    }

    public void querySerieTable(){
        DAOSerie dao = new DAOSerie(con);
        List<Serie> series = dao.read();

        for(Serie serie : series){
            System.out.println(serie);
        }
    }

    public void queryEpisodioTable(){
        DAOEpisodio dao = new DAOEpisodio(con);
        List<Episodio> episodios = dao.read();

        for(Episodio episodio : episodios){
            System.out.println(episodio);
        }
    }

    public void queryAtorTable(){
        DAOAtor dao = new DAOAtor(con);
        List<Ator> atores = dao.read();

        for(Ator ator : atores){
            System.out.println(ator);
        }
    }

    public void queryPersonagemTable(){
        DAOPersonagem dao = new DAOPersonagem(con);
        List<Personagem> personagens = dao.read();

        for(Personagem personagem : personagens){
            System.out.println(personagem);
        }
    }

    public void queryPerformanceTable(){
        DAOPerformance dao = new DAOPerformance(con);
        List<String> performances = dao.read();

        for(String performance : performances){
            System.out.println(performance);
        }
    }
}

