/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerprojects;

import controllers.CustomerProjectsController;

/**
 *
 * @author mga
 */
public class CustomerProjectsApp {

    public static void run() {        
        System.out.println("Customer Projects App\n=====================\n\n");
        
        CustomerProjectsController customerProjectsController = new CustomerProjectsController();  
        
        customerProjectsController.run();
        
        System.out.println("Thank you for using Customer Projects App. Good bye.\n");        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CustomerProjectsApp customerProjectsApp = new CustomerProjectsApp();
        customerProjectsApp.run();
    }
    
}
