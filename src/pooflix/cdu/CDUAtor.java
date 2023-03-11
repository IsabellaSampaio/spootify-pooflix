package cdu;

import ui.*;
import dominio.*;
import java.sql.Connection;
import persistence.DAOAtor;

/**
 * Controlador de caso de uso de ator 
 * Funções: Criar, Deletar, Atualizar, Ler dados de ator
 */

public class CDUAtor extends CDU {
    private Ator ator;
    private FormAtor formAtor;
    Connection con;

    public CDUAtor(FormAtor formAtor, Connection con){
        this.formAtor = formAtor;
        this.formAtor.setcdua(this);
        this.con = con;
    }

    public void exec(){
        formAtor.exibe();
    }

    public void execUpdate(){
        formAtor.exibeAtualizarAtor();
    }

    public void execDelete(){
        formAtor.exibeDeletarAtor();
    }

    public int salvarAtor(){
        String id = formAtor.getid();
        String nome = formAtor.getnome();
        String nacionalidade = formAtor.getnacionalidade();
        
        ator = new Ator(id, nome, nacionalidade);
        DAOAtor dao = new DAOAtor(con);
        return dao.create(ator);
    }

    public Ator getAtor(String id){
        DAOAtor dao = new DAOAtor(con);
        return dao.getAtorByID(id);
    }

    public int atualizarAtor(){
        String id = formAtor.getid();
        String nome = formAtor.getnome();
        String nacionalidade = formAtor.getnacionalidade();

        ator = new Ator(id, nome, nacionalidade);
        DAOAtor dao = new DAOAtor(con);
        return dao.update(ator);
    }

    public int deletarAtor(){
        String id = formAtor.getid();
        DAOAtor dao = new DAOAtor(con);
        return dao.delete(id);
    }
}
