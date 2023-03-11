package dominio;

import java.util.LinkedList;

/**
 * Arquivo geral de Episódio, que descreve os atríbutos de Episódio
 * Função: Atribuição de dados e criação da classe episodio
 */
public class Episodio implements OBJPOOFlix {
    private String id;
    private String temporada;
    private String titulo;
    private Serie serie;
    private String idserie;
    public String resumo;
    private LinkedList<Performance> perfomances;

    public Episodio(String id, String titulo, String temporada, String resumo, String idserie){
        this.id = id;
        this.titulo = titulo;
        this.temporada = temporada;
        this.resumo = resumo;
        this.idserie = idserie;
    }

    public void adperformance(Performance p){
        perfomances.add(p);
    }

    // public Serie getserie(){
    //     return serie;
    // }

    public void setserie(Serie s){
        if(serie == null){
            serie = s;
        }
    }

    public void settitulo(String titulo){
        this.titulo = titulo;
    }

    public String getid(){
        return id;
    }

    public String gettemporada(){ 
        return temporada;
    }

    public String gettitulo(){
        return titulo;
    } 

    public String getresumo(){ 
        return resumo;
    }

    public String getidserie(){ 
        return idserie;
    }

    public String toString(){ 
        String s = "";
        s = "id: " + id + ";\n";
        s = s + "Titulo: " + titulo + ";\n";
        s = s + String.valueOf(temporada);
        return s;
    }
}