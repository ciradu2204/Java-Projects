package model;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PlannedProject extends Project{

    private static final char P = 'P';
    int noAllocatedDays;
    Set<String> projectEmployees = new HashSet<>();

    public PlannedProject(){
        super();

    }

    public PlannedProject(String projectId, String projectTitle, Date startDate, int noAllocatedDays, Set<String> projectEmployees) {
        super(projectId, projectTitle, startDate);
        this.noAllocatedDays = noAllocatedDays;
        this.projectEmployees = projectEmployees;
    }



    public Set<String> getProjectEmployees() {
        return projectEmployees;
    }

    public void setProjectEmployees(Set<String> projectEmployees) {
        this.projectEmployees = projectEmployees;
    }

    public int getNoAllocatedDays() {
        return noAllocatedDays;
    }



    public void setNoAllocatedDays(int noAllocatedDays) {
        this.noAllocatedDays = noAllocatedDays;
    }

    @Override
    public String toString() {

            String output = super.toString() + "\nProject E: ";
            for(String projectEmployee: projectEmployees){
                     output +=   projectEmployee ;
                }

               output += "\nallocatedDays: " + this.noAllocatedDays;
                return output;
    }

    @Override
    public String toString(char delimiter) {
        final String QUOTE = "\"";
       final String EOLN = "\n";
        String output = super.toString(delimiter) + delimiter + QUOTE + this.P + QUOTE + delimiter;
        for(String projectEmployee: this.projectEmployees){
              output += QUOTE + projectEmployee + QUOTE + delimiter;

        }

        output+= this.noAllocatedDays;
        output+= EOLN;
        return output;
    }

}
