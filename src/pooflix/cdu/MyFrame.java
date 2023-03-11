package cdu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import dominio.*;
import persistence.DAOAtor;
import persistence.DAOCategoria;
import persistence.DAOEpisodio;
import persistence.DAOPerformance;
import persistence.DAOPersonagem;
import persistence.DAOSerie;
import persistence.DBConnection;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * Tela GUI do projeto
 * Funções: As mesmas dos CDU's porém de maneira gráfica
 */
public class MyFrame extends JFrame implements ActionListener{

    //Variáveis: botões da tela 
    public JButton button;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public JButton button5;
    public JButton button6;
    public JButton button7;
    public JButton button8;
    public JButton button9;
    public JButton button10;
    public JButton button11;
    public JButton button12;
    public JButton button13;
    public JButton button14;
    public JButton button15;
    public JButton button16;
    public JButton button17;
    public JButton button18;
    public JButton button19;
    public JButton button20;
    public JButton button21;
    public JButton button22;
    public JButton button23;
    public JButton button24;
    public JButton button25;
    public JButton button26;
    public JButton button27;
    public JButton button28;
    public JButton button29;
    public JButton button30;
    public JButton button31;
    public JButton button32;
    public JButton button33;
    public JButton button34;
    public JButton button35;
    public JButton button36;
    public JButton button37;
    public JButton button38;
    public JButton button39;
    public JButton button40;
    public JButton button41;
    public JButton button42;
    public JButton button43;
    public JButton button44;
    public JButton button45;
    public JButton button46;
    public JButton button47;
    public JButton button48;

    //Variavéis: outras
    public Ator ator;
    public Serie serie;
    public Episodio ep;
    public Personagem personagem;
    public Performance perf;
    public JTextArea area;
    public JTextArea areaRelatorio;
    public JScrollPane sp;
    public JLabel label;
    public JLabel cadAtor;
    public JLabel cadSerie;
    public JLabel cadEp;
    public JLabel cadPerso;
    public JLabel cadPerf;
    public JLabel uptAtor;
    public JLabel uptSerie;
    public JLabel uptEp;
    public JLabel uptPerso;
    public JLabel delAtor;
    public JLabel delSerie;
    public JLabel delEp;
    public JLabel delPerso;
    public HashMap<String, String> cat;

    String[] categorias = {"Ação", "Aventura", "Comédia", "Drama", "Violência", "Sexo", "Linguagem"};
    public JComboBox<String> list;
    public JList<String> check;
    public JScrollPane spc;

    //Conexão com banco de dados 
    public String url = "jdbc:postgresql://babar.db.elephantsql.com/stmhqghf";
    public String usuario = "stmhqghf";
    public String senha = "ddks5Z_6nS_Ef4sZLU64ZpCcE9-4RpIV";

    DBConnection db = null;
    Connection con = null;

    //GUI do projeto
    MyFrame(){
        cat = new HashMap<String, String>();
        cat.put("Comédia", "1");
        cat.put("Ação","2");
        cat.put("Aventura","3");
        cat.put("Drama", "4");
        cat.put("Violência", "5");
        cat.put("Sexo", "6");
        cat.put("Linguagem", "7");


        db = new DBConnection(url, usuario, senha);
        con = db.connection();

        //Tela de cadastro e suas funções
        TelaCadastro.idAtor = new JLabel("Id");
        TelaCadastro.idAtor.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.idAtor.setSize(100, 20);
        TelaCadastro.idAtor.setLocation(100,100);
        TelaCadastro.idAtor.setVisible(false);
        this.add(TelaCadastro.idAtor);
        
        TelaCadastro.nomeAtor = new JLabel("Nome");
        TelaCadastro.nomeAtor.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.nomeAtor.setSize(100, 20);
        TelaCadastro.nomeAtor.setLocation(100,150);
        TelaCadastro.nomeAtor.setVisible(false);
        this.add(TelaCadastro.nomeAtor);

        TelaCadastro.nacionalidadeAtor = new JLabel("Nacionalidade");
        TelaCadastro.nacionalidadeAtor.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.nacionalidadeAtor.setSize(100, 20);
        TelaCadastro.nacionalidadeAtor.setLocation(100,200);
        TelaCadastro.nacionalidadeAtor.setVisible(false);
        this.add(TelaCadastro.nacionalidadeAtor);

        TelaCadastro.textId = new JTextField();
        TelaCadastro.textId.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textId.setSize(150, 20);
        TelaCadastro.textId.setLocation(200, 100);
        TelaCadastro.textId.setVisible(false);
        this.add(TelaCadastro.textId);

        TelaCadastro.textNome = new JTextField();
        TelaCadastro.textNome.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textNome.setSize(150, 20);
        TelaCadastro.textNome.setLocation(200, 150);
        TelaCadastro.textNome.setVisible(false);
        this.add(TelaCadastro.textNome);

        TelaCadastro.textNacionalidade = new JTextField();
        TelaCadastro.textNacionalidade.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textNacionalidade.setSize(150, 20);
        TelaCadastro.textNacionalidade.setLocation(200, 200);
        TelaCadastro.textNacionalidade.setVisible(false);
        this.add(TelaCadastro.textNacionalidade);

        TelaCadastro.idSerie = new JLabel("Id");
        TelaCadastro.idSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.idSerie.setSize(100, 20);
        TelaCadastro.idSerie.setLocation(100,100);
        TelaCadastro.idSerie.setVisible(false);
        this.add(TelaCadastro.idSerie);

        TelaCadastro.tituloSerie = new JLabel("Título");
        TelaCadastro.tituloSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.tituloSerie.setSize(100, 20);
        TelaCadastro.tituloSerie.setLocation(100,150);
        TelaCadastro.tituloSerie.setVisible(false);
        this.add(TelaCadastro.tituloSerie);

        TelaCadastro.idadeSerie = new JLabel("Classe Etária");
        TelaCadastro.idadeSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.idadeSerie.setSize(100, 20);
        TelaCadastro.idadeSerie.setLocation(100,200);
        TelaCadastro.idadeSerie.setVisible(false);
        this.add(TelaCadastro.idadeSerie);

        TelaCadastro.textIdSerie = new JTextField();
        TelaCadastro.textIdSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textIdSerie.setSize(150, 20);
        TelaCadastro.textIdSerie.setLocation(200, 100);
        TelaCadastro.textIdSerie.setVisible(false);
        this.add(TelaCadastro.textIdSerie);

        TelaCadastro.textTituloSerie = new JTextField();
        TelaCadastro.textTituloSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textTituloSerie.setSize(150, 20);
        TelaCadastro.textTituloSerie.setLocation(200, 150);
        TelaCadastro.textTituloSerie.setVisible(false);
        this.add(TelaCadastro.textTituloSerie);

        TelaCadastro.textIdadeSerie = new JTextField();
        TelaCadastro.textIdadeSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textIdadeSerie.setSize(150, 20);
        TelaCadastro.textIdadeSerie.setLocation(200, 200);
        TelaCadastro.textIdadeSerie.setVisible(false);
        this.add(TelaCadastro.textIdadeSerie);

        TelaCadastro.idEpSerie = new JLabel("Id da série");
        TelaCadastro.idEpSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.idEpSerie.setSize(100, 20);
        TelaCadastro.idEpSerie.setLocation(100,100);
        TelaCadastro.idEpSerie.setVisible(false);
        this.add(TelaCadastro.idEpSerie);

        TelaCadastro.idEp = new JLabel("Id episódio");
        TelaCadastro.idEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.idEp.setSize(100, 20);
        TelaCadastro.idEp.setLocation(100,150);
        TelaCadastro.idEp.setVisible(false);
        this.add(TelaCadastro.idEp);

        TelaCadastro.temporadaEp = new JLabel("Temporada");
        TelaCadastro.temporadaEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.temporadaEp.setSize(100, 20);
        TelaCadastro.temporadaEp.setLocation(100,200);
        TelaCadastro.temporadaEp.setVisible(false);
        this.add(TelaCadastro.temporadaEp);
        
        TelaCadastro.tituloEp = new JLabel("Titulo");
        TelaCadastro.tituloEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.tituloEp.setSize(100, 20);
        TelaCadastro.tituloEp.setLocation(100,250);
        TelaCadastro.tituloEp.setVisible(false);
        this.add(TelaCadastro.tituloEp);

        TelaCadastro.resumoEp = new JLabel("Resumo");
        TelaCadastro.resumoEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.resumoEp.setSize(100, 20);
        TelaCadastro.resumoEp.setLocation(100,300);
        TelaCadastro.resumoEp.setVisible(false);
        this.add(TelaCadastro.resumoEp);

        TelaCadastro.textIdSerieEp = new JTextField();
        TelaCadastro.textIdSerieEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textIdSerieEp.setSize(150, 20);
        TelaCadastro.textIdSerieEp.setLocation(200, 100);
        TelaCadastro.textIdSerieEp.setVisible(false);
        this.add(TelaCadastro.textIdSerieEp);

        TelaCadastro.textIdEp = new JTextField();
        TelaCadastro.textIdEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textIdEp.setSize(150, 20);
        TelaCadastro.textIdEp.setLocation(200, 150);
        TelaCadastro.textIdEp.setVisible(false);
        this.add(TelaCadastro.textIdEp);

        TelaCadastro.textTempEp = new JTextField();
        TelaCadastro.textTempEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textTempEp.setSize(150, 20);
        TelaCadastro.textTempEp.setLocation(200, 200);
        TelaCadastro.textTempEp.setVisible(false);
        this.add(TelaCadastro.textTempEp);

        TelaCadastro.textTituloEp = new JTextField();
        TelaCadastro.textTituloEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textTituloEp.setSize(150, 20);
        TelaCadastro.textTituloEp.setLocation(200, 250);
        TelaCadastro.textTituloEp.setVisible(false);
        this.add(TelaCadastro.textTituloEp);

        TelaCadastro.textResumoEp = new JTextArea();
        TelaCadastro.textResumoEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textResumoEp.setSize(200, 75);
        TelaCadastro.textResumoEp.setLocation(200, 300);
        TelaCadastro.textResumoEp.setVisible(false);
        this.add(TelaCadastro.textResumoEp);

        TelaCadastro.idPersonagem = new JLabel("Id");
        TelaCadastro.idPersonagem.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.idPersonagem.setSize(100, 20);
        TelaCadastro.idPersonagem.setLocation(100,100);
        TelaCadastro.idPersonagem.setVisible(false);
        this.add(TelaCadastro.idPersonagem);
        
        TelaCadastro.nomePersonagem = new JLabel("Nome");
        TelaCadastro.nomePersonagem.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.nomePersonagem.setSize(100, 20);
        TelaCadastro.nomePersonagem.setLocation(100,150);
        TelaCadastro.nomePersonagem.setVisible(false);
        this.add(TelaCadastro.nomePersonagem);

        TelaCadastro.textIdPersonagem = new JTextField();
        TelaCadastro.textIdPersonagem.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textIdPersonagem.setSize(150, 20);
        TelaCadastro.textIdPersonagem.setLocation(200,100);
        TelaCadastro.textIdPersonagem.setVisible(false);
        this.add(TelaCadastro.textIdPersonagem);

        TelaCadastro.textNomePersonagem = new JTextField();
        TelaCadastro.textNomePersonagem.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textNomePersonagem.setSize(150, 20);
        TelaCadastro.textNomePersonagem.setLocation(200,150);
        TelaCadastro.textNomePersonagem.setVisible(false);
        this.add(TelaCadastro.textNomePersonagem);

        TelaCadastro.idPerfEp = new JLabel("Id do ep");
        TelaCadastro.idPerfEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.idPerfEp.setSize(100, 20);
        TelaCadastro.idPerfEp.setLocation(100,100);
        TelaCadastro.idPerfEp.setVisible(false);
        this.add(TelaCadastro.idPerfEp);

        TelaCadastro.idPerfPer = new JLabel("Id do personagem");
        TelaCadastro.idPerfPer.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.idPerfPer.setSize(100, 20);
        TelaCadastro.idPerfPer.setLocation(100,150);
        TelaCadastro.idPerfPer.setVisible(false);
        this.add(TelaCadastro.idPerfPer);

        TelaCadastro.idPerfAtor = new JLabel("Id do ator");
        TelaCadastro.idPerfAtor.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.idPerfAtor.setSize(100, 20);
        TelaCadastro.idPerfAtor.setLocation(100,200);
        TelaCadastro.idPerfAtor.setVisible(false);
        this.add(TelaCadastro.idPerfAtor);

        TelaCadastro.textPerfEp = new JTextField();
        TelaCadastro.textPerfEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textPerfEp.setSize(150, 20);
        TelaCadastro.textPerfEp.setLocation(200,100);
        TelaCadastro.textPerfEp.setVisible(false);
        this.add(TelaCadastro.textPerfEp);

        TelaCadastro.textPerfPer = new JTextField();
        TelaCadastro.textPerfPer.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textPerfPer.setSize(150, 20);
        TelaCadastro.textPerfPer.setLocation(200,150);
        TelaCadastro.textPerfPer.setVisible(false);
        this.add(TelaCadastro.textPerfPer);

        TelaCadastro.textPerfAtor = new JTextField();
        TelaCadastro.textPerfAtor.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaCadastro.textPerfAtor.setSize(150, 20);
        TelaCadastro.textPerfAtor.setLocation(200,200);
        TelaCadastro.textPerfAtor.setVisible(false);
        this.add(TelaCadastro.textPerfAtor);


        //Tela de update e suas funções
        TelaUpdate.idAtor = new JLabel("Id");
        TelaUpdate.idAtor.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.idAtor.setSize(100, 20);
        TelaUpdate.idAtor.setLocation(100,100);
        TelaUpdate.idAtor.setVisible(false);
        this.add(TelaUpdate.idAtor);
        
        TelaUpdate.nomeAtor = new JLabel("Nome");
        TelaUpdate.nomeAtor.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.nomeAtor.setSize(100, 20);
        TelaUpdate.nomeAtor.setLocation(100,150);
        TelaUpdate.nomeAtor.setVisible(false);
        this.add(TelaUpdate.nomeAtor);

        TelaUpdate.nacionalidadeAtor = new JLabel("Nacionalidade");
        TelaUpdate.nacionalidadeAtor.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.nacionalidadeAtor.setSize(100, 20);
        TelaUpdate.nacionalidadeAtor.setLocation(100,200);
        TelaUpdate.nacionalidadeAtor.setVisible(false);
        this.add(TelaUpdate.nacionalidadeAtor);

        TelaUpdate.textId = new JTextField();
        TelaUpdate.textId.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.textId.setSize(150, 20);
        TelaUpdate.textId.setLocation(200, 100);
        TelaUpdate.textId.setVisible(false);
        this.add(TelaUpdate.textId);

        TelaUpdate.textNome = new JTextField();
        TelaUpdate.textNome.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.textNome.setSize(150, 20);
        TelaUpdate.textNome.setLocation(200, 150);
        TelaUpdate.textNome.setVisible(false);
        this.add(TelaUpdate.textNome);

        TelaUpdate.textNacionalidade = new JTextField();
        TelaUpdate.textNacionalidade.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.textNacionalidade.setSize(150, 20);
        TelaUpdate.textNacionalidade.setLocation(200, 200);
        TelaUpdate.textNacionalidade.setVisible(false);
        this.add(TelaUpdate.textNacionalidade);

        TelaUpdate.idSerie = new JLabel("Id");
        TelaUpdate.idSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.idSerie.setSize(100, 20);
        TelaUpdate.idSerie.setLocation(100,100);
        TelaUpdate.idSerie.setVisible(false);
        this.add(TelaUpdate.idSerie);

        TelaUpdate.tituloSerie = new JLabel("Título");
        TelaUpdate.tituloSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.tituloSerie.setSize(100, 20);
        TelaUpdate.tituloSerie.setLocation(100,150);
        TelaUpdate.tituloSerie.setVisible(false);
        this.add(TelaUpdate.tituloSerie);

        TelaUpdate.idadeSerie = new JLabel("Classe Etária");
        TelaUpdate.idadeSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.idadeSerie.setSize(100, 20);
        TelaUpdate.idadeSerie.setLocation(100,200);
        TelaUpdate.idadeSerie.setVisible(false);
        this.add(TelaUpdate.idadeSerie);

        TelaUpdate.textIdSerie = new JTextField();
        TelaUpdate.textIdSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.textIdSerie.setSize(150, 20);
        TelaUpdate.textIdSerie.setLocation(200, 100);
        TelaUpdate.textIdSerie.setVisible(false);
        this.add(TelaUpdate.textIdSerie);

        TelaUpdate.textTituloSerie = new JTextField();
        TelaUpdate.textTituloSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.textTituloSerie.setSize(150, 20);
        TelaUpdate.textTituloSerie.setLocation(200, 150);
        TelaUpdate.textTituloSerie.setVisible(false);
        this.add(TelaUpdate.textTituloSerie);

        TelaUpdate.textIdadeSerie = new JTextField();
        TelaUpdate.textIdadeSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.textIdadeSerie.setSize(150, 20);
        TelaUpdate.textIdadeSerie.setLocation(200, 200);
        TelaUpdate.textIdadeSerie.setVisible(false);
        this.add(TelaUpdate.textIdadeSerie);

        TelaUpdate.idEp = new JLabel("Id episódio");
        TelaUpdate.idEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.idEp.setSize(100, 20);
        TelaUpdate.idEp.setLocation(100,100);
        TelaUpdate.idEp.setVisible(false);
        this.add(TelaUpdate.idEp);

        TelaUpdate.temporadaEp = new JLabel("Temporada");
        TelaUpdate.temporadaEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.temporadaEp.setSize(100, 20);
        TelaUpdate.temporadaEp.setLocation(100,150);
        TelaUpdate.temporadaEp.setVisible(false);
        this.add(TelaUpdate.temporadaEp);
        
        TelaUpdate.tituloEp = new JLabel("Titulo");
        TelaUpdate.tituloEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.tituloEp.setSize(100, 20);
        TelaUpdate.tituloEp.setLocation(100,200);
        TelaUpdate.tituloEp.setVisible(false);
        this.add(TelaUpdate.tituloEp);

        TelaUpdate.resumoEp = new JLabel("Resumo");
        TelaUpdate.resumoEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.resumoEp.setSize(100, 20);
        TelaUpdate.resumoEp.setLocation(100,250);
        TelaUpdate.resumoEp.setVisible(false);
        this.add(TelaUpdate.resumoEp);

        TelaUpdate.textIdEp = new JTextField();
        TelaUpdate.textIdEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.textIdEp.setSize(150, 20);
        TelaUpdate.textIdEp.setLocation(200, 100);
        TelaUpdate.textIdEp.setVisible(false);
        this.add(TelaUpdate.textIdEp);

        TelaUpdate.textTempEp = new JTextField();
        TelaUpdate.textTempEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.textTempEp.setSize(150, 20);
        TelaUpdate.textTempEp.setLocation(200, 150);
        TelaUpdate.textTempEp.setVisible(false);
        this.add(TelaUpdate.textTempEp);

        TelaUpdate.textTituloEp = new JTextField();
        TelaUpdate.textTituloEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.textTituloEp.setSize(150, 20);
        TelaUpdate.textTituloEp.setLocation(200, 200);
        TelaUpdate.textTituloEp.setVisible(false);
        this.add(TelaUpdate.textTituloEp);

        TelaUpdate.textResumoEp = new JTextArea();
        TelaUpdate.textResumoEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.textResumoEp.setSize(200, 75);
        TelaUpdate.textResumoEp.setLocation(200, 250);
        TelaUpdate.textResumoEp.setVisible(false);
        this.add(TelaUpdate.textResumoEp);

        TelaUpdate.idPersonagem = new JLabel("Id");
        TelaUpdate.idPersonagem.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.idPersonagem.setSize(100, 20);
        TelaUpdate.idPersonagem.setLocation(100,100);
        TelaUpdate.idPersonagem.setVisible(false);
        this.add(TelaUpdate.idPersonagem);
        
        TelaUpdate.nomePersonagem = new JLabel("Nome");
        TelaUpdate.nomePersonagem.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.nomePersonagem.setSize(100, 20);
        TelaUpdate.nomePersonagem.setLocation(100,150);
        TelaUpdate.nomePersonagem.setVisible(false);
        this.add(TelaUpdate.nomePersonagem);

        TelaUpdate.textIdPersonagem = new JTextField();
        TelaUpdate.textIdPersonagem.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.textIdPersonagem.setSize(150, 20);
        TelaUpdate.textIdPersonagem.setLocation(200,100);
        TelaUpdate.textIdPersonagem.setVisible(false);
        this.add(TelaUpdate.textIdPersonagem);

        TelaUpdate.textNomePersonagem = new JTextField();
        TelaUpdate.textNomePersonagem.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaUpdate.textNomePersonagem.setSize(150, 20);
        TelaUpdate.textNomePersonagem.setLocation(200,150);
        TelaUpdate.textNomePersonagem.setVisible(false);
        this.add(TelaUpdate.textNomePersonagem);

        //Tela de delete e suas funções
        TelaDelete.idAtor = new JLabel("Id do ator");
        TelaDelete.idAtor.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaDelete.idAtor.setSize(100, 20);
        TelaDelete.idAtor.setLocation(100,100);
        TelaDelete.idAtor.setVisible(false);
        this.add(TelaDelete.idAtor);

        TelaDelete.textId = new JTextField();
        TelaDelete.textId.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaDelete.textId.setSize(150, 20);
        TelaDelete.textId.setLocation(200, 100);
        TelaDelete.textId.setVisible(false);
        this.add(TelaDelete.textId);

        TelaDelete.idSerie = new JLabel("Id da série");
        TelaDelete.idSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaDelete.idSerie.setSize(100, 20);
        TelaDelete.idSerie.setLocation(100,100);
        TelaDelete.idSerie.setVisible(false);
        this.add(TelaDelete.idSerie);

        TelaDelete.textIdSerie = new JTextField();
        TelaDelete.textIdSerie.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaDelete.textIdSerie.setSize(150, 20);
        TelaDelete.textIdSerie.setLocation(200, 100);
        TelaDelete.textIdSerie.setVisible(false);
        this.add(TelaDelete.textIdSerie);

        TelaDelete.idEp = new JLabel("Id do episódio");
        TelaDelete.idEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaDelete.idEp.setSize(100, 20);
        TelaDelete.idEp.setLocation(100,100);
        TelaDelete.idEp.setVisible(false);
        this.add(TelaDelete.idEp);

        TelaDelete.textIdEp = new JTextField();
        TelaDelete.textIdEp.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaDelete.textIdEp.setSize(150, 20);
        TelaDelete.textIdEp.setLocation(200, 100);
        TelaDelete.textIdEp.setVisible(false);
        this.add(TelaDelete.textIdEp);

        TelaDelete.idPersonagem = new JLabel("Id do personagem");
        TelaDelete.idPersonagem.setFont(new Font("Lucidade Console", Font.PLAIN, 11));
        TelaDelete.idPersonagem.setSize(100, 20);
        TelaDelete.idPersonagem.setLocation(100,100);
        TelaDelete.idPersonagem.setVisible(false);
        this.add(TelaDelete.idPersonagem);
    
        TelaDelete.textIdPersonagem = new JTextField();
        TelaDelete.textIdPersonagem.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        TelaDelete.textIdPersonagem.setSize(150, 20);
        TelaDelete.textIdPersonagem.setLocation(200,100);
        TelaDelete.textIdPersonagem.setVisible(false);
        this.add(TelaDelete.textIdPersonagem);

        area = new JTextArea();
        area.setFont(new Font("Arial", Font.PLAIN, 15));
        area.setSize(300, 400);
        area.setLocation(500, 100);
        area.setLineWrap(true);
        area.setEditable(false);
        area.setVisible(false);
        this.add(area);

        areaRelatorio = new JTextArea();
        areaRelatorio.setFont(new Font("Arial", Font.PLAIN, 15));
        areaRelatorio.setSize(500, 500);
        areaRelatorio.setLocation(280, 100);
        areaRelatorio.setLineWrap(true);
        areaRelatorio.setEditable(false);
        areaRelatorio.setVisible(false);
        this.add(areaRelatorio);

        label = new JLabel("Categoria");
        label.setFont(new Font("Lucidade Console", Font.PLAIN, 15));
        label.setSize(100, 20);
        label.setLocation(100,250);
        label.setVisible(false);
        this.add(label);

        //Descrição do estilo dos botões
        button = new JButton();
        button.setBounds(150, 100, 150, 50);
        button.setVisible(true);
        button.setText("Cadastrar");
        button.setFocusable(false);
        button.setHorizontalTextPosition(JButton.LEFT);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setFont(new Font("Ink Free", Font.BOLD, 20));
        button.setBackground(new Color(0x99CCFF));
        button.addActionListener(this);
        this.add(button);


        button2 = new JButton();
        button2.setBounds(150, 170, 150, 50);
        button2.setVisible(true);
        button2.setText("Update");
        button2.setFocusable(false);
        button2.setHorizontalTextPosition(JButton.LEFT);
        button2.setVerticalTextPosition(JButton.CENTER);
        button2.setFont(new Font("Ink Free", Font.BOLD, 20));
        button2.setBackground(new Color(0x99CCFF));
        button2.addActionListener(this);
        this.add(button2);


        button3 = new JButton();
        button3.setBounds(150, 240, 150, 50);
        button3.setVisible(true);
        button3.setText("Delete");
        button3.setFocusable(false);
        button3.setHorizontalTextPosition(JButton.LEFT);
        button3.setVerticalTextPosition(JButton.CENTER);
        button3.setFont(new Font("Ink Free", Font.BOLD, 20));
        button3.setBackground(new Color(0x99CCFF));
        button3.addActionListener(this);
        this.add(button3);


        button4 = new JButton();
        button4.setBounds(150, 310, 150, 50);
        button4.setVisible(true);
        button4.setText("Relatório");
        button4.setFocusable(false);
        button4.setHorizontalTextPosition(JButton.LEFT);
        button4.setVerticalTextPosition(JButton.CENTER);
        button4.setFont(new Font("Ink Free", Font.BOLD, 20));
        button4.setBackground(new Color(0x99CCFF));
        button4.addActionListener(this);
        this.add(button4);

    
        button5 = new JButton();
        button5.setBounds(150, 100, 150, 50);
        button5.setVisible(false);
        button5.setText("Ator");
        button5.setFocusable(false);
        button5.setHorizontalTextPosition(JButton.LEFT);
        button5.setVerticalTextPosition(JButton.CENTER);
        button5.setFont(new Font("Ink Free", Font.BOLD, 20));
        button5.setBackground(new Color(0x99CCFF));
        button5.addActionListener(this);
        this.add(button5);

        button6 = new JButton();
        button6.setBounds(150, 170, 150, 50);
        button6.setVisible(false);
        button6.setText("Série");
        button6.setFocusable(false);
        button6.setHorizontalTextPosition(JButton.LEFT);
        button6.setVerticalTextPosition(JButton.CENTER);
        button6.setFont(new Font("Ink Free", Font.BOLD, 20));
        button6.setBackground(new Color(0x99CCFF));
        button6.addActionListener(this);
        this.add(button6);

        button7 = new JButton();
        button7.setBounds(150, 240, 150, 50);
        button7.setVisible(false);
        button7.setText("Episódio");
        button7.setFocusable(false);
        button7.setHorizontalTextPosition(JButton.LEFT);
        button7.setVerticalTextPosition(JButton.CENTER);
        button7.setFont(new Font("Ink Free", Font.BOLD, 20));
        button7.setBackground(new Color(0x99CCFF));
        button7.addActionListener(this);
        this.add(button7);

        button8 = new JButton();
        button8.setBounds(150, 310, 150, 50);
        button8.setVisible(false);
        button8.setText("Personagem");
        button8.setFocusable(false);
        button8.setHorizontalTextPosition(JButton.LEFT);
        button8.setVerticalTextPosition(JButton.CENTER);
        button8.setFont(new Font("Ink Free", Font.BOLD, 20));
        button8.setBackground(new Color(0x99CCFF));
        button8.addActionListener(this);
        this.add(button8);

        button9 = new JButton();
        button9.setBounds(150, 380, 150, 50);
        button9.setVisible(false);
        button9.setText("Performance");
        button9.setFocusable(false);
        button9.setHorizontalTextPosition(JButton.LEFT);
        button9.setVerticalTextPosition(JButton.CENTER);
        button9.setFont(new Font("Ink Free", Font.BOLD, 20));
        button9.setBackground(new Color(0x99CCFF));
        button9.addActionListener(this);
        this.add(button9);

        button10 = new JButton();
        button10.setBounds(200, 380, 150, 50);
        button10.setVisible(false);
        button10.setText("Adicionar");
        button10.setFocusable(false);
        button10.setHorizontalTextPosition(JButton.LEFT);
        button10.setVerticalTextPosition(JButton.CENTER);
        button10.setFont(new Font("Ink Free", Font.BOLD, 20));
        button10.setBackground(new Color(0x99CCFF));
        button10.addActionListener(this);
        this.add(button10);

        button11 = new JButton();
        button11.setBounds(200, 380, 150, 50);
        button11.setVisible(false);
        button11.setText("Adicionar");
        button11.setFocusable(false);
        button11.setHorizontalTextPosition(JButton.LEFT);
        button11.setVerticalTextPosition(JButton.CENTER);
        button11.setFont(new Font("Ink Free", Font.BOLD, 20));
        button11.setBackground(new Color(0x99CCFF));
        button11.addActionListener(this);
        this.add(button11);

        button12 = new JButton();
        button12.setBounds(200, 380, 150, 50);
        button12.setVisible(false);
        button12.setText("Adicionar");
        button12.setFocusable(false);
        button12.setHorizontalTextPosition(JButton.LEFT);
        button12.setVerticalTextPosition(JButton.CENTER);
        button12.setFont(new Font("Ink Free", Font.BOLD, 20));
        button12.setBackground(new Color(0x99CCFF));
        button12.addActionListener(this);
        this.add(button12);

        button13 = new JButton();
        button13.setBounds(200, 380, 150, 50);
        button13.setVisible(false);
        button13.setText("Adicionar");
        button13.setFocusable(false);
        button13.setHorizontalTextPosition(JButton.LEFT);
        button13.setVerticalTextPosition(JButton.CENTER);
        button13.setFont(new Font("Ink Free", Font.BOLD, 20));
        button13.setBackground(new Color(0x99CCFF));
        button13.addActionListener(this);
        this.add(button13);

        button14 = new JButton();
        button14.setBounds(200, 380, 150, 50);
        button14.setVisible(false);
        button14.setText("Adicionar");
        button14.setFocusable(false);
        button14.setHorizontalTextPosition(JButton.LEFT);
        button14.setVerticalTextPosition(JButton.CENTER);
        button14.setFont(new Font("Ink Free", Font.BOLD, 20));
        button14.setBackground(new Color(0x99CCFF));
        button14.addActionListener(this);
        this.add(button14);

        button15 = new JButton();
        button15.setBounds(40, 30, 100, 50);
        button15.setVisible(false);
        button15.setText("Voltar");
        button15.setFocusable(false);
        button15.setHorizontalTextPosition(JButton.LEFT);
        button15.setVerticalTextPosition(JButton.CENTER);
        button15.setFont(new Font("Ink Free", Font.BOLD, 15));
        button15.setBackground(new Color(0x99CCFF));
        button15.addActionListener(this);
        this.add(button15);

        button16 = new JButton();
        button16.setBounds(150, 100, 150, 50);
        button16.setVisible(false);
        button16.setText("Ator");
        button16.setFocusable(false);
        button16.setHorizontalTextPosition(JButton.LEFT);
        button16.setVerticalTextPosition(JButton.CENTER);
        button16.setFont(new Font("Ink Free", Font.BOLD, 20));
        button16.setBackground(new Color(0x99CCFF));
        button16.addActionListener(this);
        this.add(button16);

        button17 = new JButton();
        button17.setBounds(150, 170, 150, 50);
        button17.setVisible(false);
        button17.setText("Série");
        button17.setFocusable(false);
        button17.setHorizontalTextPosition(JButton.LEFT);
        button17.setVerticalTextPosition(JButton.CENTER);
        button17.setFont(new Font("Ink Free", Font.BOLD, 20));
        button17.setBackground(new Color(0x99CCFF));
        button17.addActionListener(this);
        this.add(button17);

        button18 = new JButton();
        button18.setBounds(150, 240, 150, 50);
        button18.setVisible(false);
        button18.setText("Episódio");
        button18.setFocusable(false);
        button18.setHorizontalTextPosition(JButton.LEFT);
        button18.setVerticalTextPosition(JButton.CENTER);
        button18.setFont(new Font("Ink Free", Font.BOLD, 20));
        button18.setBackground(new Color(0x99CCFF));
        button18.addActionListener(this);
        this.add(button18);

        button19 = new JButton();
        button19.setBounds(150, 310, 150, 50);
        button19.setVisible(false);
        button19.setText("Personagem");
        button19.setFocusable(false);
        button19.setHorizontalTextPosition(JButton.LEFT);
        button19.setVerticalTextPosition(JButton.CENTER);
        button19.setFont(new Font("Ink Free", Font.BOLD, 20));
        button19.setBackground(new Color(0x99CCFF));
        button19.addActionListener(this);
        this.add(button19);

        button21 = new JButton();
        button21.setBounds(150, 100, 150, 50);
        button21.setVisible(false);
        button21.setText("Ator");
        button21.setFocusable(false);
        button21.setHorizontalTextPosition(JButton.LEFT);
        button21.setVerticalTextPosition(JButton.CENTER);
        button21.setFont(new Font("Ink Free", Font.BOLD, 20));
        button21.setBackground(new Color(0x99CCFF));
        button21.addActionListener(this);
        this.add(button21);

        button22 = new JButton();
        button22.setBounds(150, 170, 150, 50);
        button22.setVisible(false);
        button22.setText("Série");
        button22.setFocusable(false);
        button22.setHorizontalTextPosition(JButton.LEFT);
        button22.setVerticalTextPosition(JButton.CENTER);
        button22.setFont(new Font("Ink Free", Font.BOLD, 20));
        button22.setBackground(new Color(0x99CCFF));
        button22.addActionListener(this);
        this.add(button22);

        button23 = new JButton();
        button23.setBounds(150, 240, 150, 50);
        button23.setVisible(false);
        button23.setText("Episódio");
        button23.setFocusable(false);
        button23.setHorizontalTextPosition(JButton.LEFT);
        button23.setVerticalTextPosition(JButton.CENTER);
        button23.setFont(new Font("Ink Free", Font.BOLD, 20));
        button23.setBackground(new Color(0x99CCFF));
        button23.addActionListener(this);
        this.add(button23);

        button24 = new JButton();
        button24.setBounds(150, 310, 150, 50);
        button24.setVisible(false);
        button24.setText("Personagem");
        button24.setFocusable(false);
        button24.setHorizontalTextPosition(JButton.LEFT);
        button24.setVerticalTextPosition(JButton.CENTER);
        button24.setFont(new Font("Ink Free", Font.BOLD, 20));
        button24.setBackground(new Color(0x99CCFF));
        button24.addActionListener(this);
        this.add(button24);


        button26 = new JButton();
        button26.setBounds(150, 100, 150, 50);
        button26.setVisible(false);
        button26.setText("Ator");
        button26.setFocusable(false);
        button26.setHorizontalTextPosition(JButton.LEFT);
        button26.setVerticalTextPosition(JButton.CENTER);
        button26.setFont(new Font("Ink Free", Font.BOLD, 20));
        button26.setBackground(new Color(0x99CCFF));
        button26.addActionListener(this);
        this.add(button26);

        button27 = new JButton();
        button27.setBounds(150, 170, 150, 50);
        button27.setVisible(false);
        button27.setText("Série");
        button27.setFocusable(false);
        button27.setHorizontalTextPosition(JButton.LEFT);
        button27.setVerticalTextPosition(JButton.CENTER);
        button27.setFont(new Font("Ink Free", Font.BOLD, 20));
        button27.setBackground(new Color(0x99CCFF));
        button27.addActionListener(this);
        this.add(button27);

        button28 = new JButton();
        button28.setBounds(150, 240, 150, 50);
        button28.setVisible(false);
        button28.setText("Episódio");
        button28.setFocusable(false);
        button28.setHorizontalTextPosition(JButton.LEFT);
        button28.setVerticalTextPosition(JButton.CENTER);
        button28.setFont(new Font("Ink Free", Font.BOLD, 20));
        button28.setBackground(new Color(0x99CCFF));
        button28.addActionListener(this);
        this.add(button28);

        button29 = new JButton();
        button29.setBounds(150, 310, 150, 50);
        button29.setVisible(false);
        button29.setText("Personagem");
        button29.setFocusable(false);
        button29.setHorizontalTextPosition(JButton.LEFT);
        button29.setVerticalTextPosition(JButton.CENTER);
        button29.setFont(new Font("Ink Free", Font.BOLD, 20));
        button29.setBackground(new Color(0x99CCFF));
        button29.addActionListener(this);
        this.add(button29);

        button30 = new JButton();
        button30.setBounds(150, 380, 150, 50);
        button30.setVisible(false);
        button30.setText("Performance");
        button30.setFocusable(false);
        button30.setHorizontalTextPosition(JButton.LEFT);
        button30.setVerticalTextPosition(JButton.CENTER);
        button30.setFont(new Font("Ink Free", Font.BOLD, 20));
        button30.setBackground(new Color(0x99CCFF));
        button30.addActionListener(this);
        this.add(button30);

        
        button31 = new JButton();
        button31.setBounds(200, 380, 150, 50);
        button31.setVisible(false);
        button31.setText("Update");
        button31.setFocusable(false);
        button31.setHorizontalTextPosition(JButton.LEFT);
        button31.setVerticalTextPosition(JButton.CENTER);
        button31.setFont(new Font("Ink Free", Font.BOLD, 20));
        button31.setBackground(new Color(0x99CCFF));
        button31.addActionListener(this);
        this.add(button31);

        button32 = new JButton();
        button32.setBounds(200, 380, 150, 50);
        button32.setVisible(false);
        button32.setText("Update");
        button32.setFocusable(false);
        button32.setHorizontalTextPosition(JButton.LEFT);
        button32.setVerticalTextPosition(JButton.CENTER);
        button32.setFont(new Font("Ink Free", Font.BOLD, 20));
        button32.setBackground(new Color(0x99CCFF));
        button32.addActionListener(this);
        this.add(button32);

        button33 = new JButton();
        button33.setBounds(200, 380, 150, 50);
        button33.setVisible(false);
        button33.setText("Update");
        button33.setFocusable(false);
        button33.setHorizontalTextPosition(JButton.LEFT);
        button33.setVerticalTextPosition(JButton.CENTER);
        button33.setFont(new Font("Ink Free", Font.BOLD, 20));
        button33.setBackground(new Color(0x99CCFF));
        button33.addActionListener(this);
        this.add(button33);

        button34 = new JButton();
        button34.setBounds(200, 380, 150, 50);
        button34.setVisible(false);
        button34.setText("Update");
        button34.setFocusable(false);
        button34.setHorizontalTextPosition(JButton.LEFT);
        button34.setVerticalTextPosition(JButton.CENTER);
        button34.setFont(new Font("Ink Free", Font.BOLD, 20));
        button34.setBackground(new Color(0x99CCFF));
        button34.addActionListener(this);
        this.add(button34);

        button36 = new JButton();
        button36.setBounds(200, 380, 150, 50);
        button36.setVisible(false);
        button36.setText("Delete");
        button36.setFocusable(false);
        button36.setHorizontalTextPosition(JButton.LEFT);
        button36.setVerticalTextPosition(JButton.CENTER);
        button36.setFont(new Font("Ink Free", Font.BOLD, 20));
        button36.setBackground(new Color(0x99CCFF));
        button36.addActionListener(this);
        this.add(button36);

        button37 = new JButton();
        button37.setBounds(200, 380, 150, 50);
        button37.setVisible(false);
        button37.setText("Delete");
        button37.setFocusable(false);
        button37.setHorizontalTextPosition(JButton.LEFT);
        button37.setVerticalTextPosition(JButton.CENTER);
        button37.setFont(new Font("Ink Free", Font.BOLD, 20));
        button37.setBackground(new Color(0x99CCFF));
        button37.addActionListener(this);
        this.add(button37);

        button38 = new JButton();
        button38.setBounds(200, 380, 150, 50);
        button38.setVisible(false);
        button38.setText("Delete");
        button38.setFocusable(false);
        button38.setHorizontalTextPosition(JButton.LEFT);
        button38.setVerticalTextPosition(JButton.CENTER);
        button38.setFont(new Font("Ink Free", Font.BOLD, 20));
        button38.setBackground(new Color(0x99CCFF));
        button38.addActionListener(this);
        this.add(button38);

        button39 = new JButton();
        button39.setBounds(200, 380, 150, 50);
        button39.setVisible(false);
        button39.setText("Delete");
        button39.setFocusable(false);
        button39.setHorizontalTextPosition(JButton.LEFT);
        button39.setVerticalTextPosition(JButton.CENTER);
        button39.setFont(new Font("Ink Free", Font.BOLD, 20));
        button39.setBackground(new Color(0x99CCFF));
        button39.addActionListener(this);
        this.add(button39);

        button40 = new JButton();
        button40.setBounds(200, 380, 150, 50);
        button40.setVisible(false);
        button40.setText("Delete");
        button40.setFocusable(false);
        button40.setHorizontalTextPosition(JButton.LEFT);
        button40.setVerticalTextPosition(JButton.CENTER);
        button40.setFont(new Font("Ink Free", Font.BOLD, 20));
        button40.setBackground(new Color(0x99CCFF));
        button40.addActionListener(this);
        this.add(button40);

        button41 = new JButton();
        button41.setBounds(380, 100, 80, 20);
        button41.setVisible(false);
        button41.setText("Buscar");
        button41.setFocusable(false);
        button41.setHorizontalTextPosition(JButton.LEFT);
        button41.setVerticalTextPosition(JButton.CENTER);
        button41.setFont(new Font("Ink Free", Font.BOLD, 12));
        button41.setBackground(new Color(0x99CCFF));
        button41.addActionListener(this);
        this.add(button41);

        button42 = new JButton();
        button42.setBounds(380, 100, 80, 20);
        button42.setVisible(false);
        button42.setText("Buscar");
        button42.setFocusable(false);
        button42.setHorizontalTextPosition(JButton.LEFT);
        button42.setVerticalTextPosition(JButton.CENTER);
        button42.setFont(new Font("Ink Free", Font.BOLD, 12));
        button42.setBackground(new Color(0x99CCFF));
        button42.addActionListener(this);
        this.add(button42);

        button43 = new JButton();
        button43.setBounds(380, 100, 80, 20);
        button43.setVisible(false);
        button43.setText("Buscar");
        button43.setFocusable(false);
        button43.setHorizontalTextPosition(JButton.LEFT);
        button43.setVerticalTextPosition(JButton.CENTER);
        button43.setFont(new Font("Ink Free", Font.BOLD, 12));
        button43.setBackground(new Color(0x99CCFF));
        button43.addActionListener(this);
        this.add(button43);

        button44 = new JButton();
        button44.setBounds(380, 100, 80, 20);
        button44.setVisible(false);
        button44.setText("Buscar");
        button44.setFocusable(false);
        button44.setHorizontalTextPosition(JButton.LEFT);
        button44.setVerticalTextPosition(JButton.CENTER);
        button44.setFont(new Font("Ink Free", Font.BOLD, 12));
        button44.setBackground(new Color(0x99CCFF));
        button44.addActionListener(this);
        this.add(button44);

        sp = new JScrollPane(areaRelatorio);
        sp.setVisible(false);
        sp.setBounds(280, 100,400, 400);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(sp);

        list = new JComboBox<String>(categorias);
        list.setSelectedItem(7);
        list.setEditable(false);
        list.setVisible(false);
        list.setBounds(200, 250, 150, 20);
        this.add(list);

        check = new JList<String>(categorias);
        check.setVisible(false);
        check.setBounds(200, 250, 150, 20);
        check.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if(super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                }
                else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
        this.add(check);
        
        spc = new JScrollPane(check);
        spc.setVisible(false);
        spc.setBounds(200, 250,150, 100);
        spc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(spc);

        //Labels para indicar status do CRUD
        cadAtor = new JLabel();
        cadAtor.setBounds(200, 420, 150, 50);
        cadAtor.setFont(new Font("Ink Free", Font.BOLD, 10));
        cadAtor.setVisible(false);
        this.add(cadAtor);

        cadSerie = new JLabel();
        cadSerie.setBounds(200, 420, 150, 50);
        cadSerie.setFont(new Font("Ink Free", Font.BOLD, 10));
        cadSerie.setVisible(false);
        this.add(cadSerie);

        cadEp = new JLabel();
        cadEp.setBounds(200, 420, 150, 50);
        cadEp.setFont(new Font("Ink Free", Font.BOLD, 10));
        cadEp.setVisible(false);
        this.add(cadEp);

        cadPerso = new JLabel();
        cadPerso.setBounds(200, 420, 150, 50);
        cadPerso.setFont(new Font("Ink Free", Font.BOLD, 10));
        cadPerso.setVisible(false);
        this.add(cadPerso);

        cadPerf = new JLabel();
        cadPerf.setBounds(200, 420, 150, 50);
        cadPerf.setFont(new Font("Ink Free", Font.BOLD, 10));
        cadPerf.setVisible(false);
        this.add(cadPerf);

        uptAtor = new JLabel();
        uptAtor.setBounds(200, 420, 150, 50);
        uptAtor.setFont(new Font("Ink Free", Font.BOLD, 10));
        uptAtor.setVisible(false);
        this.add(uptAtor);

        uptSerie = new JLabel();
        uptSerie.setBounds(200, 420, 150, 50);
        uptSerie.setFont(new Font("Ink Free", Font.BOLD, 10));
        uptSerie.setVisible(false);
        this.add(uptSerie);

        uptEp = new JLabel();
        uptEp.setBounds(200, 420, 150, 50);
        uptEp.setFont(new Font("Ink Free", Font.BOLD, 10));
        uptEp.setVisible(false);
        this.add(uptEp);

        uptPerso = new JLabel();
        uptPerso.setBounds(200, 420, 150, 50);
        uptPerso.setFont(new Font("Ink Free", Font.BOLD, 10));
        uptPerso.setVisible(false);
        this.add(uptPerso);

        delAtor = new JLabel();
        delAtor.setBounds(200, 420, 150, 50);
        delAtor.setFont(new Font("Ink Free", Font.BOLD, 10));
        delAtor.setVisible(false);
        this.add(delAtor);

        delSerie = new JLabel();
        delSerie.setBounds(200, 420, 150, 50);
        delSerie.setFont(new Font("Ink Free", Font.BOLD, 10));
        delSerie.setVisible(false);
        this.add(delSerie);

        delEp = new JLabel();
        delEp.setBounds(200, 420, 150, 50);
        delEp.setFont(new Font("Ink Free", Font.BOLD, 10));
        delEp.setVisible(false);
        this.add(delEp);

        delPerso = new JLabel();
        delPerso.setBounds(200, 420, 150, 50);
        delPerso.setFont(new Font("Ink Free", Font.BOLD, 10));
        delPerso.setVisible(false);
        this.add(delPerso);


        //Adicionando todo o Design no frame
        this.setTitle("Pooflix");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setBounds(300, 90, 900, 600);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0xCCFFFF));
    }


    //Função para fazer os botões funcionarem de maneira desejavel
    @Override
    public void actionPerformed(ActionEvent e) {
        

        if(e.getSource()==button){

            button.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button5.setVisible(true);
            button6.setVisible(true);
            button7.setVisible(true);
            button8.setVisible(true);
            button9.setVisible(true);
            button15.setVisible(true);

        } 


        if(e.getSource() == button2){

            
            button.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button15.setVisible(true);
            button16.setVisible(true);
            button17.setVisible(true);
            button18.setVisible(true);
            button19.setVisible(true);

        }

       
        if(e.getSource() == button3){
        
            button.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button15.setVisible(true);
            button21.setVisible(true);
            button22.setVisible(true);
            button23.setVisible(true);
            button24.setVisible(true);

        }

        if(e.getSource() == button4){
        
            button.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button15.setVisible(true);
            button26.setVisible(true);
            button27.setVisible(true);
            button28.setVisible(true);
            button29.setVisible(true);
            button30.setVisible(true);

        }


        if(e.getSource() == button5){
            TelaCadastro.idAtor.setVisible(true);
            TelaCadastro.nomeAtor.setVisible(true);
            TelaCadastro.nacionalidadeAtor.setVisible(true);
    
            TelaCadastro.textId.setVisible(true);
            TelaCadastro.textNome.setVisible(true);
            TelaCadastro.textNacionalidade.setVisible(true);

            button.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button5.setVisible(false);
            button6.setVisible(false);
            button7.setVisible(false);
            button8.setVisible(false);
            button9.setVisible(false);
            button10.setVisible(true);
            button15.setVisible(true);
        }

        if(e.getSource() == button6){
            TelaCadastro.idSerie.setVisible(true);
            TelaCadastro.tituloSerie.setVisible(true);
            TelaCadastro.idadeSerie.setVisible(true);

            TelaCadastro.textIdSerie.setVisible(true);
            TelaCadastro.textTituloSerie.setVisible(true);
            TelaCadastro.textIdadeSerie.setVisible(true);

            check.setVisible(true);
            spc.setVisible(true);
            label.setVisible(true);

            button.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button5.setVisible(false);
            button6.setVisible(false);
            button7.setVisible(false);
            button8.setVisible(false);
            button9.setVisible(false);
            button11.setVisible(true);
            button15.setVisible(true);

        }

        if(e.getSource() == button7){

            TelaCadastro.idEpSerie.setVisible(true);
            TelaCadastro.idEp.setVisible(true);
            TelaCadastro.temporadaEp.setVisible(true);
            TelaCadastro.tituloEp.setVisible(true);
            TelaCadastro.resumoEp.setVisible(true);

            TelaCadastro.textIdSerieEp.setVisible(true);
            TelaCadastro.textIdEp.setVisible(true);
            TelaCadastro.textTempEp.setVisible(true);
            TelaCadastro.textTituloEp.setVisible(true);
            TelaCadastro.textResumoEp.setVisible(true);

            button.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button5.setVisible(false);
            button6.setVisible(false);
            button7.setVisible(false);
            button8.setVisible(false);
            button9.setVisible(false);
            button12.setVisible(true);
            button15.setVisible(true);

        }

        if(e.getSource() == button8){
            TelaCadastro.idPersonagem.setVisible(true);
            TelaCadastro.nomePersonagem.setVisible(true);

            TelaCadastro.textIdPersonagem.setVisible(true);
            TelaCadastro.textNomePersonagem.setVisible(true);

            button.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button5.setVisible(false);
            button6.setVisible(false);
            button7.setVisible(false);
            button8.setVisible(false);
            button9.setVisible(false);
            button13.setVisible(true);
            button15.setVisible(true);


        }
    
        if(e.getSource() == button9){
            TelaCadastro.idPerfEp.setVisible(true);
            TelaCadastro.idPerfPer.setVisible(true);
            TelaCadastro.idPerfAtor.setVisible(true);

            TelaCadastro.textPerfEp.setVisible(true);
            TelaCadastro.textPerfPer.setVisible(true);
            TelaCadastro.textPerfAtor.setVisible(true);

            button.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button5.setVisible(false);
            button6.setVisible(false);
            button7.setVisible(false);
            button8.setVisible(false);
            button9.setVisible(false);
            button14.setVisible(true);
            button15.setVisible(true);

        }

        //Adiciona no banco de dados

        if(e.getSource() == button10){

            try{
                ator = new Ator(TelaCadastro.textId.getText(), TelaCadastro.textNome.getText(), TelaCadastro.textNacionalidade.getText());
                System.out.println(ator.getid());
                System.out.println(ator.getnome());
                System.out.println(ator.getnacionalidade());
                DAOAtor dao = new DAOAtor(con);
                dao.create(ator);
                cadAtor.setText("Ator registrado com sucesso!");
                cadAtor.setVisible(true);
                TelaCadastro.textId.setText("");
                TelaCadastro.textNome.setText("");
                TelaCadastro.textNacionalidade.setText("");

            }catch(NullPointerException f){
                System.out.println(f);
                cadAtor.setText("Ator não foi registrado...");
                cadAtor.setVisible(true);


            }
   

        }


        if(e.getSource() == button11){

            try{
                serie = new Serie(TelaCadastro.textIdSerie.getText(), TelaCadastro.textTituloSerie.getText(), Integer.parseInt(TelaCadastro.textIdadeSerie.getText()));
                
                
                
                LinkedList<Categoria> categorias = new LinkedList<Categoria>();

                if(check.isSelectionEmpty() == true){
                    System.out.println("ENTROU NO IF");
                    Categoria categoria = new Categoria(cat.get("Ação"), null);
                    categorias.add(categoria);
                }else{
                    for(String categ: check.getSelectedValuesList()){
                        Categoria categoria = new Categoria(cat.get(categ), null);
                        categorias.add(categoria);
                    }

                    cadSerie.setText("Série registrada com sucesso!");
                    cadSerie.setVisible(true);
                    TelaCadastro.textIdSerie.setText("");
                    TelaCadastro.textTituloSerie.setText("");
                    TelaCadastro.textIdadeSerie.setText("");
    

                }


                serie.setCategorias(categorias);

                System.out.println(serie.getid());
                System.out.println(serie.gettitulo());
                System.out.println(serie.getClassEtaria());
                System.out.println(check.getSelectedValuesList());


                DAOSerie dao = new DAOSerie(con);
                dao.create(serie);
                DAOCategoria daoCategoria = new DAOCategoria(con);
                daoCategoria.create(serie);
            }catch(NullPointerException f){
                System.out.println(f);
                cadSerie.setText("Série não foi registrada...");
                cadSerie.setVisible(true);

            }
   

        }

        if(e.getSource() == button12){
            try{
                ep = new Episodio(TelaCadastro.textIdEp.getText(), TelaCadastro.textTituloEp.getText(), TelaCadastro.textTempEp.getText(), TelaCadastro.textResumoEp.getText(), TelaCadastro.textIdSerieEp.getText());

                System.out.println(ep.getid());
                System.out.println(ep.gettitulo());
                System.out.println(ep.gettemporada());
                System.out.println(ep.getresumo());
                System.out.println(ep.getidserie()); 

                DAOEpisodio dao = new DAOEpisodio(con);
                dao.create(ep);
                cadEp.setText("Episódio registrado com sucesso!");
                cadEp.setVisible(true);

                TelaCadastro.textIdSerieEp.setText("");
                TelaCadastro.textIdEp.setText("");
                TelaCadastro.textTempEp.setText("");
                TelaCadastro.textTituloEp.setText("");
                TelaCadastro.textResumoEp.setText("");


            }catch(NullPointerException f){ 
                System.out.println(f);
                cadEp.setText("Episódio não foi registrado...");
                cadEp.setVisible(true);
            }
        }

        if(e.getSource() == button13){

            try{
                
                personagem = new Personagem(TelaCadastro.textIdPersonagem.getText(), TelaCadastro.textNomePersonagem.getText());
                System.out.println(personagem.getid());
                System.out.println(personagem.getnome());
                DAOPersonagem dao = new DAOPersonagem(con);
                dao.create(personagem);

                cadPerso.setText("Personagem registrado com sucesso!");
                cadPerso.setVisible(true);

                TelaCadastro.textIdPersonagem.setText("");
                TelaCadastro.textNomePersonagem.setText("");
                
            }catch(NullPointerException f){
                System.out.println(f);
                cadPerso.setText("Personagem não foi registrado...");
                cadPerso.setVisible(true);

            }
        }

        if(e.getSource() == button14){

            try{
                perf = new Performance(TelaCadastro.textPerfEp.getText(), TelaCadastro.textPerfPer.getText(), TelaCadastro.textPerfAtor.getText());
                System.out.print(perf.getidep());
                System.out.print(perf.getidperson());
                System.out.print(perf.getidator());
                DAOPerformance dao = new DAOPerformance(con);
                dao.create(perf);

                cadPerf.setText("Performance registrada com sucesso!");
                cadPerf.setVisible(true);

                TelaCadastro.textPerfAtor.setText("");
                TelaCadastro.textPerfEp.setText("");
                TelaCadastro.textPerfPer.setText("");
                
            }catch(NullPointerException f){
                System.out.println(f);
                cadPerf.setText("Performance não foi registrada...");
                cadPerf.setVisible(true);
            }
   
        }


        if(e.getSource() == button15){

            TelaCadastro.idAtor.setVisible(false);
            TelaCadastro.nomeAtor.setVisible(false);
            TelaCadastro.nacionalidadeAtor.setVisible(false);
            TelaCadastro.textId.setVisible(false);
            TelaCadastro.textNome.setVisible(false);
            TelaCadastro.textNacionalidade.setVisible(false);

            TelaCadastro.textId.setText("");
            TelaCadastro.textNome.setText("");
            TelaCadastro.textNacionalidade.setText("");

            TelaCadastro.idSerie.setVisible(false);
            TelaCadastro.tituloSerie.setVisible(false);
            TelaCadastro.idadeSerie.setVisible(false);
            TelaCadastro.textIdSerie.setVisible(false);
            TelaCadastro.textTituloSerie.setVisible(false);
            TelaCadastro.textIdadeSerie.setVisible(false);

            TelaCadastro.textIdSerie.setText("");
            TelaCadastro.textTituloSerie.setText("");
            TelaCadastro.textIdadeSerie.setText("");

            TelaCadastro.idEpSerie.setVisible(false);
            TelaCadastro.idEp.setVisible(false);
            TelaCadastro.temporadaEp.setVisible(false);
            TelaCadastro.tituloEp.setVisible(false);
            TelaCadastro.resumoEp.setVisible(false);
            TelaCadastro.textIdSerieEp.setVisible(false);
            TelaCadastro.textIdEp.setVisible(false);
            TelaCadastro.textTempEp.setVisible(false);
            TelaCadastro.textTituloEp.setVisible(false);
            TelaCadastro.textResumoEp.setVisible(false);

            TelaCadastro.textIdSerieEp.setText("");
            TelaCadastro.textIdEp.setText("");
            TelaCadastro.textTempEp.setText("");
            TelaCadastro.textTituloEp.setText("");
            TelaCadastro.textResumoEp.setText("");

            TelaCadastro.idPersonagem.setVisible(false);
            TelaCadastro.nomePersonagem.setVisible(false);
            TelaCadastro.textIdPersonagem.setVisible(false);
            TelaCadastro.textNomePersonagem.setVisible(false);

            TelaCadastro.textIdPersonagem.setText("");
            TelaCadastro.textNomePersonagem.setText("");

            TelaCadastro.idPerfEp.setVisible(false);
            TelaCadastro.idPerfPer.setVisible(false);
            TelaCadastro.idPerfAtor.setVisible(false);
            TelaCadastro.textPerfEp.setVisible(false);
            TelaCadastro.textPerfPer.setVisible(false);
            TelaCadastro.textPerfAtor.setVisible(false);

            TelaCadastro.textPerfEp.setText("");
            TelaCadastro.textPerfPer.setText("");
            TelaCadastro.textPerfAtor.setText("");


            TelaUpdate.idAtor.setVisible(false);
            TelaUpdate.nomeAtor.setVisible(false);
            TelaUpdate.nacionalidadeAtor.setVisible(false);
            TelaUpdate.textId.setVisible(false);
            TelaUpdate.textNome.setVisible(false);
            TelaUpdate.textNacionalidade.setVisible(false);

            TelaUpdate.textId.setText("");
            TelaUpdate.textNome.setText("");
            TelaUpdate.textNacionalidade.setText("");

            TelaUpdate.idSerie.setVisible(false);
            TelaUpdate.tituloSerie.setVisible(false);
            TelaUpdate.idadeSerie.setVisible(false);
            TelaUpdate.textIdSerie.setVisible(false);
            TelaUpdate.textTituloSerie.setVisible(false);
            TelaUpdate.textIdadeSerie.setVisible(false);

            TelaUpdate.textIdSerie.setText("");
            TelaUpdate.textTituloSerie.setText("");
            TelaUpdate.textIdadeSerie.setText("");

            TelaUpdate.idEp.setVisible(false);
            TelaUpdate.temporadaEp.setVisible(false);
            TelaUpdate.tituloEp.setVisible(false);
            TelaUpdate.resumoEp.setVisible(false);
            TelaUpdate.textIdEp.setVisible(false);
            TelaUpdate.textTempEp.setVisible(false);
            TelaUpdate.textTituloEp.setVisible(false);
            TelaUpdate.textResumoEp.setVisible(false);

            TelaUpdate.textIdEp.setText("");
            TelaUpdate.textTempEp.setText("");
            TelaUpdate.textTituloEp.setText("");
            TelaUpdate.textResumoEp.setText("");

            TelaUpdate.idPersonagem.setVisible(false);
            TelaUpdate.nomePersonagem.setVisible(false);
            TelaUpdate.textIdPersonagem.setVisible(false);
            TelaUpdate.textNomePersonagem.setVisible(false);

            TelaUpdate.textIdPersonagem.setText("");
            TelaUpdate.textNomePersonagem.setText("");

            //Delete
            TelaDelete.idAtor.setVisible(false);
            TelaDelete.textId.setVisible(false);

            TelaDelete.idSerie.setVisible(false);
            TelaDelete.textIdSerie.setVisible(false);

            TelaDelete.idEp.setVisible(false);
            TelaDelete.textIdEp.setVisible(false);

            TelaDelete.idPersonagem.setVisible(false);
            TelaDelete.textIdPersonagem.setVisible(false);

            button.setVisible(true);
            button2.setVisible(true);
            button3.setVisible(true);
            button4.setVisible(true);
            button5.setVisible(false);
            button6.setVisible(false);
            button7.setVisible(false);
            button8.setVisible(false);
            button9.setVisible(false);
            button10.setVisible(false);
            button11.setVisible(false);
            button12.setVisible(false);
            button13.setVisible(false);
            button14.setVisible(false);
            button16.setVisible(false);
            button17.setVisible(false);
            button18.setVisible(false);
            button19.setVisible(false);
            button21.setVisible(false);
            button22.setVisible(false);
            button23.setVisible(false);
            button24.setVisible(false);
            button26.setVisible(false);
            button27.setVisible(false);
            button28.setVisible(false);
            button29.setVisible(false);
            button30.setVisible(false);
            button31.setVisible(false);
            button32.setVisible(false);
            button33.setVisible(false);
            button34.setVisible(false);
            button36.setVisible(false);
            button37.setVisible(false);
            button38.setVisible(false);
            button39.setVisible(false);
            button40.setVisible(false);
            button41.setVisible(false);
            button42.setVisible(false);
            button43.setVisible(false);
            button44.setVisible(false);
            area.setVisible(false);
            areaRelatorio.setVisible(false);
            sp.setVisible(false);
            list.setVisible(false);
            label.setVisible(false);
            check.setVisible(false);
            spc.setVisible(false);
            cadAtor.setVisible(false);
            cadSerie.setVisible(false);
            cadEp.setVisible(false);
            cadPerso.setVisible(false);
            cadPerf.setVisible(false);
            uptAtor.setVisible(false);
            uptSerie.setVisible(false);
            uptEp.setVisible(false);
            uptPerso.setVisible(false);
            delAtor.setVisible(false);
            delSerie.setVisible(false);
            delEp.setVisible(false);
            delPerso.setVisible(false);
            area.setText("");


        }

        if(e.getSource() == button16){

            TelaUpdate.idAtor.setVisible(true);
            TelaUpdate.nomeAtor.setVisible(true);
            TelaUpdate.nacionalidadeAtor.setVisible(true);
    
            TelaUpdate.textId.setVisible(true);
            TelaUpdate.textNome.setVisible(true);
            TelaUpdate.textNacionalidade.setVisible(true);

            area.setVisible(true);
            button16.setVisible(false);
            button17.setVisible(false);
            button18.setVisible(false);
            button19.setVisible(false);
            button31.setVisible(true);
            button41.setVisible(true);

        }

        if(e.getSource() == button17){

            TelaUpdate.idSerie.setVisible(true);
            TelaUpdate.tituloSerie.setVisible(true);
            TelaUpdate.idadeSerie.setVisible(true);

            TelaUpdate.textIdSerie.setVisible(true);
            TelaUpdate.textTituloSerie.setVisible(true);
            TelaUpdate.textIdadeSerie.setVisible(true);

            area.setVisible(true);
            button16.setVisible(false);
            button17.setVisible(false);
            button18.setVisible(false);
            button19.setVisible(false);
            button32.setVisible(true);
            button42.setVisible(true);

        }

        if(e.getSource() == button18){

            TelaUpdate.idEp.setVisible(true);
            TelaUpdate.temporadaEp.setVisible(true);
            TelaUpdate.tituloEp.setVisible(true);
            TelaUpdate.resumoEp.setVisible(true);

            TelaUpdate.textIdEp.setVisible(true);
            TelaUpdate.textTempEp.setVisible(true);
            TelaUpdate.textTituloEp.setVisible(true);
            TelaUpdate.textResumoEp.setVisible(true);
            
            area.setVisible(true);
            button16.setVisible(false);
            button17.setVisible(false);
            button18.setVisible(false);
            button19.setVisible(false);
            button33.setVisible(true);
            button43.setVisible(true);
        }

        if(e.getSource() == button19){

            TelaUpdate.idPersonagem.setVisible(true);
            TelaUpdate.nomePersonagem.setVisible(true);

            TelaUpdate.textIdPersonagem.setVisible(true);
            TelaUpdate.textNomePersonagem.setVisible(true);

            area.setVisible(true);
            button16.setVisible(false);
            button17.setVisible(false);
            button18.setVisible(false);
            button19.setVisible(false);
            button34.setVisible(true);
            button44.setVisible(true);

        }
        
        if(e.getSource() == button21){

            TelaDelete.idAtor.setVisible(true);
            TelaDelete.textId.setVisible(true);
        
            button21.setVisible(false);
            button22.setVisible(false);
            button23.setVisible(false);
            button24.setVisible(false);
            button36.setVisible(true);

        }

        
        if(e.getSource() == button22){

            TelaDelete.idSerie.setVisible(true);
            TelaDelete.textIdSerie.setVisible(true);

            button21.setVisible(false);
            button22.setVisible(false);
            button23.setVisible(false);
            button24.setVisible(false);
            button37.setVisible(true);

        }
        
        if(e.getSource() == button23){

            TelaDelete.idEp.setVisible(true);
            TelaDelete.textIdEp.setVisible(true);
    
            button21.setVisible(false);
            button22.setVisible(false);
            button23.setVisible(false);
            button24.setVisible(false);
            button38.setVisible(true);

        }

        
        if(e.getSource() == button24){

            TelaDelete.idPersonagem.setVisible(true);
            TelaDelete.textIdPersonagem.setVisible(true);
            
            button21.setVisible(false);
            button22.setVisible(false);
            button23.setVisible(false);
            button24.setVisible(false);
            button39.setVisible(true);

        }

        
        if(e.getSource() == button26){
            DAOAtor dao = new DAOAtor(con);
            areaRelatorio.setVisible(true);

            areaRelatorio.setText(String.valueOf(dao.read()));
            sp.setVisible(true);
            button26.setVisible(false);
            button27.setVisible(false);
            button28.setVisible(false);
            button29.setVisible(false);
            button30.setVisible(false);
        }

        
        if(e.getSource() == button27){
            DAOSerie dao = new DAOSerie(con);
            areaRelatorio.setVisible(true);

            areaRelatorio.setText(String.valueOf(dao.read()));
            sp.setVisible(true);
            button26.setVisible(false);
            button27.setVisible(false);
            button28.setVisible(false);
            button29.setVisible(false);
            button30.setVisible(false);
        }

        
        if(e.getSource() == button28){
            DAOEpisodio dao = new DAOEpisodio(con);
            areaRelatorio.setVisible(true);

            areaRelatorio.setText(String.valueOf(dao.read()));

            areaRelatorio.setVisible(true);
            sp.setVisible(true);
            button26.setVisible(false);
            button27.setVisible(false);
            button28.setVisible(false);
            button29.setVisible(false);
            button30.setVisible(false);
        }

        
        if(e.getSource() == button29){
            DAOPersonagem dao = new DAOPersonagem(con);
            areaRelatorio.setVisible(true);

            areaRelatorio.setText(String.valueOf(dao.read()));

            areaRelatorio.setVisible(true);
            sp.setVisible(true);
            button26.setVisible(false);
            button27.setVisible(false);
            button28.setVisible(false);
            button29.setVisible(false);
            button30.setVisible(false);
        }

        
        if(e.getSource() == button30){
            DAOPerformance dao = new DAOPerformance(con);
            areaRelatorio.setVisible(true);

            areaRelatorio.setText(String.valueOf(dao.read()));

            areaRelatorio.setVisible(true);
            sp.setVisible(true);
            button26.setVisible(false);
            button27.setVisible(false);
            button28.setVisible(false);
            button29.setVisible(false);
            button30.setVisible(false);
        }

        if(e.getSource() == button31){
            try{
                DAOAtor dao = new DAOAtor(con);

                ator = new Ator(TelaUpdate.textId.getText(), TelaUpdate.textNome.getText(), TelaUpdate.textNacionalidade.getText());
                dao.update(ator);
                uptAtor.setText("Ator atualiado com sucesso!");
                uptAtor.setVisible(true);

                System.out.println(TelaUpdate.textId.getText());
                System.out.println(TelaUpdate.textNome.getText());
                System.out.println(TelaUpdate.textNacionalidade.getText());

            }catch(Exception f){
                uptAtor.setText("Ator não foi atualiado...");
                uptAtor.setVisible(true);
            }
            
        }

        if(e.getSource() == button32){
            try{
                DAOSerie dao = new DAOSerie(con);
    
                serie = new Serie(TelaUpdate.textIdSerie.getText(), TelaUpdate.textTituloSerie.getText(), Integer.parseInt(TelaUpdate.textIdadeSerie.getText()));
                dao.update(serie);

                uptSerie.setText("Série atualiada com sucesso!");
                uptSerie.setVisible(true);

            }catch(Exception f){
                uptSerie.setText("Série não foi atualiada...");
                uptSerie.setVisible(true);
            }

        }

        if(e.getSource() == button33){
            try{
                DAOEpisodio dao = new DAOEpisodio(con);
    
                ep = new Episodio(TelaUpdate.textIdEp.getText(), TelaUpdate.textTituloEp.getText(), TelaUpdate.textTempEp.getText(), TelaUpdate.textResumoEp.getText(), TelaUpdate.textIdSerieEp.getText());
                dao.update(ep);
                uptEp.setText("Episódio atualiada com sucesso!");
                uptEp.setVisible(true);

            }catch(Exception f){
                uptEp.setText("Episódio não foi atualiada...");
                uptEp.setVisible(true);
            }

        }

        if(e.getSource() == button34){
            try{
                DAOPersonagem dao = new DAOPersonagem(con);
    
                personagem = new Personagem(TelaUpdate.textIdPersonagem.getText(), TelaUpdate.textNomePersonagem.getText());
                dao.update(personagem);
                uptPerso.setText("Personagem foi atualiado com sucesso!");
                uptPerso.setVisible(true);

            }catch(Exception f){
                uptPerso.setText("Personagem não foi atualiado...");
                uptPerso.setVisible(true);
            }
        }

        if(e.getSource() == button36){
            try{
                DAOAtor dao =  new DAOAtor(con);
    
                dao.delete(TelaDelete.textId.getText());

                delAtor.setText("Ator foi deletado com sucesso!");
                delAtor.setVisible(true);

            }catch(Exception f){
                delAtor.setText("Ator não foi deletado...");
                delAtor.setVisible(true);
            }

        }

        if(e.getSource() == button37){
            try{
                DAOSerie dao =  new DAOSerie(con);
    
                dao.delete(TelaDelete.textIdSerie.getText());

                delSerie.setText("Série foi deletada com sucesso!");
                delSerie.setVisible(true);

            }catch(Exception f){
                delSerie.setText("Série não foi deletada...");
                delSerie.setVisible(true);
            }

        }

        if(e.getSource() == button38){
            try{
                DAOEpisodio dao =  new DAOEpisodio(con);
    
                dao.delete(TelaDelete.textIdEp.getText());

                delEp.setText("Episódio foi deletado com sucesso!");
                delEp.setVisible(true);

            }catch(Exception f){
                delEp.setText("Episódio não foi deletado...");
                delEp.setVisible(true);
            }

        }

        if(e.getSource() == button39){
            try{
                DAOPersonagem dao =  new DAOPersonagem(con);
                DAOPerformance daoPer = new DAOPerformance(con);
                
                daoPer.delete(TelaDelete.textIdPersonagem.getText());
                dao.delete(TelaDelete.textIdPersonagem.getText());
                

                delPerso.setText("Personagem foi deletado com sucesso!");
                delPerso.setVisible(true);

            }catch(Exception f){
                delPerso.setText("Personagem não foi deletado...");
                delPerso.setVisible(true);
            }

        }

        if(e.getSource() == button41){
            DAOAtor dao = new DAOAtor(con);

            if(dao.getAtorByID(TelaUpdate.textId.getText()) == null) {
                area.setText("Id não cadastrado no banco");
            } 


            System.out.println("id: " + TelaUpdate.textId.getText());
            String sql = String.format("SELECT * FROM ator where idator = %s", TelaUpdate.textId.getText());
            

            try (
                Statement st = con.createStatement()) {
                ResultSet rs = st.executeQuery(sql);
                


                while(rs.next()){
                    area.setText("Id: " + rs.getString("idator") + "\n" + "Nome: " + rs.getString("nomeator")+"\n" + "Nacionalidade: " + rs.getString("nacionalidade") + "\n");
                }
                

            } catch (SQLException e1) {
                System.out.println("Problemas em DAOAtor.create" + e1.getMessage());
            }
            

        }

        if(e.getSource() == button42){
            //clicando nesse botão, então busca pelo id no banco de dados e printa na tela as informações referentes ao id
            DAOSerie dao = new DAOSerie(con);

            if(dao.getSerieByID(TelaUpdate.textIdSerie.getText()) == null) {
                area.setText("Id não cadastrado no banco");
                
            }else{
                System.out.println("id: " + TelaUpdate.textIdSerie.getText());
                String sql = String.format("SELECT * FROM serie INNER JOIN categserie ON (serie.idserie = "+ TelaUpdate.textIdSerie.getText() +" and categserie.fk_idserie = "+ TelaUpdate.textIdSerie.getText() +") INNER JOIN categoria ON (categoria.idcategoria = categserie.fk_idcategoria)");
                
                try (
                    Statement st = con.createStatement()) {
                    ResultSet rs = st.executeQuery(sql);
                    
                    while(rs.next()){
                        area.setText("Id série: " + rs.getString("idserie") + "\n" + "Título série: " + 
                        rs.getString("tituloserie") + "\n" + "Classe etária: " + 
                        Integer.parseInt(rs.getString("idade")) + "\n" + "Categoria: " + rs.getString("tipo") + "\n");
                    }

                } catch (SQLException e1) {
                    System.out.println("Problemas em DAOAtor.create" + e1.getMessage());
                }
                
            }

        }

        if(e.getSource() == button43){
            //clicando nesse botão, então busca pelo id no banco de dados e printa na tela as informações referentes ao id
            DAOEpisodio dao = new DAOEpisodio(con);

            if(dao.getEpisodioByID(TelaUpdate.textIdEp.getText()) == null) {
                area.setText("Id não cadastrado no banco");
            } 


            System.out.println("id: " + TelaUpdate.textIdEp.getText());
            String sql = String.format("SELECT * FROM episodio where idepisodio = %s", TelaUpdate.textIdEp.getText());

            

            try (
                Statement st = con.createStatement()) {
                ResultSet rs = st.executeQuery(sql);
                


                while(rs.next()){
                    area.setText("Id: " + rs.getString("idepisodio") + "\n\n" + "Título: " + rs.getString("tituloepisodio")+"\n\n" + "Temporada: " + rs.getString("temporada") + "\n\n" + "Resumo: " + rs.getString("resumo") + "\n\n");
                }
                

            } catch (SQLException e1) {
                System.out.println("Problemas em DAOAtor.create" + e1.getMessage());
            }

            

        }

        if(e.getSource() == button44){
            //clicando nesse botão, então busca pelo id no banco de dados e printa na tela as informações referentes ao id
            DAOPersonagem dao = new DAOPersonagem(con);

            if(dao.getPersonagemByID(TelaUpdate.textIdPersonagem.getText()) == null) {
                area.setText("Id não cadastrado no banco");
            } 


            System.out.println("id: " + TelaUpdate.textIdEp.getText());
            String sql = String.format("SELECT * FROM personagem where idpersonagem = %s", TelaUpdate.textIdPersonagem.getText());

            
            try (
                Statement st = con.createStatement()) {
                ResultSet rs = st.executeQuery(sql);
                
                while(rs.next()){
                    area.setText("Id: " + rs.getString("idpersonagem") + "\n" + "Nome: " + rs.getString("nomepersonagem")+"\n");
                }
                

            } catch (SQLException e1) {
                System.out.println("Problemas em DAOAtor.create" + e1.getMessage());
            }

            

        }




    }
       

  
}