package model;
import java.util.Calendar;


public class Stage {
    private String name;
    private Calendar plannedStartDate;
    private Calendar plannedEndDate;
    private Calendar realStartDate;
    private Calendar realEndDate;
    private boolean approval;

    public Stage(String name, Calendar plannedStartDate, Calendar plannedEndDate) {
        this.name = name;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.realStartDate = null;
        this.realEndDate = null;
        this.approval = false;
    }

    public String getName() {
        return name;
    }

    public Calendar getPlannedStartDate() {
        return plannedStartDate;
    }

    public Calendar getPlannedEndDate() {
        return plannedEndDate;
    }

    public Calendar getRealStartDate() {
        return realStartDate;
    }

    public void setRealStartDate(Calendar realStartDate) {
        this.realStartDate = realStartDate;
    }

    public Calendar getRealEndDate() {
        return realEndDate;
    }

    public void setRealEndDate(Calendar realEndDate) {
        this.realEndDate = realEndDate;
    }

    public boolean isApproved() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }
}