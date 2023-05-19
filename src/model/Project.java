package model;
import java.util.Calendar;

public class Project{
    private String projectName;
    private String clientName;
    private Calendar plannedStartDate;
    private Calendar plannedEndDate;
    private double projectBudget;
    private String greenManagerName;
    private String greenManagerPhone;
    private String clientManagerName;
    private String clientManagerPhone;
    private static final int SIZE = 6;
    private Stage[] stages;

   
    public Project(String projectName, String clientName, Calendar plannedStartDate, Calendar plannedEndDate, double projectBudget, String greenManagerName, String greenManagerPhone, String clientManagerName, String clientManagerPhone){
        this.projectName = projectName;
        this.clientName = clientName;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.projectBudget = projectBudget;
        this.greenManagerName = greenManagerName;
        this.greenManagerPhone = greenManagerPhone;
        this.clientManagerName = clientManagerName;
        this.clientManagerPhone = clientManagerPhone;
        this.stages = new Stage[SIZE];
        
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


    public int getFirstValidPosition(){
        int pos = -1;
        boolean valid = false;
        for(int i = 0; i < SIZE && !valid; i++ ){
            if(stages[i] == null){
                pos = i;
                valid = true;
            }
        }return pos;
    }


    public Stage searchStage(String name){

        Stage stage = null;
        boolean found = false;
        for(int i = 0; i < stages.length && !found; i++){
            if (stages[i] != null && stages[i].getName().equalsIgnoreCase(name)){
                stage = stages[i];
                found = true;
                
            } 
        }return stage;
    }
    

    public void addStages(Stage stage){
        int pos = getFirstValidPosition();
        if(pos != -1){
            stages[pos] = stage;
        }
    }

}