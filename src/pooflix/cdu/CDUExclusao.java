package cdu;

import java.sql.Connection;

/**
 * Controlador de caso de uso geral de exclusão dos dados
 * Função: controlar a exclusão dos dados
 */
import ui.FormAtor;
import ui.FormEpisodio;
import ui.FormExclusao;
import ui.FormPersonagem;
import ui.FormSerie;

public class CDUExclusao {
    private FormExclusao formExclusao;
    private Connection con;

    public CDUExclusao(FormExclusao formExclusao, Connection con){
        this.formExclusao = formExclusao;
        formExclusao.setcdue(this);
        this.con = con;
    }

    public void exec(){
        formExclusao.exibe();
    }

    public void processaOpcao(String opcao){
        switch(opcao) {
            case "1": excluirSerie(); break;
            case "2": excluirEpisodio(); break;
            case "3": excluirAtor(); break;
            case "4": excluirPersonagem(); break;
        }
    }

    public void excluirSerie(){
        FormSerie formSerie = new FormSerie();
        CDUSerie casoUsoSerie = new CDUSerie(formSerie, con);
        casoUsoSerie.execDelete();
    }

    public void excluirEpisodio(){
        FormEpisodio formEpisodio = new FormEpisodio();
        CDUEpis casoUsoEpisodio = new CDUEpis(formEpisodio, con);
        casoUsoEpisodio.execDelete();
    }

    public void excluirAtor(){
        FormAtor formAtor = new FormAtor();
        CDUAtor casoUsoAtor = new CDUAtor(formAtor, con);
        casoUsoAtor.execDelete();
    }

    public void excluirPersonagem(){
        FormPersonagem formPersonagem = new FormPersonagem();
        CDUPersonagem casoUsoPersonagem = new CDUPersonagem(formPersonagem, con);
        casoUsoPersonagem.execDelete();
    }
}
