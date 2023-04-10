package ui;
import java.util reader;
import model.SystemController;



public class Main{
    public static void main(String[] args) {
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

            switch (option) {
                case 1:
                    System.out.println("Ingrese los datos del proyecto:");

                        System.out.println("Nombre del proyecto:");
                        String projectName = scanner.nextLine();

                        System.out.println("Nombre del cliente:");
                        String clientName = scanner.nextLine();

                        System.out.println("Fecha planeada de inicio (formato: dd/mm/yyyy):");
                        String plannedStartDateString = scanner.nextLine();
                        Calendar plannedStartDate = Calendar.getInstance();
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                        plannedStartDate.setTime(sdf1.parse(plannedStartDateString));

                        System.out.println("Fecha planeada de finalización (formato: dd/mm/yyyy):");
                        String plannedEndDateString = scanner.nextLine();
                        Calendar plannedEndDate = Calendar.getInstance();
                        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                        plannedEndDate.setTime(sdf2.parse(plannedEndDateString));

                        System.out.println("Presupuesto del proyecto:");
                        double budget = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("Nombre del gerente de Green:");
                        String greenManagerName = scanner.nextLine();

                        System.out.println("Número celular del gerente de Green:");
                        String greenManagerCellphone = scanner.nextLine();

                        System.out.println("Nombre del gerente del cliente:");
                        String clientManagerName = scanner.nextLine();

                        System.out.println("Número celular del gerente del cliente:");
                        String clientManagerCellphone = scanner.nextLine();

                        controller.addProject(projectName, clientName, plannedStartDateString, plannedEndDateString, budget, greenManagerName, greenManagerCellphone, clientManagerName, clientManagerCellphone);
                        System.out.println("Proyecto añadido correctamente");
                    
                    break;

                case 2:
                   controller.culminateStage();
                    break;

                case 3:
                    System.out.println("Capsule ID: " + capsula.getId());
                    System.out.println("Description: " + capsula.getDescription());
                    System.out.println("Capsule Type: " + capsula.getType());
                    System.out.println("Collaborator: " + capsula.getAuthor().getName() + " (" + capsula.getAuthor().getPosition() + ")");
                    System.out.println("Lesson learned: " + capsula.getLessonLearned());
                    
                    break;

                case 4:
                    controller.approveCapsule();
                  
                    break;

                case 5:
                    controller.publishCapsule();
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }

     reader.close();
    }
}