package controllers;

import model.Customer;
import model.CustomerType;
import model.Employee;
import model.EmployeeRoleType;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeObjectsController {
    Set<Employee> employees;

    public EmployeeObjectsController(){
        employees = new TreeSet<>();
    }

    public void run() {
        System.out.println("Add Elements");
        System.out.println("------------");
        addElements();
        displayElementsToString();
        displayElementsForEach();
        displayElementsIterator();

        System.out.println("Remove Element");
        System.out.println("--------------");
        Employee c = new Employee("Raissa", EmployeeRoleType.PROJECT_LEADER);
        System.out.println("Element to be removed: " + c);
        c.setEmployeeId(4);
        removeElement(c);
        displayElementsForEach();

        System.out.println("Sort By Name");
        System.out.println("------------");
        Set<Employee> newSet = new TreeSet(Employee.employeeNameComparator);
        newSet.addAll(employees);
        System.out.println(newSet);
    }

    private void addElements() {
        employees.add(new Employee("Celine", EmployeeRoleType.DEVELOPER));
        employees.add(new Employee("Eva", EmployeeRoleType.ANALYST));
        employees.add(new Employee("Raissa", EmployeeRoleType.PROJECT_LEADER));
        employees.add(new Employee("Mulisa", EmployeeRoleType.Tester));
    }

    private void removeElement(Employee toBeRemovedElement) {
        if (employees.contains(toBeRemovedElement)) {
            boolean result = employees.remove(toBeRemovedElement);
            if (result)
                System.out.println("removed");
            else
                System.out.println("not present");
        }
        else
            System.out.println("not present");
    }

    private  void displayElementsToString() {
        System.out.println("toString");
        System.out.println("========");
        System.out.println(employees);
    }

    private  void displayElementsForEach() {
        System.out.println("for each");
        System.out.println("========");
        for(Employee c : employees )
            System.out.println("customer:" + c);
    }

    private  void displayElementsIterator() {
        System.out.println("iterator");
        System.out.println("========");
        Iterator it = employees.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }

}
