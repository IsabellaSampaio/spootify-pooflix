package ui;

import java.io.Console;

import cdu.CDUCadastro;

/**
 * Gerenciador de formulário - Cadastro
 * Função: Controlar inputs do usuário para com cadastramento de dados
 */
public class FormCadastro extends Form {
    CDUCadastro cduc = null;

    public void setcua(CDUCadastro cduc){
        this.cduc = cduc;
    }

    @Override
    public void exibe() {
        Console c = System.console();
        String opcao;
        boolean termina = false;

        System.out.println("Cadastrar\n");

        while(!termina){
            System.out.println("1. Série");
            System.out.println("2. Episódio");
            System.out.println("3. Ator");
            System.out.println("4. Personagem");
            System.out.println("5. Performance");
            System.out.println("6. Voltar");

            opcao = c.readLine("Digite a opção desejada: ");

            termina = opcao.equals("6");

            if(!termina)
                cduc.processaOpcao(opcao);
        }
    }
}
