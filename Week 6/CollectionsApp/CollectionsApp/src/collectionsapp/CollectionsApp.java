/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsapp;

import controllers.CustomerObjectsController;
import controllers.CustomerStringController;
import controllers.EmployeeObjectsController;
import model.Employee;

/**
 *
 * @author mga
 */
public class CollectionsApp {

    public static void run() {        
        System.out.println("Customer App\n=============\n\n");
        
//        CustomerStringController customerProjectsController = new CustomerStringController();
        CustomerObjectsController customerProjectsController = new CustomerObjectsController();
        customerProjectsController.run();
//        EmployeeObjectsController employeeObjectsController = new EmployeeObjectsController();
//         employeeObjectsController.run();

        
        System.out.println("Thank you for using Customer App. Good bye.\n");        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CollectionsApp collectionsStarter = new CollectionsApp();
        collectionsStarter.run();
    }
    
}
