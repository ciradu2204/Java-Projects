/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import model.Customer;

/**
 *
 * @author mga
 */
public interface RepositoryInterface {

    void add(Customer item);

    Customer getItem(int id);

    List<Customer> getItems();

    void remove(int id);

    void setItems(List<Customer> items);

    void store(String filename);

    String toString();

    String toString(char delimiter);
    
}
