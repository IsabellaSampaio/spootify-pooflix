/*
 * spOOtify app
 * by: Isabella Sampaio
 * versão = 1.0
 * SO = win10
 */

import java.io.IOException;
import java.util.Scanner;

public class SpootifyApp {
    public static void main(String[] args) throws InterruptedException, IOException{
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        SpootifyPlaylist biblioteca = new SpootifyPlaylist("Biblioteca");
        SpootifyMenu menu = new SpootifyMenu(scan, opcao,"Biblioteca", biblioteca);

        
        while(opcao != 6){
            menu.menu();
            opcao = menu.lerOpcaoMenu();
            menu.escolheMenu(opcao);             
        }       
        
        
        
    }
}

