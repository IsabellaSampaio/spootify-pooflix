package cdu;

import ui.*;
import dominio.*;
import java.sql.Connection;
import persistence.DAOPersonagem;

/**
 * Controlador de caso de uso de personagem 
 * Funções: Criar, Deletar, Atualizar, Ler dados de personagem
 */
public class CDUPersonagem extends CDU {
    private Personagem personagem;
    private FormPersonagem formPersonagem;
    Connection con;

    public CDUPersonagem(FormPersonagem formPersonagem, Connection con){
        this.formPersonagem = formPersonagem;
        this.formPersonagem.setcdupe(this);
        this.con = con;
    }

    public void exec(){
        formPersonagem.exibe();
    }

    public void execUpdate(){
        formPersonagem.exibeAtualizarPersonagem();
    }

    public void execDelete(){
        formPersonagem.exibeDeletarPersonagem();
    }

    public int salvarPersonagem(){
        String id = formPersonagem.getid();
        String nome = formPersonagem.getnome();

        personagem = new Personagem(id, nome);
        DAOPersonagem dao = new DAOPersonagem(con);
        return dao.create(personagem);
    }

    public Personagem getPersonagem(String id){
        DAOPersonagem dao = new DAOPersonagem(con);
        return dao.getPersonagemByID(id);
    }

    public int atualizarPersonagem(){
        String id = formPersonagem.getid();
        String nome = formPersonagem.getnome();

        personagem = new Personagem(id, nome);
        DAOPersonagem dao = new DAOPersonagem(con);
        return dao.update(personagem);
    }

    public int deletarPersonagem(){
        String id = formPersonagem.getid();
        DAOPersonagem dao = new DAOPersonagem(con);
        return dao.delete(id);
    }
}
