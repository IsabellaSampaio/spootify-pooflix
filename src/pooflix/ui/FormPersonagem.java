package ui;

import java.io.Console;
import cdu.CDUPersonagem;
import dominio.Personagem;

/**
 * Gerenciador de formulário - Personagem
 * Função: Registrar inputs do usuário e criar objeto Personagem
 */
public class FormPersonagem extends Form {
    private String id;
    private String nome;
    private CDUPersonagem cdupe;

    public void setcdupe(CDUPersonagem cdupe){
        this.cdupe = cdupe;
    }

    public void exibe(){
        Console c = System.console();
        boolean termina = false;
        String continuar;

        System.out.println("CADASTRANDO PERSONAGEM\n");

        while(!termina){
            id = c.readLine("ID: ");
            nome = c.readLine("Nome: ");

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");
;
            if(cdupe.salvarPersonagem() == 0){
                System.out.println("Personagem " + nome +" cadastrado com sucesso!");
            }else{
                System.out.println("Não foi possível cadastrar o personagem: "+ nome);
            }  
        }
    }

    //Faz o update de personagem de acordo com o que o usuário decidir mudar
    public void exibeAtualizarPersonagem(){
        Console c = System.console();
        boolean termina = false;
        String continuar;
        String updt; 

        System.out.println("UPDATE DE DADOS DE PERSONAGEM\n");

        while(!termina){
            id = c.readLine("ID do personagem que deseja mudar os dados: ");
            //verificação, para saber se personagem existe no banco de dados
            Personagem personagem = cdupe.getPersonagem(id);
            if(id.equals(personagem.getid())){
                System.out.println(personagem);
                updt = c.readLine("O que deseja mudar deste personagem? Digite (No)me");
                if(updt.equals("No")){
                    nome = c.readLine("Qual será o novo nome desse personagem? ");

                    if(cdupe.atualizarPersonagem() == 0){
                        System.out.println("Personagem " + nome +" atualizado com sucesso!");
                    }else{
                        System.out.println("Não foi possível atualizar o personagem: "+ nome);
                    }  
                }
            }else{
                System.out.println("Erro! ID não encontrado no banco de dados, tente novamente");
            }
            continuar = c.readLine("Deseja mudar mais alguma coisa? (s/n): ");
            termina = continuar.toLowerCase().equals("n");
        }
    }

    //Deleta um personagem do banco de dados
    public void exibeDeletarPersonagem(){
        Console c = System.console();

        System.out.println("DELETANDO PERSONAGEM\n");

        id = c.readLine("ID do personagem que deseja deletar do banco de dados: ");
        Personagem personagem = cdupe.getPersonagem(id);
        //Verifica se o id existe no banco de dados
        if(id.equals(personagem.getid())){
            System.out.println(personagem);

            if(cdupe.deletarPersonagem() == 0){
                System.out.println("Episódio deletado com sucesso!");
            }else{
                System.out.println("Não foi possível deletar o personagem!");
            }  
        }
    }

    public String getid(){
        return id;
    }

    public String getnome(){
        return nome;
    }
}
