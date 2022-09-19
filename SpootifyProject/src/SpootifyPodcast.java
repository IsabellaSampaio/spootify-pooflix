public class SpootifyPodcast extends Spootify{

    private String apresentador;
    private String resenha;

    //getters/setters
    public String getApresentador() {
        return apresentador;
    }

    public void setApresentador(String apresentador) {
        this.apresentador = apresentador;
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    //constructor
    public SpootifyPodcast(String titulo, int duracao, String apresentador, String resenha){
        super(titulo, duracao);
        this.apresentador = apresentador;
        this.resenha = resenha;

    }
    
    
}
