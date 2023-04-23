package model;



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

    public Stage(String name) {
        this(name, false);
    }


    public String getName() {
        return this.name;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getPlannedStartDate() {
        return this.plannedStartDate;
    }

    public void setPlannedStartDate(int plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public int getPlannedEndDate() {
        return this.plannedEndDate;
    }

    public void setPlannedEndDate(int plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public int getActualStartDate() {
        return this.actualStartDate;
    }

    public void setActualStartDate(int actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public int getActualEndDate() {
        return this.actualEndDate;
    }

    public void setActualEndDate(int actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public boolean isApproved() {
        return this.approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Capsule[] getCapsules() {
        return capsules;
    }

    public void addCapsule(Capsule capsule) {
        capsules[numCapsules] = capsule;
        numCapsules++;
    }

    

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