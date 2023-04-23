package model;
import java.util.Calendar;



public class SystemController {
    
    private static final int maxProjects = 10;
    private static Project[] projects;
    private int numProjects;

    public SystemController() {
        SystemController.projects = new Project[maxProjects];
        this.numProjects = 0;
    }

    public void addProject(String projectName, String clientName, Calendar plannedStartDate, Calendar plannedEndDate, double projectBudget, String greenManagerName, String greenManagerPhone, String clientManagerName, String clientManagerPhone , int [] meses) {
        
        if (numProjects < projects.length) {
            Project project = new Project(projectName, clientName, plannedStartDate, plannedEndDate, projectBudget, greenManagerName, greenManagerPhone, clientManagerName, clientManagerPhone, meses );
            projects[numProjects] = project;
            numProjects++;
        } else {
            System.out.println("Error: Maximum number of projects reached.");
        }
    }

    public void completeStage(int stageIndex, int approvalDate, int actualEndDate, Stage[] stages) {
        Stage currentStage = stages[stageIndex];
        currentStage.setApproved(true);
        currentStage.setActualEndDate(actualEndDate);
        currentStage.setActive(false);
    
        if (stageIndex < stages.length - 1) {
            Stage nextStage = stages[stageIndex + 1];
            nextStage.setActive(true);
            nextStage.setActualStartDate(approvalDate);
        }
    }

    public void registerCapsule(Stage stage) {
        stage.addCapsule(this);
    }

    

    public void printLessonsLearnedForStage(String stage1) {
        
    
        for (Project project : projects) {
            if (project.getStages().equals(stage1)) {
                for (Capsule capsule : project.getCapsules()) {
                    System.out.println(capsule.getLessonLearned());
                }
            }
        }
    }

    public String getProjectWithMostCapsules() {
        String projectName = null;
        int maxCapsules = 0;
        for (Project project : projects) {
            int numCapsules = 0;
            for (Stage stage : project.getStages()) {
                numCapsules += stage.getCapsules().length;
            }
            if (numCapsules > maxCapsules) {
                maxCapsules = numCapsules;
                projectName = project.getProjectName();
            }
        }
        return projectName;

    }

    public boolean checkCollaboratorRegistration(String collaboratorName) {
        boolean registered = false;
        for (Project project : projects) {
            for (Stage stage : project.getStages()) {
                for (Capsule capsule : stage.getCapsules()) {
                    if (capsule.getCollaboratorName().equalsIgnoreCase(collaboratorName)) {
                        registered = true;
                        break;
                    }
                }
                if (registered) {
                    break;
                }
            }
            if (registered) {
                System.out.println(collaboratorName + " han sido registradas las cápsulas en el proyecto " + project.getProjectName());
                break;
            }
        }
        if (!registered) {
            System.out.println(collaboratorName + " no han sido registradas ninguna capsula en un proyecto.");
        }
        return registered;
    }


    

    public static void searchCapsulesByHashtag(String hashtag) {
        System.out.println("Capsules containing #" + hashtag + ":");
    
        for (Project project : projects) {
            for (Stage stage : project.getStages()) {
                for (Capsule capsule : stage.getCapsules()) {
                    if (capsule.getType().equals("Approved and Published")) {
                        String[] hashtags = capsule.getDescription().split(" ");
                        for (String h : hashtags) {
                            if (h.startsWith("#") && h.contains(hashtag)) {
                                System.out.println(capsule.toString());
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void countCapsulesByType() {
        int technicalCount = 0;
        int managementCount = 0;
        int domainCount = 0;
        int experienceCount = 0;
    
        for (Project project : projects) {
            for (Stage stage : project.getStages()) {
                for (Capsule capsule : stage.getCapsules()) {
                    switch (capsule.getType()) {
                        case "Technical":
                            technicalCount++;
                            break;
                        case "Management":
                            managementCount++;
                            break;
                        case "Domain":
                            domainCount++;
                            break;
                        case "Experience":
                            experienceCount++;
                            break;
                    }
                }
            }
        }
    
        System.out.println("Capsules by type:");
        System.out.println("Technical: " + technicalCount);
        System.out.println("Management: " + managementCount);
        System.out.println("Domain: " + domainCount);
        System.out.println("Experience: " + experienceCount);
    }
    
    public void publishCapsule(Capsule capsule) {
        if (capsule.getType().equals("Organizational Interest") && capsule.getApproved().equals("Approved")) {
            capsule.setApproved("Approved and Published");
            System.out.println("Capsule has been published: youtube.com/watch?v=EsfSuL-VFBw&list=PLPsYW7baIENblzkBM6EyewRZExc1Jzt_X&ab_channel=LuisFonsiVEVO");
        } else {
            System.out.println("Capsule cannot be published.");
        }
    }

    public void registerCapsule(int capsuleId, String capsuleDescription, String capsuleType, String collaboratorName,
            String collaboratorJob) {
    }

   

   
    
    
    
    
    
    
    

    
}