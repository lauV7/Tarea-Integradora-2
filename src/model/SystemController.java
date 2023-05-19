package model;
import java.util.Calendar;


public class SystemController{
    
    private static final int maxProjects = 10;
    private static Project[] projects;
    private int technicTypeCounter = 0;
    private int managementTYpeCounter = 0;
    private int domainTypeCounter = 0;
    private int experienceTypeCounter = 0;

    public SystemController(){
        projects = new Project[maxProjects];
        
    }

    public String addProject(String projectName, String clientName, Calendar plannedStartDate, Calendar plannedEndDate, double projectBudget, String greenManagerName, String greenManagerPhone, String clientManagerName, String clientManagerPhone){
        String msg = "";
        Project project = new Project(projectName, clientName, plannedStartDate, plannedEndDate, projectBudget, greenManagerName, greenManagerPhone, clientManagerName, clientManagerPhone);
        int pos = getFirstValidPosition();
        if(pos != -1){
        projects[pos] = project;
        }else {
        msg = "Error: numero maximo de proyectos alcanzados.";
        }
        return msg;
    }     

    
    public int getFirstValidPosition(){
        int pos = -1;
        boolean valid = false;
        for(int i = 0; i < maxProjects && !valid; i++ ){
            if(projects[i] == null){
                pos = i;
                valid = true;
            }
        }
        return pos;
    }

    public Project searchProject(String name){
        Project project = null;
        boolean found = false;
        for(int i = 0; i < projects.length && !found; i++){
            if (projects[i] != null && projects[i].getProjectName().equalsIgnoreCase(name)) {
                project = projects[i];
                found = true; 
            } 
        }return project;
    }

    

    public String createdStages(String projectName, Calendar plannedStartDate, Calendar plannedEndDate, Calendar actualStartDate){
        String msg = "";
        Project projectFounded = searchProject(projectName);

        if(projectFounded != null){
            Stage startStage = new Stage("Start", plannedStartDate, plannedEndDate, actualStartDate);
            boolean stageActiveStatus = startStage.getActive();
            if(stageActiveStatus == false){
                stageActiveStatus = true;
                startStage.setActive(stageActiveStatus);
                }
            projectFounded.addStages(startStage);

            Stage analysisStage = new Stage("AnalisysStage" , plannedStartDate, plannedEndDate, actualStartDate);
            projectFounded.addStages(analysisStage);

            Stage designStage = new Stage( "Design", plannedStartDate, plannedEndDate, actualStartDate);
            projectFounded.addStages(designStage);

            Stage executionStage = new Stage("Execution", plannedStartDate, plannedEndDate, actualStartDate);
            projectFounded.addStages(executionStage);

            Stage closeStage = new Stage("Close", plannedStartDate, plannedEndDate, actualStartDate);
            projectFounded.addStages(closeStage);

            Stage followAndControlStage = new Stage("FollowAndControl", plannedStartDate, plannedEndDate, actualStartDate);
            projectFounded.addStages(followAndControlStage);

            msg = "Stages register correctly";
        }

        else{
            msg = "project not found registered";
        }
        return msg;

    }


   
    public String completeStage(String projectName, String name, Calendar approvalDate, Calendar actualEndDate){
        String msg = "";
        Project projectFounded = searchProject(projectName);
        Stage searchedStage = projectFounded.searchStage(name);
        
        
        if(projectFounded != null){
            Stage[] stages = projectFounded.getStages();
            for(int i = 0; i < stages.length && searchedStage != null; i++){
                if(searchedStage.getActive() == true){
                    searchedStage.setApproved(true);
                    searchedStage.setActualEndDate(actualEndDate);
                    searchedStage.setActive(false);
                } 
                if(i < stages.length - 1){
                    Stage nextStage = stages[i + 1];
                    nextStage.setActive(true);      
                }
            } msg = "the stage has been completed";
        }return msg;	
    }



   
    public String addCapsule(String projectName, String name, String id, String description, int capsuleTypeSelect, String collaboratorName, String collaboratorJob, String lessonLearned, String wordsWithHashtag ){
        String msg = "";
        Project projectFounded = searchProject(projectName);
        Stage searchedStage = projectFounded.searchStage(name);
        
        if(projectFounded != null){
            if(searchedStage != null && searchedStage.getActive() == true){
                TypeCapsule capsuleType;

                if (capsuleTypeSelect == 1) {
                    capsuleType = TypeCapsule.TECHNIC;
                    technicTypeCounter ++;

                }else if (capsuleTypeSelect == 2) {
                    capsuleType = TypeCapsule.MANAGEMENT;
                    managementTYpeCounter ++;
    
                }else if (capsuleTypeSelect == 3) {
                    capsuleType = TypeCapsule.DOMAIN;
                    domainTypeCounter ++;
                }else {
                    capsuleType = TypeCapsule.EXPERIENCE;
                    experienceTypeCounter ++;
                }

                searchedStage.addCapsule(id,  description, capsuleType,  collaboratorName,  collaboratorJob,  lessonLearned, wordsWithHashtag );
                msg = "capsule register correctly";
            
            } else {
			    msg = "stage not found registered";
            } 
        }return msg;
    }



    public String approveCapsule(String projectName, String name, String id, Calendar approvalDate){
        String msg = "";
        Project projectFounded = searchProject(projectName);
        Stage searchedStage = projectFounded.searchStage(name);
        Capsule capsule = searchedStage.searchCapsule(id);
        boolean approvedCapsule = false;
        boolean capsuleStateApproval = capsule.getApproved();
        
        if(projectFounded != null){
            if(searchedStage != null && searchedStage.getActive() == true){
                if(capsule != null){
                    if(approvedCapsule != true){
                        approvedCapsule = true;
                        capsule.setApproved(approvedCapsule);
                        capsule.setApprovalDate(approvalDate);
                        msg = "Capsule approved";
                        
                    }else if ( capsuleStateApproval == true){
                        msg = "Capsule has already been approved";
                    }
                }
            }else {
                msg = "stage not found registered or is not acive";
            }
            
        }return msg;
    }



    public String publishCapsule(String projectName, String name, String id){
        String msg = "";
        Project projectFounded = searchProject(projectName);
        Stage searchedStage = projectFounded.searchStage(name);
        Capsule capsule = searchedStage.searchCapsule(id);

        if(projectFounded != null){
            if(searchedStage != null && searchedStage.getActive() == true){
                if(capsule != null){
                    if(capsule.getApproved() == true){
                            capsule.setPostStatus(true);
                            msg = "url de la capsula: https://youtube.com/shorts/SM0c_cAQkl8?feature=share";
                    }else{
                        msg = "capsule is not approved";
                    }
                }else{
                    msg = "Capsule not found registered"; 
                }
            }else{
                msg = "stage not found registered or is not acive";
            }
        }return msg;
    }


    public String numberCapsulesRegisteredByType(){
        String msg = "Number of technic capsules: " + technicTypeCounter + "\n" + "Number of management capsules: " + managementTYpeCounter + "\n" + "Number of domain capsules: " + domainTypeCounter + "\n" + "Number of experience capsules: " + experienceTypeCounter;
        return msg;
    }

    
    
    public String printLessonsLearnedForStage(String projectName, String name){
        String msg = "";
        Project projectFounded = searchProject(projectName);
        Stage searchedStage = projectFounded.searchStage(name);
        
        if(projectFounded != null){
            if(searchedStage!= null && searchedStage.getActive() == true){
                Capsule[] capsules = searchedStage.getCapsules();
                for(int i = 0; i < capsules.length ; i++){
                    if(capsules[i] != null){
                        msg += capsules[i].getLessonLearned() + "\n";
                    }
                }
            }
        }return msg;
    }



    public String getProjectWithMostCapsules(){
        String msg = " ";
        int maxCapsules = 0;

        for(int i = 0; i < projects.length; i ++){
            if(projects[i] != null){
                int numCapsules = 0;
                for(int j = 0; j < projects[i].getStages().length; j++ ){
                    if(projects[i].getStages()[j] != null){
                        for(int k = 0; k < projects[i].getStages()[j].getCapsules().length; k++){
                            Capsule[] capsules = projects[i].getStages()[j].getCapsules();
                            numCapsules += capsules.length;
                        }
                        if (numCapsules > maxCapsules) {
                            maxCapsules = numCapsules;
                            msg = "The project with the most capsules is: " + projects[i].getProjectName();
                        }
                    }
                }
            }
        }return msg;
    }

   
    

    public String checkCollaboratorRegisteredCapsules(String collaboratorName){
        String msg = " ";

        for(int i = 0; i < maxProjects; i++){
            if(projects[i] != null){
                for(int j = 0; j < projects[i].getStages().length; j++){
                    if(projects[i].getStages()[j] != null){
                        for(int k = 0; k < projects[i].getStages()[j].getCapsules().length; k++){
                            if(projects[i].getStages()[j].getCapsules()[k] != null){
                                if(projects[i].getStages()[j].getCapsules()[k].getCollaboratorName().equalsIgnoreCase(collaboratorName)){
                                    msg = "The collaborator has registered capsules in that project";
                                }
                                else{
                                    msg = "The collaborator has not registereds capsules in that project ";
                                }
                            }
                        }
                    }
                }
            }
        }return msg;
    }

    

    
    public String searchCapsulesByHashtag(String wordsWithHashtag){
        String msg = "";

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                Stage[] stages = projects[i].getStages();
                for(int j = 0; j++ < stages.length; j++){
                    // stage.get(j)
                    if(stages[j] != null){
                        Capsule[] capsules = stages[j].getCapsules();
                        for(int k = 0; k < capsules.length; k++){
                            if(capsules[k] != null && capsules[k].getApproved() == true && capsules[k].getPublishedState() == true){
                                msg += capsules[k].searchCapsuleByHashtag(wordsWithHashtag);

                            }
                        }
                    }
                }
            }
        }return msg;
    }   
}