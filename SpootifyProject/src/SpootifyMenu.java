import java.io.IOException;
import java.util.Scanner;

public class SpootifyMenu {
    private Scanner scan;
    private int opcao;
    String titulo;
    SpootifyPlaylist biblioteca;

    //getters/setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public SpootifyPlaylist getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(SpootifyPlaylist biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public SpootifyMenu(Scanner scan){
        this.scan = scan;
    }
    
    //constructor
    public SpootifyMenu(Scanner scan, int opcao, String titulo, SpootifyPlaylist biblioteca){
        this.scan = scan;
        this.opcao = opcao;
        this.titulo = titulo;
        this.biblioteca = new SpootifyPlaylist(titulo);
    }


    //métodos
    public void menu() throws InterruptedException, IOException{
        Spootify.limpaTela();
        String s = Spootify.ANSI_GREEN + "spOOtify" + Spootify.ANSI_RESET;
        System.out.printf("BEM-VINDO(A) AO %s\n", s);
        System.out.println(Spootify.ANSI_GREEN +"-------------------------------------" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_BLACK + "[1] Criar playlist" + Spootify.ANSI_RESET );
        System.out.println(Spootify.ANSI_BLACK + "[2] Adicionar conteudo a playlists" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_BLACK + "[3] Remover conteudo de playlists" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_BLACK + "[4] Listar playlists criadas" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_BLACK + "[5] Listar conteudos das playlists" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_BLACK + "[6] Sair" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_GREEN +"--------------------------------------" + Spootify.ANSI_RESET);
    }

    public void menuConteudos() throws InterruptedException, IOException{
        Spootify.limpaTela();
        System.out.println("Escolha entre as opções abaixo\n");
        System.out.println(Spootify.ANSI_GREEN +"--------------" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_BLACK + "[1] Músicas" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_BLACK + "[2] Podcasts" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_BLACK + "[3] Audiobooks" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_GREEN +"---------------" + Spootify.ANSI_RESET);

    }
    
    public int lerOpcaoMenu(){
        System.out.println("-> ESCOLHA UMA OPÇÃO: ");
        int opcao = scan.nextInt();
        scan.nextLine();
        return opcao;

    }


    public boolean escolheMenu(int opcao) throws InterruptedException, IOException{
        switch(opcao){
            case 1:
                biblioteca.criaPlaylist(scan);
                return true;
            case 2:
                biblioteca.addNaPlaylist(scan);
                return true;
            case 3:
                biblioteca.removeDaPlaylist(scan);
                return true;
            case 4:
                biblioteca.listaPlaylist();
                return true;
            case 5:
                biblioteca.listaPlaylistsContent(scan);
                return true;
            case 6:
                System.out.println("Saindo do programa...");
                Thread.sleep(2000);
                return true;
            default:
                return true;
                
        }
    }
    
}
