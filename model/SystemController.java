package model;
import java.util.Calendar;
import model.Stage;
import model.Project;
import model.KnowledgeCapsule;


public class SystemController {
    
    private static final int maxProjects = 10;
    private Project[] projects;
    private int numProjects;

    public ProjectController(int maxProjects) {
        this.projects = new Project[maxProjects];
        this.numProjects = 0;
    }

    public void addProject(String projectName, String clientName, Calendar plannedStartDate, Calendar plannedEndDate, double projectBudget, String greenManagerName, String greenManagerPhone, String clientManagerName, String clientManagerPhone) {
        if (numProjects < projects.length) {
            Project project = new Project(projectName, clientName, plannedStartDate, plannedEndDate, projectBudget, greenManagerName, greenManagerPhone, clientManagerName, clientManagerPhone);
            projects[numProjects] = project;
            numProjects++;
        } else {
            System.out.println("Error: Maximum number of projects reached.");
        }
    }

    public void culminateStage(int stageIndex, boolean approval) {
    // Comprobamos que el índice de la etapa es válido
        if (stageIndex < 0 || stageIndex >= project.getStages().length) {
            System.out.println("Error: índice de etapa inválido.");
            return;
        }
        
        // Obtenemos la etapa actual y la siguiente
        Stage currentStage = project.getStages()[stageIndex];
        Stage nextStage = null;
        if (stageIndex < project.getStages().length - 1) {
            nextStage = project.getStages()[stageIndex + 1];
        }
        
        // Comprobamos que la etapa actual esté activa
        if (!currentStage.isActive()) {
            System.out.println("Error: la etapa seleccionada no está activa.");
            return;
        }
        
        // Registramos la aprobación de la etapa y la fecha real de finalización
        currentStage.setApproved(approval);
        currentStage.setRealEndDate(Calendar.getInstance());
        
        // Pasamos la etapa actual a inactiva y activamos la siguiente
        currentStage.setActive(false);
        if (nextStage != null) {
            nextStage.setActive(true);
            nextStage.setRealStartDate(Calendar.getInstance());
        }
        
        System.out.println("Etapa culminada exitosamente.");
    }

    public void approveCapsule(int etapaIndex, int capsulaIndex) {
        Stage stage = project.getStageName()[etapaIndex];
        KnowledgeCapsule capsula = Stage.getKnowledgeCapsule()[capsulaIndex];
        
        // Register the approval date as the current date
        capsula.setApprovalDate(Calendar.getInstance().getTime());
        
        // Update the capsule information in the stage
        etapa.getCapsule()[capsulaIndex] = capsule;
    }
   
    public void publicCapsule() {
    System.out.println("https://www.youtube.com/shorts/QQCtuwS8DCw");
    }


}