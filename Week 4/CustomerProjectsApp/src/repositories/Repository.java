/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import  java.util.LinkedList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import controllers.CustomerProjectsController;
import daos.DAOTextImpl;
import model.Customer;

/**
 *
 * @author mga
 */
public class Repository {
    protected List<Customer> items;
    static char DELIMITER=',';


    public Repository() {

        this.items = new LinkedList<>();
    }
    
    public Repository(List<Customer> items) {        
        this.items = items;
    }
    
    public Repository(String filename) {
        this();

        DAOTextImpl dao = new DAOTextImpl();
        this.items = dao.load(filename).getItems();
         
    }
    
    public List<Customer> getItems() {        
        return this.items;
    }
    
    public void setItems(List<Customer> items) {        
        this.items = items;
    }
    
    public void add(Customer item) {
        this.items.add(item);
    }
       
    public void remove(int id) {
        Predicate<Customer> customerPredicate = c->c.getCustomerId() == id;       
        this.items.removeIf(customerPredicate);
    }
    
    public Customer getItem(int id) {
        for (Customer item:this.items) {
            if (item.getCustomerId() == id)
                return item;
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "\nCustomers: " + this.items;
    }
    
    public String toString(char delimiter) {
        String output = "";
        for (Customer item: this.items) {
            output += item.toString(delimiter);
        }
        return output;
    }
    
    public void store(String filename) {

        DAOTextImpl dao = new DAOTextImpl();
        dao.store(filename, this);
    }    
    
    protected String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }
}
