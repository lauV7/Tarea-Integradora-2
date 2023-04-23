package model;



public class Capsule {
    private int id;
    private String description;
    private String type;
    private String collaboratorName;
    private String collaboratorJob;
    private String lessonLearned;

    public Capsule(int id, String description, String type, String collaboratorName, String collaboratorJob, String lessonLearned) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.collaboratorName = collaboratorName;
        this.collaboratorJob = collaboratorJob;
        this.lessonLearned = lessonLearned;
    }

   

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getCollaboratorName() {
        return collaboratorName;
    }

    public String getCollaboratorJob() {
        return collaboratorJob;
    }

    public String getLessonLearned() {
        return lessonLearned;
    }

    public String toString() {
        return "Capsule #" + id + ": " +
                "Description: " + description +
                ", Type: " + type +
                ", Collaborator: " + collaboratorName + " (" + collaboratorJob + ")" +
                ", Lesson learned: " + lessonLearned;
    }

    

    public void setApproved(String string) {
    }

    public Object getApproved() {
        return null;
    }
}