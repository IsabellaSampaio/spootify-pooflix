
import java.util.ArrayList;

public class SpootifyAudiobook extends Spootify{

    private ArrayList<String> autores;
    private String narrador;
    private String editora;
    private String sinopse;
    
    //getters/setters
    public ArrayList<String> getAutores() {
        return autores;
    }


    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }


    public String getNarrador() {
        return narrador;
    }


    public void setNarrador(String narrador) {
        this.narrador = narrador;
    }


    public String getEditora() {
        return editora;
    }


    public void setEditora(String editora) {
        this.editora = editora;
    }


    public String getSinopse() {
        return sinopse;
    }


    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    //constructor
    public SpootifyAudiobook(String titulo, int duracao, ArrayList<String> autores, String narrador, String editora,
    String sinopse){
        super(titulo, duracao);
        this.autores = autores;
        this.narrador = narrador;
        this.editora = editora;
        this.sinopse = sinopse;
    }



}
