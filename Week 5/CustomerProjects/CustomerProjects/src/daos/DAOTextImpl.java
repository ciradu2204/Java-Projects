/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.AdHocProject;
import model.Customer;
import model.PlannedProject;
import model.Project;
import repositories.Repository;

/**
 *
 * @author mga
 */
public class DAOTextImpl implements DAOInterface {
    
    static final char DELIMITER=',';   

    @Override
    public Repository load(String filename) {
        
        Repository repository = new Repository();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] temp;
            String line = br.readLine();
            while(line!=null){
                temp=line.split(Character.toString(DELIMITER));        
                int customerId = Integer.parseInt(temp[0]);
                String customerName = stripQuotes(temp[1]);
                Customer customer = new Customer(customerId, customerName);
                int noProjects = Integer.parseInt(temp[2]);            
                for (int i=0; i<noProjects; i++) {
                    String project = br.readLine();
                    String[] temp2 = project.split(Character.toString(DELIMITER));
                    String projectId = stripQuotes(temp2[0]);
                    String projectTitle = stripQuotes(temp2[1]);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
                    String startDate = stripQuotes(temp2[2]);
                    Date date = sdf.parse(startDate);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    char projectType = stripQuotes(temp2[3]).charAt(0);

                    if(projectType == 'A'){
                        String projectEmployee = stripQuotes(temp2[4]);
                        customer.addProjectToCustomer(new AdHocProject(projectId, projectTitle, calendar.getTime(), projectEmployee));
                    }else if(projectType == 'P'){
                        Set<String> set = new HashSet<>();
                        int noAllocatedDays = 0;
                        int x =0;

                        while(temp2[4 + x].contains("\"")){
                            set.add(stripQuotes(temp2[4 + x]));
                            x++;
                        }

                        noAllocatedDays = Integer.parseInt(temp2[4 + x]);


                        customer.addProjectToCustomer(new PlannedProject(projectId, projectTitle, calendar.getTime(), noAllocatedDays, set));
                    }

                }
                repository.add(customer);                
                line = br.readLine();                
            }
            br.close();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(DAOTextImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return repository;
    }
    
    @Override
    public void store(String filename, Repository repository) {
        try (PrintWriter output = new PrintWriter(filename)) {
            output.print(repository.toString(DELIMITER));
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOTextImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }
}
