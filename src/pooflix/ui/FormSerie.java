package ui;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;
import cdu.*;
import dominio.*;

/**
 * Gerenciador de formulário - Série
 * Função: Registrar inputs do usuário e criar objeto Série
 */
public class FormSerie extends Form {
    private String id;
    private String titulo;
    private String idademin;
    private CDUSerie cdus;
    private LinkedList<Categoria> serieCategorias;

    public void setcdu(CDUSerie cdus){
        this.cdus = cdus;
    }

    public void exibe() {
        Console c = System.console();
        boolean termina = false;
        boolean terminaCat = false;
        String continuarCat;
        String continuar;   
        String cat;     
        Categoria catg = null;

        System.out.println("CADASTRANDO SÉRIE\n");
        
        //Pega todas as categorias do banco de dados
        serieCategorias = new LinkedList<Categoria>();
        List<Categoria> categorias = cdus.getCategorias();
        
        while(!termina){
            id = c.readLine("ID: ");
            titulo = c.readLine("Titulo: ");
            idademin = c.readLine("Idade mínima: ");

            for(Categoria categoria : categorias){
                System.out.println(categoria);
            }

            while(!terminaCat){
                cat = c.readLine("Qual a categoria da série? Digite (A)ção, (AV)entura, (C)omedia, (D)rama, (V)iolencia, (S)exo, (L)inguagem: ");
                //Loop que pega o input do usuário e de acordo com o que ele decidir, adiciona-se na lista
                switch(cat){
                    case "A": catg = new Categoria(categorias.get(1).getid(), null); break;
                    case "AV": catg = new Categoria(categorias.get(2).getid(), null); break;
                    case "C": catg = new Categoria(categorias.get(0).getid(), null); break;
                    case "D": catg = new Categoria(categorias.get(3).getid(), null); break;
                    case "V": catg = new Categoria(categorias.get(4).getid(), null); break;
                    case "S": catg = new Categoria(categorias.get(5).getid(), null); break;
                    case "L": catg = new Categoria(categorias.get(6).getid(), null); break;
                }
                //Adiciona categoria na lista de categorias
                serieCategorias.add(catg);
                //Pergunta se o usuário deseja inserir mais uma categoria na série
                continuarCat = c.readLine("Deseja adicionar mais categorias a série?(s/n): ");
                terminaCat = continuarCat.toLowerCase().equals("n");
            }
            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");

            if(cdus.salvarSerie() == 0){
                System.out.println("Serie: "+ titulo +" cadastrada com sucesso!");
            }else{
                System.out.println("Não foi possível cadastrar a serie!");
            }
        }
    }

    public void exibeAtualizarSerie(){
        //Faz o update de série de acordo com o que o usuário decidir mudar
        Console c = System.console();
        boolean termina = false;
        String continuar;
        String updt;

        System.out.println("UPDATE DE DADOS DE SÉRIE\n");

        while(!termina){
            id = c.readLine("ID da série que deseja mudar os dados: ");
            //Verificação, para saber se personagem existe no banco de dados
            Serie serie = cdus.getSerie(id);
            if(id.equals(serie.getid())){
                System.out.println(serie);
                updt = c.readLine("O que deseja mudar desta série? Digite (T)itulo, (I)dade mínima: ");
                
                if(updt.equals("T")){
                    titulo = c.readLine("Qual será o novo título dessa série? ");
                    idademin = "0";
                }else if(updt.equals("I")){
                    idademin = c.readLine("Qual será a nova idade mínima dessa série? ");

                }

                if(cdus.atualizarSerie() == 0){
                    System.out.println("Serie atualizada com sucesso!");
                }else{
                    System.out.println("Não foi possível atualizar a serie!");
                }
            }else{
                System.out.println("Erro! ID não encontrado no banco de dados, tente novamente");
            }
            continuar = c.readLine("Deseja mudar mais alguma coisa? (s/n): ");
            termina = continuar.toLowerCase().equals("n");
            titulo = null;
            idademin = null;
        }
    }

    //Deleta uma série do banco de dados
    public void exibeDeletarSerie(){
        Console c = System.console();

        System.out.println("DELETANDO SÉRIE\n");

        id = c.readLine("ID da série que deseja deletar do banco de dados: ");
        Serie serie = cdus.getSerie(id);
        //verificando se o id existe no banco de dados
        if(id.equals(serie.getid())){
            System.out.println(serie);

            if(cdus.deletarSerie() == 0){
                System.out.println("Serie deletada com sucesso!");
            }else{
                System.out.println("Não foi possível deletar a serie!");
            }
        }else{
            System.out.printf("Serie não encontrada no banco de dados..");
        }
    }

    public String getid(){
        return id;
    }

    public String gettitulo(){
        return titulo;
    }

    public String getidademin(){
        return idademin;
    }

    public LinkedList<Categoria> getcategoria(){
        return serieCategorias;
    }
}