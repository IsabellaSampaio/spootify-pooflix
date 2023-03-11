package ui;

import java.io.Console;

import cdu.CDUExclusao;

/**
 * Gerenciador de formulário - Exclusão
 * Função: Controlar inputs do usuário para com exclusão de dados
 */
public class FormExclusao {
    CDUExclusao cdue = null;

    public void setcdue(CDUExclusao cdue){
        this.cdue = cdue;
    }

    public void exibe(){
        Console c = System.console();
        String opcao;
        boolean termina = false;

        System.out.println("Excluir\n");

        while(!termina){
            System.out.println("1. Série");
            System.out.println("2. Episódio");
            System.out.println("3. Ator");
            System.out.println("4. Personagem");
            System.out.println("5. Voltar");

            opcao = c.readLine("Digite a opção desejada: ");

            termina = opcao.equals("5");

            if(!termina)
                cdue.processaOpcao(opcao);
        }
    }
}
