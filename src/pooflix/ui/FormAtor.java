package ui;
import java.io.Console;

import cdu.CDUAtor;
import dominio.Ator;

/**
 * Gerenciador de formulário - ator
 * Função: Registrar inputs do usuários e criar objeto ator
 */
public class FormAtor extends Form {
    private String id;
    private String nome;
    private String nacionalidade;
    private CDUAtor cdua;

    public void setcdua(CDUAtor cdua){
        this.cdua = cdua;
    }

    public void exibe(){
        Console c = System.console();
        boolean termina = false;
        String continuar;

        System.out.println("CADASTRANDO ATOR\n");

        while(!termina){
            id = c.readLine("ID: ");
            nome = c.readLine("Nome: ");
            nacionalidade = c.readLine("Nacionalidade: ");

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");

            if(cdua.salvarAtor() == 0){
                System.out.println("Ator: "+ nome +" cadastrado com sucesso!");
            }else{
                System.out.println("Não foi possível cadastrar o ator: " + nome);
            }
        }
    }

    //Faz o update do ator de acordo com o que o usuário decidir mudar
    public void exibeAtualizarAtor(){
        Console c = System.console();
        boolean termina = false;
        String continuar;
        String updt; 

        System.out.println("UPDATE DE DADOS DE ATOR\n");

        while(!termina){
            id = c.readLine("ID do ator que deseja mudar os dados: ");
            Ator ator = cdua.getAtor(id);
            //verificação, para saber se ator existe no banco de dados
            if(ator.getid().equals(id)){
                System.out.println(ator);
                updt = c.readLine("O que deseja mudar deste ator? Digite (No)me ou (Na)cionalidade: ");
                if(updt.equals("No")){
                    nome = c.readLine("Qual o novo nome do ator? ");
                }else if(updt.equals("Na")){
                    nacionalidade = c.readLine("Qual a nova nacionalidade do ator? ");
                }

                if(cdua.atualizarAtor() == 0){
                    System.out.println("Ator atualizado com sucesso!");
                }else{
                    System.out.println("Não foi possível atualizar o ator!");
                }
            }else{
                System.out.println("Erro! Nome não encontrado no banco de dados, tente novamente");
                continuar = c.readLine("Deseja tentar novamente? (s/n): ");
                termina = continuar.toLowerCase().equals("n");
            }
            continuar = c.readLine("Deseja mudar mais algum ator? (s/n): ");
            termina = continuar.toLowerCase().equals("n");
            nome = null;
            nacionalidade = null;
        }
    }

    //Deleta um ator do banco de dados
    public void exibeDeletarAtor(){
        Console c = System.console();

        System.out.println("DELETANDO ATOR\n");
        id = c.readLine("ID do ator que deseja deletar do banco de dados: ");
        Ator ator = cdua.getAtor(id);
        //Verifica se o id existe no banco de dados
        if(id.equals(this.getid())){
            System.out.println(ator);

            if(cdua.deletarAtor() == 0){
                System.out.println("Ator deletado com sucesso!");
            }else{
                System.out.println("Não foi possível deletar o ator!");
            }
        }

    }

    public String getid(){
        return id;
    }

    public String getnome(){
        return nome;
    }

    public String getnacionalidade(){
        return nacionalidade;
    }
}
