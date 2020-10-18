/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author mga
 */
public class CustomerStringController {
    Set<String> names;
    
    public CustomerStringController() {
//        names = new HashSet<>();
        names = new TreeSet<>();
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
        removeElement("Puyol");
        displayElementsToString();
        
        System.out.println("Remove Element");
        System.out.println("--------------");         
        removeElement("Puyol");
        displayElementsToString();
    }

    private void addElements() {
        names.add("Iniesta");
        names.add("Messi");
        names.add("Busquets");
        names.add("Puyol");
        names.add("Pique");
        names.add("Puyol");
    }
    
    private void removeElement(String toBeRemovedElement) {
        if (names.contains(toBeRemovedElement)) {
            boolean result = names.remove(toBeRemovedElement);
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
        System.out.println(names);
    }
    
    private  void displayElementsForEach() {
        System.out.println("for each");
        System.out.println("========");
        for(String s : names)
            System.out.println("name:" + s);
    }
    
    private  void displayElementsIterator() {
        System.out.println("iterator");
        System.out.println("========");
        Iterator it = names.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }    
}
