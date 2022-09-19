import java.io.IOException;

public class Spootify {


    private String titulo;
    private int durucao;


    //getters/setters
    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public int getDurucao() {
        return durucao;
    }


    public void setDurucao(int durucao) {
        this.durucao = durucao;
    }

    //constructor
    public Spootify(String titulo, int duracao){
        this.titulo = titulo;
        this.durucao = duracao;
    }

    //métodos
    public static void limpaTela() throws InterruptedException, IOException{
        if(System.getProperty("os.name").contains("Windows")){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }else{
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
        
    }

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";


    public String formatDuracao(int num){
        int horas;
        int minutos;
        int segundos = num;

        horas = segundos / 3600;
        segundos %= 3600;
        minutos = segundos / 60;
        segundos %= 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }


    public String fomartString(){
        return String.format(". %s - %s\n", getTitulo(), formatDuracao(getDurucao()));
    }



}
