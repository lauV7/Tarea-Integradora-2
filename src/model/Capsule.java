package model;



public class Capsule {
    private int id;
    private String description;
    private String type;
    private String collaboratorName;
    private String collaboratorJob;
    private String lessonLearned;

    /**
    *
    *Constructs a new Capsule object with the specified parameters.
    *@param id the unique identifier of the Capsule
    *@param description a brief description of the Capsule
    *@param type the type of the Capsule
    *@param collaboratorName the name of the collaborator who created the Capsule
    *@param collaboratorJob the job position of the collaborator who created the Capsule
    *@param lessonLearned a summary of the lessons learned from the event or outcome that the Capsule represents
    */
    public Capsule(int id, String description, String type, String collaboratorName, String collaboratorJob, String lessonLearned) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.collaboratorName = collaboratorName;
        this.collaboratorJob = collaboratorJob;
        this.lessonLearned = lessonLearned;
        
    }

   
    /**
    * Returns the id of the capsule.
    * 
    * @return the id of the capsule
    */
    public int getId() {
        return id;
    }

    /**
     * Returns the description of the capsule.
     * 
     * @return the description of the capsule
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the type of the capsule.
     * 
     * @return the type of the capsule
     */
    public String getType() {
        return type;
    }


    /**
     * Returns the name of the collaborator who created the capsule.
     * 
     * @return the name of the collaborator who created the capsule
     */
    public String getCollaboratorName() {
        return collaboratorName;
    }

    
        
    /**
     * Returns the job title of the collaborator who created the capsule.
     * 
     * @return the job title of the collaborator who created the capsule
     */
    public String getCollaboratorJob() {
        return collaboratorJob;
    }


    /**
     * Returns the lesson learned from the capsule.
     * 
     * @return the lesson learned from the capsule
     */
    public String getLessonLearned() {
        return lessonLearned;
    }


    
    /**
     * Returns a string representation of the capsule, including its id, description, type,
     * collaborator name and job title, and lesson learned.
     * 
     * @return a string representation of the capsule
     */
    public String toString() {
        return "Capsule #" + id + ": " +
                "Description: " + description +
                ", Type: " + type +
                ", Collaborator: " + collaboratorName + " (" + collaboratorJob + ")" +
                ", Lesson learned: " + lessonLearned;
    }

    
    /**
     * Sets the approval status of the capsule.
     * 
     * @param approved a boolean value indicating whether the capsule is approved or not
     */
    public void setApproved(String string) {
    }


    /**
     * Returns the approval status of the capsule.
     * 
     * @return a boolean value indicating whether the capsule is approved or not
     */
    public Object getApproved() {
        return null;
    }
}