/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import model.Employee;
import repositories.Repository;

/**
 *
 * @author mga
 */
public class EmployeesController {
    private final Repository<Employee> repository;
    
    public EmployeesController() {
        InputHelper inputHelper = new InputHelper();
        char c = inputHelper.readCharacter("Load an already existing Employees File (Y/N)?");
        if (c == 'Y' || c == 'y') {
            String fileName = inputHelper.readString("Enter filename");
            this.repository = new Repository<>(fileName);
        }
        else {
            this.repository = new Repository<>();
            addEmployees();
        }
    }
   
    public void run() {
        boolean finished = false;
        String role="Developer";
        int service = 3;
        
        do {
            char choice = displayEmployeesMenu();
            switch (choice) {
                case 'A': 
                    listEmployees();
                    break;
                case 'B': 
                    listEmployeesInReverse();
                    break; 
                case 'C': 
                    listEmployeesWithRole(role);
                    break; 
                case 'D': 
                    listEmployeesWithRoleAndService(role, service);
                    break;
                case 'E': 
                    listEmployeesWithSearchCriteria(role, service);
                    break;
                case 'F': 
                    listEmployeesUsingLambdaExpression(role, service);
                    break; 
                case 'G': 
                    listEmployeesWithPredicate(role, service);
                    break;
                case 'H': 
                    processEmployees(role, service);
                    break;
                case 'I': 
                    processEmployeesWithFunction(role, service);
                    break;  
                case 'J': 
                    processElementsWithFunction(repository.getItems(),
                       (Employee e) -> e.getEmployeeRole().equals(role) && e.getLengthOfService() >= service,
                          e -> e.getEmployeeName(),
                            str -> System.out.println(str));
                    break;
                case 'K': 
                    repository.getItems()
                                .stream()
                                .filter(e -> e.getEmployeeRole().equals(role) && e.getLengthOfService() >= service)
                                .map(e -> e.getEmployeeName())
                                .forEach(str -> System.out.println(str));         
                    break;
                case 'Z' :
                 listEmployeesWithYearsService(service);
                 break;
                case 'Q':
                    InputHelper inputHelper = new InputHelper();                    
                    String fileName = inputHelper.readString("Enter filename"); 
                    repository.store(fileName);
                    finished = true;


            }
        } while (!finished);
    }

    private void addEmployees() {
        Employee emp1 = new Employee(1,"Sergi Busquets","Project Leader",5);
        repository.add(emp1);
        Employee emp2 = new Employee(2,"Sergi Roberto","Developer",2);
        repository.add(emp2);        
        Employee emp3 = new Employee(3,"Edgar Davids","Tester",0);
        repository.add(emp3);
        Employee emp4 = new Employee(4,"Dani Alves","Developer",9);
        repository.add(emp4);        
        Employee emp5 = new Employee(5,"Jordi Alba","Developer",4);
        repository.add(emp5);        
        Employee emp6 = new Employee(6,"Ivan Rakitic","Developer",1);
        repository.add(emp6);        
        Employee emp7 = new Employee(7,"Luis Suarez","Tester",2);
        repository.add(emp7);        
    }
    
    private char displayEmployeesMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. List Employees (Iterator)");
        System.out.print("\tB. List Employees In Reverse (Iterator)");
        System.out.print("\tC. List Employees With Role");
        System.out.print("\nD. List Employees With Role And Service");
        System.out.print("\tE. List Employees With Search Criteria");
        System.out.print("\tF. List Employees Using Lambda Expressions"); 
        System.out.print("\nG. List Employees Using Predicate");
        System.out.print("\tH. Process Employees");
        System.out.print("\tI. Process Employees With Function");
        System.out.print("\nJ. Process Elements With Function");
        System.out.print("\tK. Process Elements With Aggregate Operations");
        System.out.print("\tZ. List Employees using Service");
        System.out.print("\tQ. Quit\n");         
        return inputHelper.readCharacter("Enter choice", "ABCDEFGHIJKZQ");
    }    
    
    private void listEmployees() {
        System.out.format("\033[31m%s\033[0m%n", "Employees");
        System.out.format("\033[31m%s\033[0m%n", "=========");
        Iterator it = repository.getItems().listIterator();
        while (it.hasNext()) {
            Employee e = (Employee) it.next();
            System.out.println(e);
        }
    }
    
    private void listEmployeesInReverse() {        
        System.out.format("\033[31m%s\033[0m%n", "Employees");
        System.out.format("\033[31m%s\033[0m%n", "=========");
        ListIterator it = repository.getItems().listIterator(repository.getItems().size());
        while (it.hasPrevious()) {
            Employee e = (Employee) it.previous();            
            System.out.println(e);
        }    	
    }

    private void listEmployeesWithYearsService(int service){
        System.out.format("\033[31m%s\033[0m%n", "Employees: " + "Service>=" + Integer.toString(service));
        System.out.format("\033[31m%s\033[0m%n", "=========");

        Iterator it = repository.getItems().listIterator();
        while (it.hasNext()){
            Employee e  = (Employee) it.next();
             if(e.getLengthOfService()>= service){
                 System.out.println(e);
             }
        }


    }
    
    private void listEmployeesWithRole(String role) {        
        System.out.format("\033[31m%s\033[0m%n", "Employees: " + role);
        System.out.format("\033[31m%s\033[0m%n", "=========");
        Iterator it = repository.getItems().listIterator();
        while (it.hasNext()) {
            Employee e = (Employee) it.next();
            if (e.getEmployeeRole().equals(role))
                System.out.println(e);
        }    	
    }    
      
    
    private void listEmployeesWithRoleAndService(String role, int service) {        
        System.out.format("\033[31m%s\033[0m%n", "Employees: " + role + ", Service >=: " + Integer.toString(service));
        System.out.format("\033[31m%s\033[0m%n", "=========");
        Iterator it = repository.getItems().listIterator();
        while (it.hasNext()) {
            Employee e = (Employee) it.next();
            if (e.getEmployeeRole().equals(role) && e.getLengthOfService() >= service)
                System.out.println(e);
        }    	
    }    
    
    private void listEmployeesWithSearchCriteria(String role, int service) {
        System.out.format("\033[31m%s\033[0m%n", "Employees: ");
        System.out.format("\033[31m%s\033[0m%n", "=========");
        
        Iterator it = repository.getItems().listIterator();
        while (it.hasNext()) {
            Employee e = (Employee) it.next();
            if (e.matchRoleAndService(role, service))
                System.out.println(e);
        }       
    }  
    
    private void listEmployeesUsingLambdaExpression(String role, int service) {
        System.out.format("\033[31m%s\033[0m%n", "Employees: ");
        System.out.format("\033[31m%s\033[0m%n", "=========");
        
        Iterator it = repository.getItems().listIterator();
        while (it.hasNext()) {
            Employee e = (Employee) it.next();
            if (e.match(emp -> emp.getEmployeeRole().equals(role) && emp.getLengthOfService() >= service))
                System.out.println(e);
        }       
    }    
     
    private void listEmployeesWithPredicate(String role, int service) {
        System.out.format("\033[31m%s\033[0m%n", "Employees: ");
        System.out.format("\033[31m%s\033[0m%n", "=========");
        
        Iterator it = repository.getItems().listIterator();
        while (it.hasNext()) {
            Employee e = (Employee) it.next();
            if (e.match(emp -> emp.getEmployeeRole().equals(role) && emp.getLengthOfService() >= service))
                System.out.println(e);
        }       
    } 
    
    private void processEmployees(String role, int service) {
        System.out.format("\033[31m%s\033[0m%n", "Employees: ");
        System.out.format("\033[31m%s\033[0m%n", "=========");
        
        Iterator it = repository.getItems().listIterator();
        while (it.hasNext()) {
            Employee e = (Employee) it.next();
            if (e.match(emp -> emp.getEmployeeRole().equals(role) && emp.getLengthOfService() >= service))
                processEmployee(e, emp -> System.out.println(emp));
        }       
    }
    
    private void processEmployee(Employee employee, Consumer<Employee> process) {
        process.accept(employee);
    }
    
    private void processEmployeesWithFunction(String role, int service) {
        System.out.format("\033[31m%s\033[0m%n", "Employees: ");
        System.out.format("\033[31m%s\033[0m%n", "=========");
        
        Iterator it = repository.getItems().listIterator();
        while (it.hasNext()) {
            Employee e = (Employee) it.next();
            if (e.match(emp -> emp.getEmployeeRole().equals(role) && emp.getLengthOfService() >= service)) {
                processEmployeeWithFunction(e, emp -> emp.getEmployeeName(), str -> System.out.println(str));
            } 
        }       
    }



    private void processEmployeeWithFunction(Employee employee, Function<Employee, String> mapper, Consumer<String> process) {
        String data = mapper.apply(employee);
        process.accept(data);
    }
    
    private <X, Y> void processElementsWithFunction(Iterable<X> source, Predicate<X> tester, 
                                                    Function<X, Y> mapper, Consumer<Y> process) {
        
        for (X x : source) {
            if (tester.test(x)) {
                Y data = mapper.apply(x);
                process.accept(data);
            } 
        }       
    }      
    
}
