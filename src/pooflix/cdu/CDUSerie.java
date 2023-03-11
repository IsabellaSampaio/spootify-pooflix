package cdu;

import ui.*;
import dominio.*;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import persistence.DAOCategoria;
import persistence.DAOSerie;

/**
 * Controlador de caso de uso de série 
 * Funções: Criar, Deletar, Atualizar, Ler dados de série
 */
public class CDUSerie  extends CDU {
    private Serie serie;
    private FormSerie formSerie;
    Connection con;

    public CDUSerie(FormSerie formSerie, Connection con){
        this.formSerie = formSerie;
        this.formSerie.setcdu(this);
        this.con = con;
    }

    public void exec() {
        formSerie.exibe();
    }

    public void execUpdate(){
        formSerie.exibeAtualizarSerie();
    }

    public void execDelete(){
        formSerie.exibeDeletarSerie();
    }

    public List<Categoria> getCategorias(){
        DAOCategoria dao = new DAOCategoria(con);
        return dao.read();
    }

    public int salvarSerie() {
        String id = formSerie.getid();
        String titulo = formSerie.gettitulo();
        int idade = Integer.valueOf(formSerie.getidademin());
        LinkedList<Categoria> categorias = formSerie.getcategoria();

        System.out.println("Salvando no banco de dados.." + serie);
        serie = new Serie(id,titulo,idade);
        serie.setCategorias(categorias);

        DAOSerie daoSerie = new DAOSerie(con);
        DAOCategoria daoCategoria = new DAOCategoria(con);
        daoSerie.create(serie);
        return daoCategoria.create(serie);
    }

    public Serie getSerie(String id){
        DAOSerie dao = new DAOSerie(con);
        return dao.getSerieByID(id);
    }

    public int atualizarSerie(){
        String id = formSerie.getid();
        String titulo = formSerie.gettitulo();
        int classeEtaria = Integer.parseInt(formSerie.getidademin());

        serie = new Serie(id, titulo, classeEtaria);
        DAOSerie dao = new DAOSerie(con);
        return dao.update(serie);
    }

    public int deletarSerie(){
        String id = formSerie.getid();
        DAOSerie dao = new DAOSerie(con);
        return dao.delete(id);
    }
}