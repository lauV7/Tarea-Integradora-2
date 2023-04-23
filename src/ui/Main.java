package ui;
import java.util.Scanner;

import model.Stage;
import model.SystemController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Main{
    public static void main(String[] args) throws ParseException{
        Scanner reader = new Scanner(System.in);
        SystemController controller = new SystemController();

        boolean running = true;

        while (running) {
            System.out.println("Menu");
            System.out.println("1. Crear un proyecto");
            System.out.println("2. Culminar etapa de un proyecto");
            System.out.println("3. Registrar cápsula");
            System.out.println("4. Aprobar cápsula");
            System.out.println("5. Publicar cápsula");
            System.out.println("6. Salir");

            System.out.print("Ingrese la opción deseada: ");
            int option = reader.nextInt();

            reader.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Ingrese los datos del proyecto:");

                        System.out.println("Nombre del proyecto:");
                        String projectName = reader.nextLine();

                        System.out.println("Nombre del cliente:");
                        String clientName = reader.nextLine();

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
                        String greenManagerName = reader.nextLine();

                        System.out.println("Número celular del gerente de Green:");
                        String greenManagerCellphone = reader.nextLine();

                        System.out.println("Nombre del gerente del cliente:");
                        String clientManagerName = reader.nextLine();

                        System.out.println("Número celular del gerente del cliente:");
                        String clientManagerCellphone = reader.nextLine();
                        
                        //falta añadir etapas: esto era más o menos lo que estaba haciendo pero no se si es correcto

                       

                       

                        controller.addProject(projectName, clientName, plannedStartDate, plannedEndDate, budget, greenManagerName, greenManagerCellphone, clientManagerName, clientManagerCellphone, null);
                        
                        
                        System.out.println("Proyecto añadido correctamente");




                        
                    
                    break;

                case 2:

                    System.out.print("Ingrese el indicador de la etapa a completar (0-6): ");
                    int stageIndex = reader.nextInt();

                    System.out.print("Ingrese la fecha de aprovacion (MM/yyyy): ");
                    String approvalDateString = reader.nextLine();
                    Calendar approvalDate = Calendar.getInstance();
                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
                    approvalDate.setTime(sdf3.parse(approvalDateString));

                    System.out.print("Ingrese la fecha real final (MM/yyyy): ");
                    String actualEndDateString = reader.nextLine();
                    Calendar actualEndDate = Calendar.getInstance();
                    SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
                    actualEndDate.setTime(sdf4.parse(actualEndDateString));

                   
                    
                    Stage[] stage = new Stage[6];
                    stage[0] = new Stage(" inicio");
                    stage[1] = new Stage("análisis");
                    stage[2] = new Stage("diseño");
                    stage[3] = new Stage("ejecución");
                    stage[4] = new Stage("cierre y seguimiento");
                    stage[6] = new Stage("control del proyecto");
                 
                    controller.completeStage(stageIndex, option, stageIndex, stage);

                    
                    
                    break;

                case 3:

                    int capsuleId;
                    String capsuleDescription, capsuleType, collaboratorName, collaboratorJob, lessonLearned;
            
                    System.out.println("Ingrese el ID de la cápsula:");
                    capsuleId = reader.nextInt();
                    reader.nextLine();
                    System.out.println("Ingrese la descripción de la situación:");
                    capsuleDescription = reader.nextLine();
                    System.out.println("Ingrese el tipo de la cápsula (técnico, gestión, dominio, experiencias):");
                    capsuleType = reader.nextLine();
                    System.out.println("Ingrese el nombre del colaborador:");
                    collaboratorName = reader.nextLine();
                    System.out.println("Ingrese el cargo del colaborador:");
                    collaboratorJob = reader.nextLine();
                    System.out.println("Ingrese el aprendizaje o lección aprendida:");
                    lessonLearned = reader.nextLine();

                    controller.registerCapsule(capsuleId, capsuleDescription, capsuleType, collaboratorName, collaboratorJob);
            
                    
                    break;

                case 4:
                    
                  
                    break;

                case 5:
                    controller.publishCapsule(null);
                    
                    break;

                case 6:
                    running = false;
                    break;

                case 7:

                    System.out.print("ingresar nombre de la etapa: ");
                    String stageName = reader.nextLine();
                    System.out.println("lecciones aprendidas por etapa " + stageName + ":");
                    controller.printLessonsLearnedForStage(stageName);
                    break;

                

                case 8:

                    System.out.println("Proyecto con mas capsulas registradas: " + controller.getProjectWithMostCapsules());

                    break;
                case 9:
                    System.out.print("Ingrese el nombre del colaborador: ");
                    String collaboratorName1 = reader.nextLine();
                    boolean hasRegisteredCapsules = controller.checkCollaboratorRegistration(collaboratorName1);
                    if (hasRegisteredCapsules) {
                        System.out.println(collaboratorName1 + " se han registrado las capsulas.");
                    } else {
                        System.out.println(collaboratorName1 + " no se ha registrado ninguna capsula.");
                    }
                    break;

                case 10:
                    System.out.println("Ingrese una palabra para buscar la leccion aprendida:");
                    SystemController.searchCapsulesByHashtag("lessonslearned");


                default:
                    System.out.println("Opción inválida");
                    break;


                
            }
        }

     reader.close();
    }
}