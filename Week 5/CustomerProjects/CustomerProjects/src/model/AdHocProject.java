package model;

import java.util.Date;

public class AdHocProject extends Project{
    private static final char A = 'A';
    String projectEmployee;

    public AdHocProject(String projectId, String projectTitle, Date startDate, String projectEmployee) {
        super(projectId, projectTitle, startDate);
        this.projectEmployee = projectEmployee;
    }

    public AdHocProject(){

    }

    public String getProjectEmployee() {
        return projectEmployee;
    }

    public void setProjectEmployee(String projectEmployee) {
        this.projectEmployee = projectEmployee;
    }

    @Override
    public String toString() {

       return  super.toString() + "\nProject E: " + this.projectEmployee;

    }

    @Override
    public String toString(char delimiter) {
          final String QUOTE = "\"";
          final String EOLN = "\n";
          String output = super.toString(delimiter) + 
                  delimiter + QUOTE + this.A + QUOTE +
                  delimiter + QUOTE + this.projectEmployee + QUOTE;
          output += EOLN;
        return output;
    }



}
