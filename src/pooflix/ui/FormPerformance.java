package ui;

import java.io.Console;

import cdu.CDUPerformance;

/**
 * Gerenciador de formulário - Perfomance
 * Função: Registrar inputs do usuário e criar objeto perfomance
 */
public class FormPerformance extends Form {
    private String episodioID;
    private String personagemID;
    private String atorID;
    private CDUPerformance cduper;

    public void setcduper(CDUPerformance cduper){
        this.cduper = cduper;
    }

    public void exibe(){
        Console c = System.console();
        boolean termina = false;
        String continuar;

        System.out.println("CADASTRANDO PERFORMANCE\n");

        while(!termina){
            episodioID = c.readLine("ID episódio: ");
            personagemID = c.readLine("ID personagem: ");
            atorID = c.readLine("ID ator: ");

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");

            cduper.salvarPerformance();
        }
    }

    public void updatePerformance(){
        //Faz o update de performance de acordo com o que o usuário decidir mudar
        Console c = System.console();
        boolean termina = false;
        String continuar;
        String updt;

        System.out.println("UPDATE DE DADOS DE PERFORMANCE\n");

        while(!termina){
            episodioID = c.readLine("ID do episodio que deseja mudar os dados: ");
            //verificação, para saber se id de episódio existe no banco de dados
            if(episodioID.equals(this.getidep())){
                updt = c.readLine("O que deseja mudar deste episódio? Digite (P)ersonagem, (A)tor: ");
                if(updt.equals("P")){
                    personagemID = c.readLine("Qual será o novo ID deste personagem? "); 
                    //Verifica se já existe esse novo ID no banco de dados
                    if(personagemID.equals(this.getidperson())){
                        personagemID = c.readLine("Esse ID de personagem já existe no banco de dados, tente outro ID: ");
                    }
                }else if(updt.equals("A")){
                    atorID = c.readLine("Qual será o novo ID deste ator? ");
                    //Verifica se já existe esse novo ID no banco de dados
                    if(atorID.equals(this.getidator())){
                        atorID = c.readLine("Esse ID de ator já existe no banco de dados, tente outro ID: ");
                    }
                }
                //Mudar o ID do episódio?
            }else{
                System.out.println("Erro! ID não encontrado no banco de dados, tente novamente");
                continuar = c.readLine("Deseja tentar novamente? (s/n): ");
                termina = continuar.toLowerCase().equals("n");  
            }
            continuar = c.readLine("Deseja mudar mais alguma coisa? (s/n): ");
            termina = continuar.toLowerCase().equals("n");
        }

        //cduper.updatePerfomance();

    }
    public void deletePerformance(){
        //Deleta uma performance do banco de dados
        Console c = System.console();

        System.out.println("DELETANDO PERFORMANCE\n");

        episodioID = c.readLine("ID da performance que deseja deletar do banco de dados");
        //verificando se o id existe no banco de dados
        if(episodioID.equals(this.getidep())){
            //cduca.deletePerformance();
            System.out.printf("Performance %d deletada com sucesso do banco de dados..", this.getidep());
        }

    }

        
    public String getidep(){
        return episodioID;
    }

    public String getidperson(){
        return personagemID;
    }

    public String getidator(){
        return atorID;
    }
}
