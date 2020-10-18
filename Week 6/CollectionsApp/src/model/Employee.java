/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;

/**
 *
 * @author mga
 */
public class Employee implements Comparable<Employee>

{
    protected int employeeId;
    protected String employeeName;
    private  EmployeeRoleType employeeRoleType;
    
    private static int numberOfEmployees=0;    

    public Employee()
    {
        this.employeeId = ++numberOfEmployees;
        this.employeeName = null;
        this.employeeRoleType = EmployeeRoleType.DEVELOPER;
    }	
    
    public Employee(String employeeName, EmployeeRoleType employeeRole)
    {
        this.employeeId = ++numberOfEmployees;
        this.employeeName = employeeName;
        this.employeeRoleType= employeeRole;
    }    
	
    public Employee(int employeeId, String employeeName, EmployeeRoleType employeeRole)
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeRoleType = employeeRole;
        numberOfEmployees++;
    }

    public static int getNumberOfEmployees() {
        return numberOfEmployees;
    }    
    
    public int getEmployeeId()
    {
        return this.employeeId;
    }    
    
    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }      
    
    public String getEmployeeName()
    {
        return this.employeeName;
    }     
    
    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public EmployeeRoleType getEmployeeRoleType() {
        return employeeRoleType;
    }

    public  static Comparator<Employee> employeeNameComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {

            String employeeName1 = o1.employeeName;
            String employeeName2 = o2.employeeName;

            //increasing
            return employeeName1.compareTo(employeeName2);

            //decreasing
            //return employeeName2.compareTo(employeeName1);
        }
    };


    @Override
    public int compareTo(Employee o) {
        int employeId = ((Employee) o).getEmployeeId();

        //ascending order
        return this.employeeId - employeId;

        //descending order

      //  return employeId - this.employeId;

    }

    @Override
    public String toString() {
        return  "employee id: " + getEmployeeId() + ", " +
                "employee name: " + getEmployeeName() + ", " +	
                "employee role: " + getEmployeeRoleType();

    }      
}

