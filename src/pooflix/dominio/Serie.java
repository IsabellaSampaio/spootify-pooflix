package dominio;

import java.util.HashMap;
import java.util.LinkedList;


/**
 * Arquivo geral de série, que descreve os atríbutos de série
 * Função: Atribuição de dados e criação da classe série
 */
public class Serie implements OBJPOOFlix {
    private String id;
    private String titulo;
    private int classetaria;
    private HashMap<String, Episodio> episodios;
    private LinkedList<Categoria> categorias;

    public Serie(String id, String titulo, Integer clsetaria) {
        this.id = id;
        this.titulo = titulo;
        classetaria = clsetaria;
        episodios = new HashMap<String, Episodio>();
        categorias = new LinkedList<Categoria>();
    }

    public void adepisodio(Episodio e){
        episodios.put(e.getid(),e);
    }

    public String getid(){
        return id;
    }

    public String gettitulo(){
        return titulo;
    }

    public int getClassEtaria(){
        return classetaria;
    }

    public LinkedList<Categoria> getCategorias(){
        return categorias;
    }

    public void setCategorias(LinkedList<Categoria> categoria){
        this.categorias = categoria;
    }

    public String toString(){ 
        String serieCategorias = "";

        //Verifica se a série possui mais de uma categoria
        if(categorias.size() > 0){
            //Concatena as categorias com vírgulas
            for(Categoria cat : categorias) 
                serieCategorias += cat.getnome() + ","; 
            //Remove a vírgula no final da frase
            serieCategorias = serieCategorias.substring(0, serieCategorias.length() - 1);
        }else{
            serieCategorias = categorias.get(0).getnome();
        }

        String s = "";
        s = "id: " + id + ";\n";
        s = s + "Titulo: " + titulo + ";\n";
        s = s + "Classe etária: " + classetaria + ";\n";
        s = s + "Categoria: " + serieCategorias  + ";\n";
        return s;
    }
}