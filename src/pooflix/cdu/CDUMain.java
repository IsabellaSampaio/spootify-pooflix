package cdu;

import java.sql.Connection;
import persistence.DBConnection;
import ui.*;

/**
 * Controlador de caso de uso principal
 * Função: controlar os demais CDU's
 */
public class CDUMain extends CDU {
    private FormMain formMain;
    private String url = "jdbc:postgresql://babar.db.elephantsql.com/stmhqghf";
    private String usuario = "stmhqghf";
    private String senha = "ddks5Z_6nS_Ef4sZLU64ZpCcE9-4RpIV";
    DBConnection db = null;
    Connection con = null;

    public CDUMain(FormMain formMain){
        this.formMain = formMain;
        this.formMain.setcdu(this);
    }  
    
    public void exec() {
        db = new DBConnection(url, usuario, senha);
        con = db.connection();

        if(con != null){
            System.out.println("Banco de dados conectado com sucesso!");
            formMain.exibe();
        }
    }

    public void processaOpcao(String opcao){
        switch(opcao) {
            case "1": execCadastro(); break;
            case "2": execRelatorio(); break;
            case "3": execAtualizacao(); break;
            case "4": execExclusao(); break;
        }
    }

    public void execCadastro(){
        FormCadastro telCadastro = new FormCadastro();
        CDUCadastro casoUsoCadastro = new CDUCadastro(telCadastro, db.getConnection());
        casoUsoCadastro.exec();
    }

    public void execRelatorio(){
        FormRelatorio telaRelatorio = new FormRelatorio();
        CDURelatorio casoUsoRelatorio = new CDURelatorio(telaRelatorio, db.getConnection());
        casoUsoRelatorio.exec();        
    }

    public void execAtualizacao(){
        FormAtualizacao formAtualizacao = new FormAtualizacao();
        CDUAtualizacao casoUsoAtualizacao = new CDUAtualizacao(formAtualizacao, con);
        casoUsoAtualizacao.exec();
    }

    public void execExclusao(){
        FormExclusao formExclusao = new FormExclusao();
        CDUExclusao casoUsoExclusao = new CDUExclusao(formExclusao, con);
        casoUsoExclusao.exec();
    }
}
