package dominio;

import java.util.LinkedList;

/**
 * Arquivo geral de Personagem, que descreve os atríbutos de Personagem
 * Função: Atribuição de dados e criação da classe Personagem
 */
public class Personagem implements OBJPOOFlix {
	private String id;
	private String nome;
    private LinkedList<Performance> perfomances;

	public Personagem(String id,String nome){
        this.id = id;
        this.nome = nome;
	}

	public void adperformance(Performance p){
        perfomances.add(p);
    }

	public String getid(){
        return id;
	}

	public String getnome(){
        return nome;
	}

	public String toString(){ 
        String s = "";
        s = "id: " + id + ";\n";
        s = s + "Nome: " + nome + ";\n";
        return s;
    }
}