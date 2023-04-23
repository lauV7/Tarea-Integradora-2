package model;
import java.util.Calendar;


public class Project {
    private String projectName;
    private String clientName;
    private Calendar plannedStartDate;
    private Calendar plannedEndDate;
    private double projectBudget;
    private String greenManagerName;
    private String greenManagerPhone;
    private String clientManagerName;
    private String clientManagerPhone;
    private Stage[] stages;

    public Project(String projectName, String clientName, Calendar plannedStartDate, Calendar plannedEndDate, double projectBudget, String greenManagerName, String greenManagerPhone, String clientManagerName, String clientManagerPhone, int[] stageDurations) {
        this.projectName = projectName;
        this.clientName = clientName;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.projectBudget = projectBudget;
        this.greenManagerName = greenManagerName;
        this.greenManagerPhone = greenManagerPhone;
        this.clientManagerName = clientManagerName;
        this.clientManagerPhone = clientManagerPhone;

       
      

        this.stages = new Stage[6];
        this.stages[0] = new Stage("Initiation", true);
        for (int i = 1; i < 6; i++) {
            this.stages[i] = new Stage(getStageName(i));
            this.stages[i].setPlannedStartDate(this.stages[i - 1].getPlannedEndDate() + 1);
            this.stages[i].setPlannedEndDate(this.stages[i].getPlannedStartDate() + stageDurations[i - 1] - 1);
        }
    }

    /**

    Updates the actual start and end dates of a specific stage and sets it as inactive.
    @param stageIndex the index of the stage to be updated
    @param actualStartDate the actual start date of the stage
    @param actualEndDate the actual end date of the stage
    
    */

    

    public void updateActualDates(int stageIndex, int actualStartDate, int actualEndDate) {
        this.stages[stageIndex].setActive(false);
        this.stages[stageIndex].setActualStartDate(actualStartDate);
        this.stages[stageIndex].setActualEndDate(actualEndDate);
    }

    public void approveStage(int stageIndex) {
        this.stages[stageIndex].setApproved(true);
        if (stageIndex < 5) {
            this.stages[stageIndex + 1].setActive(true);
        }
    }

    private static String getStageName(int i) {
        switch (i) {
            case 1:
                return "Analysis";
            case 2:
                return "Design";
            case 3:
                return "Execution";
            case 4:
                return "Closure";
            case 5:
                return "Monitoring and Control";
            default:
                return "";
        }
    }

    public void addCapsule(int stageIndex, Capsule capsule) {
        Stage stage = stages[stageIndex];
        if (stage.getCapsules().length >= 50) {
            System.out.println("Cannot add more capsules to this stage");
        } else {
            stage.addCapsule(capsule);
        }
    }

        
        

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Calendar getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Calendar plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Calendar getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(Calendar plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public double getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(double projectBudget) {
        this.projectBudget = projectBudget;
    }

    public String getGreenManagerName() {
        return greenManagerName;
    }

    public void setGreenManagerName(String greenManagerName) {
        this.greenManagerName = greenManagerName;
    }

    public String getGreenManagerPhone() {
        return greenManagerPhone;
    }

    public void setGreenManagerPhone(String greenManagerPhone) {
        this.greenManagerPhone = greenManagerPhone;
    }

    public String getClientManagerName() {
        return clientManagerName;
    }

    public void setClientManagerName(String clientManagerName) {
        this.clientManagerName = clientManagerName;
    }

    public String getClientManagerPhone() {
        return clientManagerPhone;
    }

    public void setClientManagerPhone(String clientManagerPhone) {
        this.clientManagerPhone = clientManagerPhone;
    }

    public Stage[] getStages() {
        return this.stages;
    }




    public Capsule[] getCapsules() {
        return null;
    }

    
}