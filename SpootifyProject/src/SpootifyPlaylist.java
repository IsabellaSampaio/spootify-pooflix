import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SpootifyPlaylist extends Spootify{
    private ArrayList<SpootifyMusica> musicasContent;
    private ArrayList<SpootifyPodcast> podcastsContent;
    private ArrayList<SpootifyAudiobook> audiobooksContent;
    private ArrayList<Spootify> playlistsMusica;
    private ArrayList<Spootify> playlistsPodcast;
    private ArrayList<Spootify> playlistsAudiobook;
    private HashMap<String,ArrayList<Spootify>> listaPlaylists;


    //getters/setters
    public ArrayList<SpootifyMusica> getMusicasContent() {
        return musicasContent;
    }

    public void setMusicasContent(ArrayList<SpootifyMusica> musicasContent) {
        this.musicasContent = musicasContent;
    }

    public ArrayList<SpootifyPodcast> getPodcastsContent() {
        return podcastsContent;
    }

    public void setPodcastsContent(ArrayList<SpootifyPodcast> podcastsContent) {
        this.podcastsContent = podcastsContent;
    }

    public ArrayList<SpootifyAudiobook> getAudiobooksContent() {
        return audiobooksContent;
    }

    public void setAudiobooksContent(ArrayList<SpootifyAudiobook> audiobooksContent) {
        this.audiobooksContent = audiobooksContent;
    }

    public ArrayList<Spootify> getPlaylistsMusica() {
        return playlistsMusica;
    }

    public void setPlaylistsMusica(ArrayList<Spootify> playlistsMusica) {
        this.playlistsMusica = playlistsMusica;
    }

    public ArrayList<Spootify> getPlaylistsPodcast() {
        return playlistsPodcast;
    }

    public void setPlaylistsPodcast(ArrayList<Spootify> playlistsPodcast) {
        this.playlistsPodcast = playlistsPodcast;
    }

    public ArrayList<Spootify> getPlaylistsAudiobook() {
        return playlistsAudiobook;
    }

    public void setPlaylistsAudiobook(ArrayList<Spootify> playlistsAudiobook) {
        this.playlistsAudiobook = playlistsAudiobook;
    }

    public HashMap<String, ArrayList<Spootify>> getListaPlaylists() {
        return listaPlaylists;
    }

    public void setListaPlaylists(HashMap<String, ArrayList<Spootify>> listaPlaylists) {
        this.listaPlaylists = listaPlaylists;
    }

    //constructor
    public SpootifyPlaylist(String titulo){
        super(titulo, 0);
        this.musicasContent = new ArrayList<SpootifyMusica>();
        this.podcastsContent = new ArrayList<SpootifyPodcast>();
        this.audiobooksContent = new ArrayList<SpootifyAudiobook>();
        this.playlistsMusica = new ArrayList<Spootify>();
        this.playlistsPodcast = new ArrayList<Spootify>();
        this.playlistsAudiobook = new ArrayList<Spootify>();
        this.listaPlaylists = new HashMap<String,ArrayList<Spootify>>();
    }

    //métodos 
    public void addMusica(Scanner scan) throws InterruptedException, IOException{
        Spootify.limpaTela();

        String titulo;
        String generoMusical;
        String resp;
        int duracao;
        ArrayList<String> compositores = new ArrayList<String>();
        ArrayList<String> interpretes = new ArrayList<String>();

        do{
            System.out.println(Spootify.ANSI_GREEN + "ADICIONANDO MÚSICAS" + Spootify.ANSI_RESET);
            System.out.println("--------------------");
            System.out.println("\n-> Qual é o nome?");
            titulo = scan.nextLine();
            System.out.println("\n-> Qual a duração? ");
            duracao = scan.nextInt();
            scan.nextLine();
            System.out.println("\n-> Quem são os compositores?");
            compositores.add(scan.nextLine());
            System.out.println("\n-> Quem são os interpretes?");
            interpretes.add(scan.nextLine());
            System.out.println("\n-> Qual é o genero musical?");
            generoMusical = scan.nextLine();
            SpootifyMusica musicas = new SpootifyMusica(titulo, duracao, compositores, interpretes, generoMusical);
            musicasContent.add(musicas);
            System.out.println("\n--------------------");
            System.out.println(Spootify.ANSI_GREEN + "\nMúsica adicionada com sucesso!" + Spootify.ANSI_RESET);
            Thread.sleep(1000);
            Spootify.limpaTela();
            System.out.println("\n-> Deseja adicionar mais uma música? (RESPONDA APENAS COM 's' OU 'n')");
            resp = scan.nextLine();
            if(!resp.equals("s") && !resp.equals("n")){
                System.out.println("Resposta inválida, tente novamente digitando abaixo\n");
                resp = scan.nextLine();
            }

        }while(!resp.equals("n"));
        

        System.out.println("\n--------------------------------");
        System.out.println("\nPressione ENTER para voltar ao menu");
        System.in.read();

        

    }

    public void addPodcast(Scanner scan) throws InterruptedException, IOException{
        Spootify.limpaTela();

        String titulo;
        String apresentador;
        String resenha;
        String resp;
        int duracao;

        do{
            System.out.println(Spootify.ANSI_GREEN + "ADICIONANDO PODCASTS" + Spootify.ANSI_RESET);
            System.out.println("--------------------");
            System.out.println("\n-> Qual é o nome?");
            titulo = scan.nextLine();
            System.out.println("\n-> Qual a duração? ");
            duracao = scan.nextInt();
            scan.nextLine();
            System.out.println("\n-> Quem é o apresentador? ");
            apresentador = scan.nextLine();
            System.out.println("\n-> Faça uma breve resenha a cerca do epsódio: ");
            resenha = scan.nextLine();
            SpootifyPodcast podcasts = new SpootifyPodcast(titulo, duracao, apresentador, resenha);
            podcastsContent.add(podcasts);
            System.out.println("\n--------------------");
            System.out.println(Spootify.ANSI_GREEN + "\nPodcast adicionado com sucesso!" + Spootify.ANSI_RESET);
            Thread.sleep(1000);
            Spootify.limpaTela();
            System.out.println("\n-> Deseja adicionar mais um podcast? (RESPONDA APENAS COM 's' OU 'n')");
            resp = scan.nextLine();
            if(!resp.equals("s") && !resp.equals("n")){
                System.out.println("Resposta inválida, tente novamente digitando abaixo\n");
                resp = scan.nextLine();
            }
        }while(!resp.equals("n"));

        System.out.println("\n--------------------------------");
        System.out.println("\nPressione ENTER para voltar ao menu");
        System.in.read();
        
        

    }

    public void addAudiobook(Scanner scan) throws InterruptedException, IOException{
        Spootify.limpaTela();

        String titulo;
        String narrador;
        String editora;
        String sinopse;
        String resp;
        int duracao;
        ArrayList<String> autores = new ArrayList<String>();

        do{
            System.out.println(Spootify.ANSI_GREEN + "ADICIONANDO AUDIOBOOKS" + Spootify.ANSI_RESET);
            System.out.println("--------------------");
            System.out.println("\n-> Qual é o nome?");
            titulo = scan.nextLine();
            System.out.println("\n-> Qual a duração? ");
            duracao = scan.nextInt();
            scan.nextLine();
            System.out.println("\n-> Quem são os autores? ");
            autores.add(scan.nextLine());
            System.out.println("\n-> Qual é a editora? ");
            editora = scan.nextLine();
            System.out.println("\n-> Quem é o narrador? ");
            narrador = scan.nextLine();
            System.out.println("\n-> Escreva uma breve sinopse a cerca da obra: ");
            sinopse = scan.nextLine();
            SpootifyAudiobook audiobooks = new SpootifyAudiobook(titulo, duracao, autores, narrador, editora, sinopse);
            audiobooksContent.add(audiobooks);
            System.out.println("\n--------------------");
            System.out.println(Spootify.ANSI_GREEN + "\nAudiobook adicionado com sucesso!" + Spootify.ANSI_RESET);
            Thread.sleep(1000);
            Spootify.limpaTela();
            System.out.println("\n-> Deseja adicionar mais um podcast? (RESPONDA APENAS COM 's' OU 'n')\n");
            resp = scan.nextLine();
            if(!resp.equals("s") && !resp.equals("n")){
                System.out.println("Resposta inválida, tente novamente digitando abaixo\n");
                resp = scan.nextLine();
            }
        }while(!resp.equals("n"));


        System.out.println("\n--------------------------------");
        System.out.println("\nPressione ENTER para voltar ao menu");
        System.in.read();

    }
    
    public void criaPlaylist(Scanner scan) throws InterruptedException, IOException{
        Spootify.limpaTela();
        String titulo;
        String resp;
        System.out.println(Spootify.ANSI_GREEN +"CRIANDO PLAYLISTS"+ Spootify.ANSI_RESET);
        System.out.println("--------------------");
        System.out.println("\n-> Qual é o nome da playlist? ");
        titulo = scan.nextLine();
        if(listaPlaylists.keySet().contains(titulo)){
            System.out.printf("\nA playlist %s já existe, crie uma playlist com nome diferente\n", titulo);
            System.out.printf(Spootify.ANSI_BLACK +"Susgestão de nome: %s1" + Spootify.ANSI_RESET, titulo);
            System.out.println("\n-> Qual é o nome da playlist? ");
            titulo = scan.nextLine();
        }
        System.out.println("\n--------------------");
        System.out.printf("Playlist " +  Spootify.ANSI_GREEN + "%s" + Spootify.ANSI_RESET + " criada com sucesso!\n", titulo);
        System.out.println("\n-> O que deseja adicionar a playlist? ");
        System.out.println(Spootify.ANSI_GREEN +"\n--------------" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_BLACK + "[1] Músicas" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_BLACK + "[2] Podcasts" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_BLACK + "[3] Audiobooks" + Spootify.ANSI_RESET);
        System.out.println(Spootify.ANSI_GREEN +"---------------\n" + Spootify.ANSI_RESET);
        resp = scan.nextLine();


        if(resp.equals("1")){
            addMusica(scan);
            playlistsMusica.addAll(musicasContent);
            listaPlaylists.put(titulo, playlistsMusica);
        }
        if(resp.equals("2")){
            addPodcast(scan);
            playlistsPodcast.addAll(podcastsContent);
            listaPlaylists.put(titulo, playlistsPodcast);
        }
        if(resp.equals("3")){
            addAudiobook(scan);
            playlistsAudiobook.addAll(audiobooksContent);
            listaPlaylists.put(titulo, playlistsAudiobook);
        }

    }

    public void addNaPlaylist(Scanner scan) throws InterruptedException, IOException{
        Spootify.limpaTela();
        String resp;
        int resp2;
        System.out.println(Spootify.ANSI_GREEN + "ADICIONANDO CONTEÚDOS A PLAYLISTS" + Spootify.ANSI_RESET);
        System.out.println("---------------------------------");
        for(String chave: listaPlaylists.keySet()){
            System.out.println(chave + " " + duracaoPlaylists(listaPlaylists.get(chave)));
        }
        System.out.println("\n-> Em qual playlist deseja adicionar conteúdo?");
        resp = scan.nextLine();
        if(listaPlaylists.keySet().contains(resp)){
            System.out.println("Escolha entre as opções abaixo\n");
            System.out.println(Spootify.ANSI_GREEN +"--------------" + Spootify.ANSI_RESET);
            System.out.println(Spootify.ANSI_BLACK + "[1] Músicas" + Spootify.ANSI_RESET);
            System.out.println(Spootify.ANSI_BLACK + "[2] Podcasts" + Spootify.ANSI_RESET);
            System.out.println(Spootify.ANSI_BLACK + "[3] Audiobooks" + Spootify.ANSI_RESET);
            System.out.println(Spootify.ANSI_GREEN +"---------------" + Spootify.ANSI_RESET);
            resp2 = scan.nextInt();
            scan.nextLine();
            if(resp2 == 1){
                addMusica(scan);
                playlistsMusica.clear();
                playlistsMusica.addAll(musicasContent);
                System.out.println(Spootify.ANSI_GREEN +"Música adicionada com sucesso!"+ Spootify.ANSI_RESET);
                
            }
            if(resp2 == 2){
                addPodcast(scan);
                playlistsPodcast.clear();
                playlistsPodcast.addAll(podcastsContent);
                System.out.println(Spootify.ANSI_GREEN +"Podcast adicionado com sucesso!"+ Spootify.ANSI_RESET);
            }
            if(resp2 == 3){
                addAudiobook(scan);
                playlistsAudiobook.clear();
                playlistsAudiobook.addAll(audiobooksContent);
                System.out.println(Spootify.ANSI_GREEN +"Audiobook adicionado com sucesso!"+ Spootify.ANSI_RESET);
            }

        }else{
            System.out.println("Playlist não encontrada");
        }


        System.out.println("\n--------------------------------");
        System.out.println("\nPressione ENTER para voltar ao menu");
        System.in.read();



    }

    public void removeDaPlaylist(Scanner scan) throws InterruptedException, IOException{
        Spootify.limpaTela();
        String resp;
        int resp2;
        System.out.println(Spootify.ANSI_GREEN + "REMOVENDO CONTEÚDOS DA PLAYLISTS" + Spootify.ANSI_RESET);
        System.out.println("-------------------------------------");
        for(String chave: listaPlaylists.keySet()){
            System.out.println(chave + " " + duracaoPlaylists(listaPlaylists.get(chave)));
        }
        System.out.println("\n-> De qual playlist deseja remover conteúdo");
        resp = scan.nextLine();
        
        if(listaPlaylists.containsKey(resp)){
            if(listaPlaylists.get(resp) == playlistsMusica){
                for(int i = 0; i < listaPlaylists.get(resp).size(); i++){
                    System.out.println(i+1 + listaPlaylists.get(resp).get(i).fomartString());
                }
                System.out.println("\n-> Qual música deseja remover? (RESPONDA DIGITANDO O NÚMERO DA MÚSICA)");
                resp2 = scan.nextInt();
                scan.nextLine();
                musicasContent.remove(resp2-1);
                playlistsMusica.remove(resp2-1);
                System.out.println(Spootify.ANSI_GREEN +"Música removida com sucesso!"+ Spootify.ANSI_RESET);
        
            }
            if(listaPlaylists.get(resp) == playlistsPodcast){
                for(int i = 0; i < listaPlaylists.get(resp).size(); i++){
                    System.out.println(i+1 + listaPlaylists.get(resp).get(i).fomartString());
                }
                System.out.println("\n-> Qual podcast deseja remover? (RESPONDA DIGITANDO O NÚMERO DA PODCAST)");
                resp2 = scan.nextInt();
                scan.nextLine();
                podcastsContent.remove(resp2);
                playlistsPodcast.remove(resp2);
                System.out.println(Spootify.ANSI_GREEN +"Podcast removido com sucesso!"+ Spootify.ANSI_RESET);
            }
            
            if(listaPlaylists.get(resp) == playlistsAudiobook){
                for(int i = 0; i < listaPlaylists.get(resp).size(); i++){
                    System.out.println(i+1 + listaPlaylists.get(resp).get(i).fomartString());
                }
                System.out.println("\n-> Qual audiobook deseja remover? (RESPONDA DIGITANDO O NÚMERO DO AUDIOBOOK)");
                resp2 = scan.nextInt();
                scan.nextLine();
                audiobooksContent.remove(resp2-1);
                playlistsAudiobook.remove(resp2-1);
                System.out.println(Spootify.ANSI_GREEN +"Audiobook removido com sucesso!"+ Spootify.ANSI_RESET);
            }
    
        }else{
            System.out.println("Playlist não encontrada");
        }
        
       


        System.out.println("\n--------------------------------");
        System.out.println("\nPressione ENTER para voltar ao menu");
        System.in.read();

    }

    public void listaPlaylist() throws InterruptedException, IOException{
        Spootify.limpaTela();
        System.out.println(Spootify.ANSI_GREEN +"PLAYLISTS" + Spootify.ANSI_RESET);
        System.out.println("--------------------------------\n");
        for(String chave: listaPlaylists.keySet()){
            System.out.println(chave + " " + duracaoPlaylists(listaPlaylists.get(chave)));
        }
            
        System.out.println("\n--------------------------------");
        System.out.println("\nPressione ENTER para voltar ao menu");
        System.in.read();

    }


    public void listaPlaylistsContent(Scanner scan) throws InterruptedException, IOException{
        Spootify.limpaTela();
        String resp;
        System.out.println(Spootify.ANSI_GREEN+ "PLAYLISTS" + Spootify.ANSI_RESET);
        System.out.println("--------------------------------");
        for(String chave: listaPlaylists.keySet()){
            System.out.println(chave + " " + duracaoPlaylists(listaPlaylists.get(chave)));
        }
        System.out.println("\n-> De qual playlist deseja listar os conteúdos?\n");
        resp = scan.nextLine();
        System.out.println("\n--------------------------------\n");
        if(listaPlaylists.keySet().contains(resp)){
            for(int i = 0; i < listaPlaylists.get(resp).size(); i++){
                System.out.println(i+1 + listaPlaylists.get(resp).get(i).fomartString());

            }

        }else{
            System.out.println("Playlist não econtrada");
        }

        System.out.println("\n--------------------------------");
        System.out.println("\nPressione ENTER para voltar ao menu");
        System.in.read();


    }   


    public String duracaoPlaylists(ArrayList<Spootify> playlist){
        int soma = 0;
        for(int i = 0; i < playlist.size(); i++){
           soma += playlist.get(i).getDurucao();

        }
        return formatDuracao(soma);
    }




}
