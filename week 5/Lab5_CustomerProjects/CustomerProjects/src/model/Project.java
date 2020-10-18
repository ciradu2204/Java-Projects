package model;

import java.util.Calendar;
import java.util.Date;

public abstract class Project {
    private String projectId;
    private String projectTitle;
    private Date startDate;



    public Project(String projectId, String projectTitle, Date startDate){

        this.projectId = projectId;
        this.projectTitle = projectTitle;
        this.startDate = startDate;

    }

    public Project() {

    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }




    @Override
    public String toString() {
        return "\nProject Id: " + this.projectId +
                "\nProject Title: " + this.projectTitle +
                "\nStartDate: " + this.startDate;
    }

    public String toString(char delimiter) {
        final String QUOTE = "\"";
        final String EOLN = "\n";
        String output =  QUOTE + this.projectId + QUOTE + delimiter +
                QUOTE + this.projectTitle + QUOTE + delimiter + QUOTE +
                this.startDate + QUOTE;

        return output;
    }

}
