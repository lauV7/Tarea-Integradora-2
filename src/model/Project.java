package model;
import java.util.Calendar;

    /**
    *
    *A class representing a project.
    */
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

    /**
    *Constructs a new Project with the given attributes and stages.
    *@param projectName the name of the project
    *@param clientName the name of the client for the project
    *@param plannedStartDate the planned start date for the project
    *@param plannedEndDate the planned end date for the project
    *@param projectBudget the budget allocated for the project
    *@param greenManagerName the name of the project manager responsible for the project
    *@param greenManagerPhone the phone number of the project manager responsible for the project
    *@param clientManagerName the name of the client manager responsible for the project
    *@param clientManagerPhone the phone number of the client manager responsible for the project
    *@param stageDurations an array of stage durations for the project
    */
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
    *Updates the actual start and end dates of a specific stage and sets it as inactive.
    *@param stageIndex the index of the stage to be updated
    *@param actualStartDate the actual start date of the stage
    *@param actualEndDate the actual end date of the stage
    */
    public void updateActualDates(int stageIndex, int actualStartDate, int actualEndDate) {
        this.stages[stageIndex].setActive(false);
        this.stages[stageIndex].setActualStartDate(actualStartDate);
        this.stages[stageIndex].setActualEndDate(actualEndDate);
    }



    /**
    *Approves the stage at the specified index and sets the next stage as active.
    *@param stageIndex the index of the stage to approve
    */
    public void approveStage(int stageIndex) {
        this.stages[stageIndex].setApproved(true);
        if (stageIndex < 5) {
            this.stages[stageIndex + 1].setActive(true);
        }
    }


    /**
    *
    *Returns the name of the stage for the specified index.
    *@param i the index of the stage to get the name for
    *@return the name of the stage for the specified index, or an empty string if the index is invalid
    */
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

    /**
    *Adds a capsule to the specified stage.
    *
    *@param stageIndex the index of the stage to add the capsule to
    *@param capsule the capsule to add
    */
    public void addCapsule(int stageIndex, Capsule capsule) {
        Stage stage = stages[stageIndex];
        if (stage.getCapsules().length >= 50) {
            System.out.println("Cannot add more capsules to this stage");
        } else {
            stage.addCapsule(capsule);
        }
    }

        
        
    /**
    *
    *Returns the project name.
    *@return the project name
    */
    public String getProjectName() {
        return projectName;
    }


    /**
    *
    *Sets the project name.
    *@param projectName the project name to set
    */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
    *
    *Returns the client name.
    *@return the client name
    */
    public String getClientName() {
        return clientName;
    }

    /**
    *
    *Sets the client name.
    *@param clientName the client name to set
    */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


    /**
    *
    *Returns the planned start date.
    *@return the planned start date
    */
    public Calendar getPlannedStartDate() {
        return plannedStartDate;
    }


    /** 
    *
    *Sets the planned start date.
    *@param plannedStartDate the planned start date to set
    */
    public void setPlannedStartDate(Calendar plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    /**
    *
    *Returns the planned end date.
    *@return the planned end date
    */
    public Calendar getPlannedEndDate() {
        return plannedEndDate;
    }

    /**
    *
    *Sets the planned end date.
    *@param plannedEndDate the planned end date to set
    */
    public void setPlannedEndDate(Calendar plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    /**
    *
    *Returns the project budget.
    *@return the project budget
    */
    public double getProjectBudget() {
        return projectBudget;
    }


    /**
    *
    *Sets the project budget.
    *@param projectBudget the project budget to set
    */
    public void setProjectBudget(double projectBudget) {
        this.projectBudget = projectBudget;
    }


    /**
    *
    *Returns the green manager name.
    *@return the green manager name
    */
    public String getGreenManagerName() {
        return greenManagerName;
    }


    /**
    *
    *Sets the green manager name.
    *@param greenManagerName the green manager name to set
    */
    public void setGreenManagerName(String greenManagerName) {
        this.greenManagerName = greenManagerName;
    }


    /**
    *
    *Returns the green manager phone.
    *@return the green manager phone
    */
    public String getGreenManagerPhone() {
        return greenManagerPhone;
    }


    /**
    *
    *Sets the green manager phone.
    *@param greenManagerPhone the green manager phone to set
    */
    public void setGreenManagerPhone(String greenManagerPhone) {
        this.greenManagerPhone = greenManagerPhone;
    }


    /**
    *
    *Returns the client manager name.
    *@return the client manager name
    */
    public String getClientManagerName() {
        return clientManagerName;
    }

    /**
    *
    *Sets the client manager name.
    *@param clientManagerName the client manager name to set
    */
    public void setClientManagerName(String clientManagerName) {
        this.clientManagerName = clientManagerName;
    }

    /**
    *
    *Returns the client manager phone.
    *@return the client manager phone
    */
    public String getClientManagerPhone() {
        return clientManagerPhone;
    }

    /**
    *
    *Sets the client manager phone.
    *@param clientManagerPhone the client manager phone to set
    */
    public void setClientManagerPhone(String clientManagerPhone) {
        this.clientManagerPhone = clientManagerPhone;
    }

    /**
    *
    *Returns the stages of the project.
    *@return the stages of the project
    */
    public Stage[] getStages() {
        return this.stages;
    }



    /**
    *
    *Returns the capsules of the project.
    *@return the capsules of the project
    */
    public Capsule[] getCapsules() {
        return null;
    }

    
}