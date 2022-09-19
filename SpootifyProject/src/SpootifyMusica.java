import java.util.ArrayList;


public class SpootifyMusica extends Spootify{

    private ArrayList<String> compositores;
    private ArrayList<String> interpretes;
    private String generoMusical;


    //getters/setters
    public ArrayList<String> getCompositores() {
        return compositores;
    }


    public void setCompositores(ArrayList<String> compositores) {
        this.compositores = compositores;
    }


    public ArrayList<String> getInterpretes() {
        return interpretes;
    }


    public void setInterpretes(ArrayList<String> interpretes) {
        this.interpretes = interpretes;
    }


    public String getGeneroMusical() {
        return generoMusical;
    }


    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
    
    //constructor
    public SpootifyMusica(String titulo, int duracao, ArrayList<String> compositores, ArrayList<String> interpretes,
    String generoMusical){
        super(titulo, duracao);
        this.compositores = compositores;
        this.interpretes = interpretes;
        this.generoMusical = generoMusical;

    }


     
}
