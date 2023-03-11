package ui;

import java.io.Console;
import cdu.CDUMain;

/**
 * Gerenciador de formulário - Geral
 * Função: Controlar as opções principais do menu (CRUD)
 */
public class FormMain extends Form {
    private CDUMain cdumain = null;

    public void setcdu(CDUMain cdumain){
        this.cdumain = cdumain;
    }

    public void exibe() {
        String opcao;
        Console c = System.console();
        boolean termina = false;

        System.out.println("POOFlix\n");

        while(!termina){
            System.out.println("1. Cadastrar\n");
            System.out.println("2. Relatório\n");
            System.out.println("3. Alteração\n");
            System.out.println("4. Exclusao\n");
            System.out.println("5. Sair\n");
          
            opcao = c.readLine("Digite a opção desejada: ");

            termina = opcao.equals("5");

            if(!termina)
                cdumain.processaOpcao(opcao);    
        }
    }    
}
