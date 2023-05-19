package model;

import java.util.Calendar;

public class Capsule{
    private String id;
    private String description;
    private TypeCapsule type;
    private String collaboratorName;
    private String collaboratorJob;
    private String lessonLearned;
    private boolean approved;
    private String wordsWithHashtag;
    private boolean publishedState;
    private Calendar approvalDate;
    private boolean postStatus;


    public Capsule(String id, String description, TypeCapsule type, String collaboratorName, String collaboratorJob,  String lessonLearned, String wordsWithHashtag){
        this.id = id;
        this.description = description;
        this.type = type;
        this.collaboratorName = collaboratorName;
        this.collaboratorJob = collaboratorJob;
        this.lessonLearned = lessonLearned;
        this.approved = false;
        this.wordsWithHashtag = wordsWithHashtag;
        this.publishedState = false;
        this.postStatus = false;
        
    }

 
    public String getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }


    public TypeCapsule getType() {
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

    public boolean getApproved() {
        return this.approved;
    }


    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Calendar getApprovalDate() {
        return approvalDate;
    }


    public void setApprovalDate(Calendar approvalDate) {
        this.approvalDate = approvalDate;
    }

    public boolean getPublishedState() {
        return publishedState;
    }


    public void setPublishedState(boolean publishedState) {
        this.publishedState = publishedState;
    }

    public boolean isPostStatus() {
        return postStatus;
    }


    public void setPostStatus(boolean postStatus) {
        this.postStatus = postStatus;
    }

    public String getWordsWithHashtag() {
        return wordsWithHashtag;
    }


    public void setWordsWithHashtag(String wordsWithHashtag) {
        this.wordsWithHashtag = wordsWithHashtag;
    }




    public String searchCapsuleByHashtag(String wordsWithHashtag){
        String msg = " ";
        // keyWords (string)
        // keyWordsArray[] = keywords.split("#")
        // 
        String[] keywordsSelected = wordsWithHashtag.split("#");
        for(int i = 0; i < keywordsSelected.length; i++){
            if(keywordsSelected[i].equals(wordsWithHashtag)){
                msg = lessonLearned;
            }
        }return msg;
    }


    public String toString(){
        return "Lesson learned: " + lessonLearned;
    }

    
   

    
}