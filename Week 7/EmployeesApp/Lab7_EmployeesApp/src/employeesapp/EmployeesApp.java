/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesapp;

import controllers.EmployeesController;

/**
 *
 * @author mga
 */
public class EmployeesApp {

    public static void run() {        
        System.out.println("Employees App\n=============\n\n");
        
        EmployeesController employeesController = new EmployeesController();  
        
        employeesController.run();
        
        System.out.println("Thank you for using Employees App. Good bye.\n");        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmployeesApp employeesApp = new EmployeesApp();
        employeesApp.run();
    }
    
}
