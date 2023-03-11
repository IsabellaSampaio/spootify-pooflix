package ui;

import java.io.Console;
import cdu.*;
import dominio.Episodio;

/**
 * Gerenciador de formulário - Episódio
 * Função: Registrar inputs do usuário e criar objeto episódio
 */
public class FormEpisodio extends Form{
    private String id;
    private String idserie;
    private String temporada;
    private String titulo;
    private String resumo;
    private CDUEpis cdue;

    public void setcdue(CDUEpis cdue){
        this.cdue = cdue;
    }

    public void exibe(){
        Console c = System.console();
        boolean termina = false;
        String continuar;     
        boolean leserie = true;
        boolean leepisodio = false;  
        String nomeserie = null;

        System.out.println("CADASTRANDO EPISODIO\n");

        while(!termina){
            if(leserie){
                idserie = c.readLine("Qual série?(id): ");
                nomeserie = cdue.getNomeSerie(Integer.parseInt(idserie));
                leepisodio = nomeserie != null;

                if(nomeserie == null) {
                    System.err.println("!!série não existe !!");
                    leserie = true;
                    leepisodio = false;
                    termina = false; 
                }
            }

            if(leepisodio){
                id = c.readLine("@" + nomeserie + ">ID: ");
                temporada = c.readLine("@" + nomeserie + ">Temporada: ");
                titulo = c.readLine("@" + nomeserie + ">Titulo: ");
                resumo = c.readLine("@" + nomeserie + ">Resumo: ");

                if(cdue.salvarEpisodio() == 0){
                    System.out.println("Episódio " + titulo +" cadastrado com sucesso!");
                }else{
                    System.out.println("Não foi possível cadastrar o episódio: "+ titulo);
                }  

                continuar = c.readLine("(S)erie (E)pisodio (T)erminar): ");

                if(continuar.toLowerCase().equals("s")){
                    leserie = true;
                    leepisodio = false;
                    termina = false;                    
                }
                else
                    if(continuar.toLowerCase().equals("e")){
                        leserie = false;
                        leepisodio = true;
                        termina = false;                    
                    }else{
                       termina = true;
                    }
            } 
        } 
    } 

    //Faz o update de episódio de acordo com o que o usuário decidir mudar
    public void exibeAtualizarEpisodio(){
        Console c = System.console();
        boolean termina = false;
        String continuar;
        String updt;
 
        System.out.println("UPDATE DE DADOS DE EPISÓDIO\n");

        while(!termina){
            id = c.readLine("ID do episódio que deseja mudar os dados: ");
            Episodio ep = cdue.getEpisodio(id);
            //Verificação, para saber se id de episódio existe no banco de dados
            if(id.equals(ep.getid())){
                System.out.println(ep);
                updt = c.readLine("O que deseja mudar deste episódio? Digite (Te)mporada, (Ti)tulo, (R)esumo: ");
                if(updt.equals("Te")){
                    temporada = c.readLine("Qual será o novo nome/id da temporada? ");
                    if(temporada.equals(ep.gettemporada())){
                        temporada = c.readLine("Esse nome/id de temporada já existe no banco de dados, tente outro: ");
                    }
                }else if(updt.equals("Ti")){
                titulo = c.readLine("Qual será o novo título do episódio? ");
                //Precisa verificar se o título já existe no banco de dados ou não?
                }else if(updt.equals("R")){
                resumo = c.readLine("Qual será o novo resumo desse episódio? ");
                }

                if(cdue.atualizarEpisodio() == 0){
                    System.out.println("Episódio atualizado com sucesso!");
                }else{
                    System.out.println("Não foi possível atualizar o episódio!");
                }  
            }else{
                System.out.println("Erro! ID não encontrado no banco de dados, tente novamente");
            }
            continuar = c.readLine("Deseja mudar mais alguma coisa? (s/n): ");
            termina = continuar.toLowerCase().equals("n");
            temporada = null;
            titulo = null;
            resumo = null;
        }
    }

    //Deleta um ator do banco de dados
    public void exibeDeletarEpisodio(){
        Console c = System.console();

        System.out.println("DELETANDO EPISÓDIO\n");

        id = c.readLine("ID do episódio que deseja deletar do banco de dados");
        Episodio episodio = cdue.getEpisodio(id);
        //Verifica se o id existe no banco de dados
        if(id.equals(episodio.getid())){
            System.out.println(episodio);
      
            if(cdue.deletarEpisodio() == 0){
                System.out.println("Episódio deletado com sucesso!");
            }else{
                System.out.println("Não foi possível deletar o episódio!");
            }  
        }
    }

    public String getid() { return id;};
    public String getidserie() { return idserie;}
    public String gettemporada() { return temporada;}
    public String gettitulo() { return titulo;}
    public String getresumo() { return resumo; }    
} // class