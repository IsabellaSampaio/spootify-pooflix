package cdu;

import java.sql.Connection;

import ui.*;


/**
 * Controlador de caso de uso geral de atualização dos dados
 * Função: controlar a atualização dos dados
 */
public class CDUAtualizacao {
    private FormAtualizacao formAtualizacao;
    private Connection con;

    public CDUAtualizacao(FormAtualizacao formAtualizacao, Connection con){
        this.formAtualizacao = formAtualizacao;
        formAtualizacao.setcua(this);
        this.con = con;
    }

    public void exec(){
        formAtualizacao.exibe();
    }

    public void processaOpcao(String opcao){
        switch(opcao) {
            case "1": atualizarSerie(); break;
            case "2": atualizarEpisodio(); break;
            case "3": atualizarAtor(); break;
            case "4": atualizarPersonagem(); break;
        }
    }

    public void atualizarSerie(){
        FormSerie formSerie = new FormSerie();
        CDUSerie casoUsoSerie = new CDUSerie(formSerie, con);
        casoUsoSerie.execUpdate();
    }

    public void atualizarEpisodio(){
        FormEpisodio formEpisodio = new FormEpisodio();
        CDUEpis casoUsoEpisodio = new CDUEpis(formEpisodio, con);
        casoUsoEpisodio.execUpdate();
    }

    public void atualizarAtor(){
        FormAtor formAtor = new FormAtor();
        CDUAtor casoUsoAtor = new CDUAtor(formAtor, con);
        casoUsoAtor.execUpdate();
    }

    public void atualizarPersonagem(){
        FormPersonagem formPersonagem = new FormPersonagem();
        CDUPersonagem casoUsoPersonagem = new CDUPersonagem(formPersonagem, con);
        casoUsoPersonagem.execUpdate();
    }
}
