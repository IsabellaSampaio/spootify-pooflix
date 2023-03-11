package cdu;

import java.sql.Connection;

import ui.*;

/**
 * Controlador de caso de uso geral de cadastramento dos dados
 * Função: controlar a cadastramento dos dados
 */
public class CDUCadastro {
    private FormCadastro formCadastro;
    private Connection con;

    public CDUCadastro(FormCadastro formCadastro, Connection con){
        this.formCadastro = formCadastro;
        formCadastro.setcua(this);
        this.con = con;
    }

    public void exec(){
        formCadastro.exibe();
    }

    public void processaOpcao(String opcao){
        switch(opcao) {
            case "1": cadastrarSerie(); break;
            case "2": cadastrarEpisodio(); break;
            case "3": cadastrarAtor(); break;
            case "4": cadastrarPersonagem(); break;
            case "5": cadastrarPerformance(); break;
        }
    }

    public void cadastrarSerie(){
        FormSerie formSerie = new FormSerie();
        CDUSerie casoUsoSerie = new CDUSerie(formSerie, con);
        casoUsoSerie.exec();
    }

    public void cadastrarEpisodio(){
        FormEpisodio formEpisodio = new FormEpisodio();
        CDUEpis casoUsoEpisodio = new CDUEpis(formEpisodio, con);
        casoUsoEpisodio.exec();
    }

    public void cadastrarAtor(){
        FormAtor formAtor = new FormAtor();
        CDUAtor casoUsoAtor = new CDUAtor(formAtor, con);
        casoUsoAtor.exec();
    }

    public void cadastrarPersonagem(){
        FormPersonagem formPersonagem = new FormPersonagem();
        CDUPersonagem casoUsoPersonagem = new CDUPersonagem(formPersonagem, con);
        casoUsoPersonagem.exec();
    }

    public void cadastrarPerformance(){
        FormPerformance formPerformance = new FormPerformance();
        CDUPerformance casoUsoPersonagem = new CDUPerformance(formPerformance, con);
        casoUsoPersonagem.exec();
    }
}
