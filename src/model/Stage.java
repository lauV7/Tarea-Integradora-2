package model;


    /**
    *A Stage represents a phase of a project, consisting of one or more Capsules.
    */

public class Stage {
    private String name;
    private boolean active;
    private int plannedStartDate;
    private int plannedEndDate;
    private int actualStartDate;
    private int actualEndDate;
    private boolean approved;
    private Capsule[] capsules;
    

    private int numCapsules;

    /**
    *
    *Constructs a new Stage with the given name and active status.
    *@param name The name of the Stage.
    *@param active Whether the Stage is currently active or not.
    */
    public Stage(String name, boolean active) {
        this.name = name;
        this.active = active;
        this.approved = false;
        this.plannedStartDate = 0;
        this.plannedEndDate = 0;
        this.actualStartDate = 0;
        this.actualEndDate = 0;
        this.capsules = new Capsule[50];
        this.numCapsules = 0;
    }

    /**
    *
    *Constructs a new Stage with the given name and inactive status.
    *@param name The name of the Stage.
    */
    public Stage(String name) {
        this(name, false);
    }

    /**
    *
    *Returns the name of the Stage.
    *@return The name of the Stage.
    */
    public String getName() {
        return this.name;
    }

    /**
    *
    *Returns whether the Stage is currently active or not.
    *@return Whether the Stage is currently active or not.
    */
    public boolean isActive() {
        return this.active;
    }


    /**
    *
    *Sets whether the Stage is currently active or not.
    *@param active Whether the Stage is currently active or not.
    */
    public void setActive(boolean active) {
        this.active = active;
    }


    /**
    *
    *Returns the planned start date of the Stage.
    *@return The planned start date of the Stage.
    */
    public int getPlannedStartDate() {
        return this.plannedStartDate;
    }


    /**
    *
    *Sets the planned start date of the Stage.
    *@param plannedStartDate The planned start date of the Stage.
    */
    public void setPlannedStartDate(int plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }


    /**
    *
    *Returns the planned end date of the Stage.
    *@return The planned end date of the Stage.
    */
    public int getPlannedEndDate() {
        return this.plannedEndDate;
    }


    /**
    *
    Sets the planned end date of the Stage.
    *@param plannedEndDate The planned end date of the Stage.
    */
    public void setPlannedEndDate(int plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }


    /**
     * Returns the actual start date of the stage.
     *
     * @return the actual start date of the stage
     */
    public int getActualStartDate() {
        return this.actualStartDate;
    }


        
    /**
     * Sets the actual start date of the stage.
     *
     * @param actualStartDate the actual start date of the stage
    */
    public void setActualStartDate(int actualStartDate) {
        this.actualStartDate = actualStartDate;
    }


    
    /**
     * Returns the actual end date of the stage.
     *
     * @return the actual end date of the stage
     */
    public int getActualEndDate() {
        return this.actualEndDate;
    }


        
    /**
     * Sets the actual end date of the stage.
     *
     * @param actualEndDate the actual end date of the stage
     */
    public void setActualEndDate(int actualEndDate) {
        this.actualEndDate = actualEndDate;
    }


        
    /**
     * Returns whether the stage has been approved or not.
     *
     * @return true if the stage has been approved, false otherwise
     */
    public boolean isApproved() {
        return this.approved;
    }


    /**
     * Sets whether the stage has been approved or not.
     *
     * @param approved true if the stage has been approved, false otherwise
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    /**
     * Returns the capsules associated with the stage.
     *
     * @return an array of capsules associated with the stage
     */
    public Capsule[] getCapsules() {
        return capsules;
    }


    
    /**
    *
    *Adds a Capsule to the Stage's list of Capsules.
    *@param capsule the Capsule to add
    */
    public void addCapsule(Capsule capsule) {
        capsules[numCapsules] = capsule;
        numCapsules++;
    }

    
    /**
    *
    *Returns a String representation of the Stage object.
    *@return a String containing the name and status of the Stage, as well as its planned and actual start and end dates
    */
    @Override
    public String toString() {
        String status = "Active";
        if (this.approved) {
            status = "Approved";
        } else if (this.actualStartDate > 0 && this.actualEndDate > 0) {
            status = "Completed";
        } else if (this.plannedStartDate > 0 && this.plannedEndDate > 0) {
            status = "Planned";
        }
        return this.name + ": " + status + " (Planned Start Date: " + formatDate(this.plannedStartDate) + ", Planned End Date: " + formatDate(this.plannedEndDate) + ", Actual Start Date: " + formatDate(this.actualStartDate) + ", Actual End Date: " + formatDate(this.actualEndDate) + ")";
    }

    
    /**
    *
    *Formats a given date as a String in the format MM/YYYY.
    *@param date the date to format
    *@return a String representing the formatted date
    */
    private String formatDate(int date) {
        
        if (date == 0) {
            return "";
        } else {
            int month = (date - 1) % 12 + 1;
            int year = (date - 1) / 12 + 2023;
            return String.format("%02d", month) + "/" + year;
        }
    }

    public void addCapsule(SystemController systemController) {
    }

    

    

}