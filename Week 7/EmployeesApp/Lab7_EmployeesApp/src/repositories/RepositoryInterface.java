/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;

/**
 *
 * @author mga
 */
public interface RepositoryInterface<T extends RepositoryObject> {

    void add(T item);

    T getItem(int id);

    List<T> getItems();

    void remove(int id);

    void setItems(List<T> items);

    void store(String filename);

    String toString();
    
}
