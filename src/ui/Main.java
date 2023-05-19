package ui;
import java.util.Scanner;
import model.SystemController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Main{

    private Scanner reader;
	private SystemController controller;
    private static boolean running = true;

	public Main(){
		reader = new Scanner(System.in); 
		controller = new SystemController();
	}
    public static void main(String[] args) throws ParseException{
        Main main = new Main();
        
        int option = 0;

        do{
            main.menu();
            option = main.validateIntegerInput();
            main.executeOption(option);

        }while(running);

        System.out.println(".............Adiós!!................");

    }
        
    public void menu(){
        System.out.println("");
        System.out.println("");
        System.out.println("<<<--------------------//------------------ ||° Menu °||------------------//-------------->>>");
        System.out.println("");
        System.out.println("1. Crear un proyecto");
        System.out.println("2. Culminar etapa de un proyecto");
        System.out.println("3. Registrar cápsula");
        System.out.println("4. Aprobar cápsula");
        System.out.println("5. Publicar cápsula");
        System.out.println("6. Informar cuantas capsulas hay por cada tipo");
        System.out.println("7. Informar las lecciones aprendidas que hay dentro de una etapa de un projecto");
        System.out.println("8. Proyecto con más cápsulas registradas");
        System.out.println("9. Consultar si un colaborador ha registrado cápsulas en algún proyecto.");
        System.out.println("10. Buscar situaciones y lecciones por palabras claves");
        System.out.println("11. Salir");
        System.out.println("");
    
    }
        
    public int validateIntegerInput(){
        int option = 0; 
        System.out.println("Ingrese la opción deseada: ");
        if(reader.hasNextInt()){
            option = reader.nextInt(); 
            System.out.println("");
        }
        else{
            reader.nextLine();
            option = -1; 
            System.out.println("Ingrese un valor entero"); 
        }
        return option; 
    }
            
            
    public void executeOption(int option) throws ParseException{

        switch (option){
            case 1:
                
                registerProject();
                registerStages();
                
                break;

            case 2:

                completeStage();
                
                break;

            case 3:

                registerCapsule();
        
                break;

            case 4:
                
                approveCapsule();

                break;

            case 5:
                
                publishCapsule();
                
                break;

            case 6:

                numberCapsulesRegisteredByType();
                
                break;

            case 7:

                printLessonsLearnedForStage();
                
                break;

            case 8:

                getProjectWithMostCapsules();

                break;
            case 9:
                
                checkCollaboratorRegisteredCapsules();

                break;

            case 10:
                
                searchCapsulesByHashtag();

                break;

            case 11:
                running = false;
                break; 
           
            default:
                System.out.println("Opción inválida");
                break;
                
        }
    }     


    public void registerProject() throws ParseException{
       
        System.out.println("INGRESE LOS DATOS DEL PROYECTO");
        System.out.println("");
        System.out.println("Nombre del proyecto:");
        String projectName = reader.next();

        System.out.println("Nombre del cliente:");
        String clientName = reader.next();
        System.out.println("");
        reader.nextLine();


        System.out.println("Fecha planeada de inicio (formato: dd/mm/yyyy):");
        String plannedStartDateString = reader.nextLine();
        Calendar plannedStartDate = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        plannedStartDate.setTime(sdf1.parse(plannedStartDateString));

        System.out.println("Fecha planeada de finalización (formato: dd/mm/yyyy):");
        String plannedEndDateString = reader.nextLine();
        Calendar plannedEndDate = Calendar.getInstance();
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        plannedEndDate.setTime(sdf2.parse(plannedEndDateString));

        System.out.println("Presupuesto del proyecto:");
        double budget = reader.nextDouble();
        reader.nextLine();

        System.out.println("Nombre del gerente de Green:");
        String greenManagerName = reader.next();

        System.out.println("Número celular del gerente de Green:");
        String greenManagerCellphone = reader.next();

        System.out.println("Nombre del gerente del cliente:");
        String clientManagerName = reader.next();

        System.out.println("Número celular del gerente del cliente:");
        String clientManagerCellphone = reader.next();

        System.out.println(controller.addProject(projectName, clientName, plannedStartDate, plannedEndDate, budget, greenManagerName, greenManagerCellphone, clientManagerName, clientManagerCellphone));
                    
        System.out.println("Proyecto añadido correctamente!");
    }



    public void registerStages() throws ParseException{

        System.out.println("");
        System.out.println("Escriba el nombre del projecto para agregar las etapas: ");
        String projectName = reader.next();
        reader.nextLine();

        System.out.println("Fecha planeada de inicio  de la etapa(formato: dd/mm/yyyy):");
        String plannedStartDateStageString = reader.nextLine();
        Calendar plannedStartDateStage = Calendar.getInstance();
        SimpleDateFormat sdfStage = new SimpleDateFormat("dd/MM/yyyy");
        plannedStartDateStage.setTime(sdfStage.parse(plannedStartDateStageString));

        System.out.println("Fecha planeada de finalización de la etapa (formato: dd/mm/yyyy):");
        String plannedEndDateStage1String = reader.nextLine();
        Calendar plannedEndDateStage1 = Calendar.getInstance();
        SimpleDateFormat sdfStage1 = new SimpleDateFormat("dd/MM/yyyy");
        plannedEndDateStage1.setTime(sdfStage1.parse(plannedEndDateStage1String));

        System.out.println("Fecha real de inicio  de la etapa(formato: dd/mm/yyyy):");
        String realStartDateStageString = reader.nextLine();
        Calendar realStartDateStage = Calendar.getInstance();
        SimpleDateFormat sdfStage2 = new SimpleDateFormat("dd/MM/yyyy");
        realStartDateStage.setTime(sdfStage2.parse(realStartDateStageString));

        System.out.println(controller.createdStages(projectName, plannedStartDateStage, plannedEndDateStage1, realStartDateStage));
   
    }



    public void completeStage() throws ParseException{

        System.out.println("Escriba el nombre del projecto donde se encuentra la etapa a culminar: ");
        String projectName = reader.next();

        System.out.print("Ingrese el nombre de la etapa a completar (Start / AnalisysStage / Design / Execution / Close / FollowAndControl): ");
        String nameStage = reader.next();
        reader.nextLine(); 
        
        System.out.print("Ingrese la fecha de aprobación (dd/MM/yyyy): ");
        String approvalDateString = reader.nextLine();
        Calendar approvalDate = Calendar.getInstance();
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
        approvalDate.setTime(sdf3.parse(approvalDateString));
        
        System.out.print("Ingrese la fecha real final (dd/MM/yyyy): ");
        String actualEndDateString = reader.nextLine();
        Calendar actualEndDate = Calendar.getInstance();
        SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
        actualEndDate.setTime(sdf4.parse(actualEndDateString));
        
        System.out.println(controller.completeStage(projectName, nameStage, approvalDate, actualEndDate)); 
    }



    public void registerCapsule(){

        System.out.println("Escriba el nombre del projecto donde quiere registrar la capsula: ");
        String projectName = reader.next();
        
        System.out.println("Ingrese el nombre de la etapa donde quiere registrar la capsula (Start / AnalisysStage / Design / Execution / Close / FollowAndControl): ");
        String nameStage = reader.next();

        System.out.println("Ingrese el ID de la capsula:");
        String capsuleId = reader.next();

        System.out.println("Ingrese la descripcion de la situacion:");
        String capsuleDescription = reader.next();
        reader.nextLine();

        System.out.println("Ingrese el tipo de la capsula: " + "\n" + "1 = técnico" + "\n" + "2 = gestión" + "\n" + "3 = dominio"+ "\n" + "4 = experiencias");
        int capsuleType = reader.nextInt();
        reader.nextLine();

        System.out.println("Ingrese el nombre del colaborador:");
        String collaboratorName = reader.nextLine();

        System.out.println("Ingrese el cargo del colaborador:");
        String collaboratorJob = reader.nextLine();

        System.out.println("Ingrese el aprendizaje o lección aprendida:");
        String lessonLearned = reader.nextLine();
        

        System.out.println("Ingrese las palabras claves (incluye el signo # al inicio o al final cuando las escriba):");
        String wordsWithHasgtag = reader.nextLine();
        

        System.out.println(controller.addCapsule(projectName, nameStage, capsuleId, capsuleDescription, capsuleType, collaboratorName, collaboratorJob, lessonLearned, wordsWithHasgtag));         

    }



    public void approveCapsule() throws ParseException{

        System.out.println("Escriba el nombre del projecto donde se encuentra la capsula que se va a  aprobar: ");
        String projectName = reader.next();
        
        System.out.println("Ingrese el nombre de la etapa donde se encuentra la capsula que se va a aprobar (Start / AnalisysStage / Design / Execution / Close / FollowAndControl):");
        String nameStage = reader.next();

        System.out.println("Ingrese el ID de la capsula para su aprobación:");
        String capsuleId = reader.next();
        reader.nextLine();

        System.out.print("Ingrese la fecha de aprobación (dd/MM/yyyy): ");
        String approvedDateString = reader.nextLine();
        Calendar approvedDate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        approvedDate.setTime(sdf.parse(approvedDateString));

        System.out.println(controller.approveCapsule(projectName, nameStage, capsuleId, approvedDate));

    }


    public void publishCapsule(){
        
        System.out.println("Escriba el nombre del projecto donde se encuentra la capsula que va a publicar: ");
        String projectName = reader.next();
        
        System.out.println("Ingrese el nombre de la etapa donde se encuentra la capsula que va a publicar (Start / AnalisysStage / Design / Execution / Close / FollowAndControl):");
        String nameStage = reader.next();

        System.out.println("Ingrese el ID de la capsula:");
        String capsuleId = reader.next();

        System.out.println(controller.publishCapsule(projectName, nameStage, capsuleId));
    }



    public void numberCapsulesRegisteredByType(){
        System.out.println(controller.numberCapsulesRegisteredByType());
    }



    public void printLessonsLearnedForStage(){

        System.out.println("Escriba el nombre del projecto donde se encuentra la etapa a consultar las lecciones: ");
        String projectName = reader.next();
        
        System.out.println("Ingrese el nombre de la etapa de la cual va a consultar las lecciones (Start / AnalisysStage / Design / Execution / Close / FollowAndControl):");
        String nameStage = reader.next();
        System.out.println("");
        
        System.out.println(controller.printLessonsLearnedForStage(projectName, nameStage));
    }



    public void getProjectWithMostCapsules(){

        System.out.println(controller.getProjectWithMostCapsules());
    }



    public void checkCollaboratorRegisteredCapsules(){

        System.out.println("Escriba el nombre del colaborador a consultar: ");
        String collaboratorName = reader.next();

        System.out.println(controller.checkCollaboratorRegisteredCapsules(collaboratorName));
    }



    public void searchCapsulesByHashtag(){

        System.out.println("Escriba las palabras claves (#):  ");
        String hashtag = reader.next();

        System.out.println(controller.searchCapsulesByHashtag(hashtag));

    }
            
}