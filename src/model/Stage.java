package model;

import java.util.Calendar;

public class Stage{
    
    private static final int SIZE1 = 50;
    private String name;
    private boolean active;
    private Calendar plannedStartDate;
    private Calendar plannedEndDate;
    private Calendar actualStartDate;
    private Calendar actualEndDate;
    private boolean approved;
    private Capsule[] capsules;
    

    public Stage(String name, Calendar plannedStartDate, Calendar plannedEndDate, Calendar actualStartDate){
        this.name = name;
        this.active = false;
        this.approved = false;
        this.plannedStartDate = plannedStartDate;
        this.actualStartDate = actualStartDate;
        this.plannedEndDate = plannedEndDate;
        this.capsules = new Capsule[SIZE1];

    }

    public String getName(){
        return this.name;
    }

    public boolean getActive(){
        return this.active;
    }


    public void setActive(boolean active){
        this.active = active;
    }

    
    public Calendar getPlannedStartDate(){
        return this.plannedStartDate;
    }

    public void setPlannedStartDate(Calendar plannedStartDate){
        this.plannedStartDate = plannedStartDate;
    }

   
    public Calendar getPlannedEndDate(){
        return this.plannedEndDate;
    }


    public void setPlannedEndDate(Calendar plannedEndDate){
        this.plannedEndDate = plannedEndDate;
    }


    public Calendar getActualStartDate(){
        return this.actualStartDate;
    }

   
    public void setActualStartDate(Calendar actualStartDate){
        this.actualStartDate = actualStartDate;
    }

    
    public Calendar getActualEndDate(){
        return this.actualEndDate;
    }

    
    public void setActualEndDate(Calendar actualEndDate){
        this.actualEndDate = actualEndDate;
    }


    public boolean isApproved(){
        return this.approved;
    }

   
    public void setApproved(boolean approved){
        this.approved = approved;
    }

    public Capsule[] getCapsules() {
        return capsules;
    }


    @Override
    public String toString() {
        String status = "Active";
        if (approved) {
            status = "Approved";
        } else if (actualStartDate != null && actualEndDate != null) {
            status = "Completed";
        } else if (plannedStartDate != null && plannedEndDate != null) {
            status = "Planned";
        }
        return name + ": " + status + " (Planned Start Date: " + formatDate(plannedStartDate) + ", Planned End Date: " + formatDate(plannedEndDate) + ", Actual Start Date: " + formatDate(actualStartDate) + ", Actual End Date: " + formatDate(actualEndDate) + ")";
    }
    

    private String formatDate(Calendar calendar) {
        if (calendar == null) {
            return "N/A";
        }
        return calendar.getTime().toString();
    }
    


    public String addCapsule(String id, String description, TypeCapsule type, String collaboratorName, String collaboratorJob,  String lessonLearned,  String wordsWithHashtag) {

        Capsule capsule = new Capsule(id, description, type, collaboratorName, collaboratorJob, lessonLearned,  wordsWithHashtag );
    
        String msg = "Maximum capacity";
        boolean stop = false;

        for( int i = 0; i < capsules.length && !stop; i++ ){
            if(capsules[i] == null){
                capsules[i] = capsule;
                msg = "the capsule was added";
                stop = true;

            }
        }return msg;
    }


    public Capsule searchCapsule(String id){

        Capsule capsule = null;
        boolean found = false;
        for(int i = 0; i < capsules.length && !found; i++){
            if (capsules[i] != null && capsules[i].getId().equals(id)) {
                capsule = capsules[i];
                found = true;  
            } 
        }return capsule;
    }
   

   

    
    

    

    

}