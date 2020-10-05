/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import repositories.Repository;


/**
 *
 * @author mga
 */
public class CustomerProjectsController {
    static char DELIMITER=',';
    private final Repository repository;
    
    public CustomerProjectsController() {

        InputHelper inputHelper = new InputHelper();
        char c = inputHelper.readCharacter("Load an already existing Customers File (Y/N)?");
        if (c == 'Y' || c == 'y') {
            String fileName = inputHelper.readString("Enter filename");
            this.repository = new Repository(fileName);
        }
        else {

            this.repository = new Repository();
        }
    }
    

   
    public void run() {
        boolean finished = false;
        do {
            System.out.println("Customers\n=========");            
            System.out.println(repository);
            char choice = displayCustomerProjectsMenu();
            switch (choice) {
                case 'A': 
                    addProjectToCustomer();
                    break;
                case 'B': 
                    removeProjectFromCustomer();
                    break;                      
                case 'F':
                    InputHelper inputHelper = new InputHelper();
                    String fileName = inputHelper.readString("Enter filename");

                    repository.store(fileName);
                    finished = true;
            }
        } while (!finished);
    }

    private char displayCustomerProjectsMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add a new project");
        System.out.print("\tB. Remove a project");
        System.out.print("\tF. Finish\n");         
        return inputHelper.readCharacter("Enter choice", "ABF");
    }    
    
    private void addProjectToCustomer() {
        InputHelper inputHelper = new InputHelper();
        boolean validCustomerId = false;
        Customer requiredCustomer= null;
        do {
            int customerId = inputHelper.readInt("Enter Customer Id");
            requiredCustomer = repository.getItem(customerId);

            if (requiredCustomer != null) {
                validCustomerId = true;
            }
        } while (!validCustomerId);
        System.out.println("Customer\n========\n" + requiredCustomer);
        String newProject = inputHelper.readString("Enter New Project");
        requiredCustomer.addProjectToCustomer(newProject);            
    }
    
    private void removeProjectFromCustomer() {
        InputHelper inputHelper = new InputHelper();
        boolean validCustomerId = false;
        Customer requiredCustomer=null;
        do {
            int customerId = inputHelper.readInt("Enter Customer Id");
            requiredCustomer = repository.getItem(customerId);

            if (requiredCustomer != null) {
                validCustomerId = true;
            }
        } while (!validCustomerId);
        System.out.println("Customer\n========\n" + requiredCustomer);
        int projectNumber = inputHelper.readInt("Enter Project Number", requiredCustomer.getNoCustomerProjects(), 1);   
        requiredCustomer.removeProjectFromCustomer(projectNumber);
    }
    

    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }
}
