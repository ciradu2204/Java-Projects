/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.*;

import model.Customer;
import model.CustomerType;

/**
 *
 * @author mga
 */
public class CustomerObjectsController {
    //Set<Customer> customers;
    List<Customer> customers;
    
    public CustomerObjectsController() {
        //customers = new HashSet<>();
       // customers = new TreeSet<>();
        customers = new LinkedList<>();
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
        Customer c = new Customer("Puyol", "La Pobla de Segur", "charlie@barca.com", CustomerType.EXTERNAL_ACCOUNT);
        System.out.println("Element to be removed: " + c);
        c.setCustomerId(4);
        System.out.println("Element to be removed: " + c);        
        removeElement(c);
        displayElementsForEach();
        
        System.out.println("Sort By Name");
        System.out.println("------------");
        Set<Customer> newSet = new TreeSet(Customer.CustomerNameComparator);
        newSet.addAll(customers);
        System.out.println(newSet);

        System.out.println("Index Of");
        System.out.println("--------");
        System.out.println(c);
        int index = customers.indexOf(c);
        System.out.println("Index: " + index);

        System.out.println("Last Index Of");
        System.out.println("-------------");
        System.out.println(c);
        index = customers.lastIndexOf(c);
        System.out.println("Index: " + index);


        System.out.println("Sort By Id");
        System.out.println("----------");
        Collections.sort(customers);
         displayElements(customers);

        System.out.println("Sort By Name");
        System.out.println("------------");
        customers.sort(Customer.CustomerNameComparator);
        displayElements(customers);

        System.out.println("Sort By Address");
        System.out.println("----------------");
        customers.sort(Customer.CustomerAddressComparator);
        displayElements(customers);

        System.out.println("Sort By Type");
        System.out.println("----------------");
        customers.sort(Customer.typeComparator);
        displayElements(customers);


    }

    private void displayElements(List<Customer> customers) {

        for(Customer customer: customers){
            System.out.println(customer);
        }
    }

    private void addElements() {     
        customers.add(new Customer("Iniesta", "Fuentealbilla", "andy@barca.com", CustomerType.INTERNAL_ACCOUNT));
        customers.add(new Customer("Messi", "Rosario", "lionel@barca.com", CustomerType.INTERNAL_ACCOUNT));
        customers.add(new Customer("Busquets", "Sabadell", "sergi@barca.com", CustomerType.EXTERNAL_ACCOUNT));
        customers.add(new Customer("Puyol", "La Pobla de Segur", "charlie@barca.com", CustomerType.EXTERNAL_ACCOUNT));
        customers.add(new Customer("Pique", "Barcelona", "gerard@barca.com", CustomerType.EXTERNAL_NOACCOUNT));
        customers.add(new Customer("Puyol", "La Pobla de Segur", "charlie@barca.com", CustomerType.EXTERNAL_ACCOUNT));
        Customer c = new Customer("Puyol", "La Pobla de Segur",
                "charlie@barca.com", CustomerType.EXTERNAL_ACCOUNT);
         customers.add(0,c);
    }
    
    private void removeElement(Customer toBeRemovedElement) {       
        if (customers.contains(toBeRemovedElement)) {
            boolean result = customers.remove(toBeRemovedElement);
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
        System.out.println(customers);
    }
    
    private  void displayElementsForEach() {
        System.out.println("for each");
        System.out.println("========");
        for(Customer c : customers)
            System.out.println("customer:" + c);
    }
    
    private  void displayElementsIterator() {
        System.out.println("iterator");
        System.out.println("========");
        Iterator it = customers.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
