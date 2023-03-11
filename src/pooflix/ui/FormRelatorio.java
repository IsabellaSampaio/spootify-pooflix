package ui;

import java.io.Console;

import cdu.CDURelatorio;

/**
 * Gerenciador de formulário - Relatório
 * Função: Controlar inputs do usuário para com relatório geral de dados
 */
public class FormRelatorio extends Form {
    CDURelatorio cdur = null;

    public void setcdur(CDURelatorio cdur){
        this.cdur = cdur;
    }
    
    public void exibe(){
        Console c = System.console();
        String opcao;
        boolean termina = false;

        System.out.println("Relatório\n");

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
                cdur.processaOpcao(opcao);
        }

    }
}
