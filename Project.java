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

    public Project(String projectName, String clientName, Calendar plannedStartDate, Calendar plannedEndDate, double projectBudget, String greenManagerName, String greenManagerPhone, String clientManagerName, String clientManagerPhone) {
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

        Calendar stageStartDate = (Calendar) plannedStartDate.clone();
        for (int i = 0; i < stages.length; i++) {
        Calendar stageEndDate = (Calendar) stageStartDate.clone();
        stageEndDate.add(Calendar.MONTH, stageDurations[i]);

        stages[i] = new Stage(getStageName(i), stageStartDate, stageEndDate);

        stageStartDate = (Calendar) stageEndDate.clone();
        }
        this.currentStageIndex = 0;
        stages[0].setRealStartDate(Calendar.getInstance());
    }

    private String getStageName(int stageIndex) {
        switch (stageIndex) {
            case 0:
                return "Inicio";
            case 1:
                return "Análisis";
            case 2:
                return "Diseño";
            case 3:
                return "Ejecución";
            case 4:
                return "Cierre";
            case 5:
                return "Seguimiento y Control";
            default:
                return "";
        }
    }

    public void advanceToNextStage(boolean approved) {
        stages[currentStageIndex].setApproved(approved);
        stages[currentStageIndex].setRealEndDate(Calendar.getInstance());

        if (currentStageIndex < stages.length - 1) {
            currentStageIndex++;
            stages[currentStageIndex].setRealStartDate(Calendar.getInstance());
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
}