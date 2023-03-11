package ui;

import java.io.Console;

import cdu.CDUAtualizacao;

/**
 * Gerenciador de formulário - atualização
 * Função: Controlar inputs do usuário para com atualizações de dados
 */
public class FormAtualizacao extends Form {
    CDUAtualizacao cdua = null;

    public void setcua(CDUAtualizacao cdua){
        this.cdua = cdua;
    }

    @Override
    public void exibe() {
        Console c = System.console();
        String opcao;
        boolean termina = false;

        System.out.println("Atualizar\n");

        while(!termina){
            System.out.println("1. Série");
            System.out.println("2. Episódio");
            System.out.println("3. Ator");
            System.out.println("4. Personagem");
            System.out.println("5. Voltar");

            opcao = c.readLine("Digite a opção desejada: ");

            termina = opcao.equals("5");

            if(!termina)
                cdua.processaOpcao(opcao);
        }
    }
}
