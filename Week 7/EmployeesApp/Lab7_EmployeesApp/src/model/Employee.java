/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Predicate;
import repositories.RepositoryObject;

/**
 *
 * @author mga
 */
public class Employee extends RepositoryObject implements Comparable<Employee>, Serializable {
    private final int id;
    private String employeeName;
    private String employeeRole;
    private int lengthOfService;   
    
    private static int numberOfEmployees=0;    

    public Employee()
    {
        this.id = ++numberOfEmployees;
        this.employeeName = null;
        this.employeeRole = null;
        this.lengthOfService = 0;
    }	
	
    public Employee(int id, String employeeName, String employeeRole, int lengthOfService)
    {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
        this.lengthOfService = lengthOfService;        
        numberOfEmployees++;
    }
    
    public Employee(String employeeName, String employeeRole)
    {
        this.id = ++numberOfEmployees;
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
        this.lengthOfService = 0;        
    }        
    
    public static int getNumberOfEmployees() {
        return numberOfEmployees;
    }    
    
    @Override
    public int getId()
    {
        return this.id;
    }         
    
    public String getEmployeeName()
    {
        return this.employeeName;
    }     
    
    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }     
    
    public String getEmployeeRole()
    {
        return this.employeeRole;
    }

    public void setEmployeeRole(String employeeRole)
    {
        this.employeeRole = employeeRole;
    }  
    
    public int getLengthOfService()
    {
        return this.lengthOfService;
    }

    public void setLengthOfService(int lengthOfService)
    {
        this.lengthOfService = lengthOfService;
    }     
    
    @Override
    public int hashCode() {
        return getId() * 31 + getEmployeeName().hashCode() * 31 + getEmployeeRole().hashCode() * 31 + getLengthOfService() * 31;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Employee) {
            Employee e = (Employee)o;
            return  e.getId() == getId() &&
                    e.getEmployeeName() == getEmployeeName() &&
                    e.getLengthOfService() == getLengthOfService() &&                    
                    e.getEmployeeRole().equals(getEmployeeRole());
        } else {
            return false;
        }
    }
    
    public static Comparator<Employee> EmployeeNameComparator 
                      = new Comparator<Employee>() {

        @Override
        public int compare(Employee emp1, Employee emp2) {

          String empName1 = emp1.getEmployeeName();
          String empName2 = emp2.getEmployeeName();

          //ascending order
          return empName1.compareTo(empName2);

          //descending order
          //return empName2.compareTo(empName1);
        }

    };      
    
    @Override
    public int compareTo(Employee compareEmployee) {
	
		int empId = ((Employee) compareEmployee).getId(); 
		
		//ascending order
		return this.id - empId;
		
		//descending order
		//return empId - this.id;
		
    }   
    
    @Override
    public String toString() {
        return  "employee id: " + getId() + ", " +
                "employee name: " + getEmployeeName() + ", " +	
                "employee role: " + getEmployeeRole() + ", " +	
                "length of service: " + getLengthOfService();        
    }      

    public interface CheckEmployee {
        boolean test(Employee e);
    }
    
    class CheckEmployeeForRoleAndService implements CheckEmployee {
        String role;
        int service;
        
        CheckEmployeeForRoleAndService(String role, int service) {
            this.role = role;
            this.service = service;
        }
        
        @Override
        public boolean test(Employee e) {
            return e.getEmployeeRole().equals(this.role) && e.getLengthOfService() >= this.service;
        }
    }
    
    public boolean matchRoleAndService(String role, int service) {
     //  CheckEmployeeForRoleAndService tester = new CheckEmployeeForRoleAndService(role, service);
    //   return tester.test(this);
        return new CheckEmployee() {
          @Override
        public boolean test(Employee e) { return e.getEmployeeRole().equals(role) && e.getLengthOfService() >= service;
           }
     }.test(this);
    } 
    
    //public boolean match(CheckEmployee tester) {
    public boolean match(Predicate<Employee> tester) {
        return tester.test(this);
    }
        
}
