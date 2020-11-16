/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.Repository;

/**
 *
 * @author mga
 */
public class DAOObjImpl implements DAOInterface {

    @Override
    public Repository load(String filename) {
        Repository repository = new Repository();
        try {
            FileInputStream fin = new FileInputStream(filename);
            try (ObjectInputStream ois = new ObjectInputStream(fin)) {
                repository = (Repository) ois.readObject();
            }
        } catch(IOException | ClassNotFoundException ex){
            System.out.println(ex);
            System.exit(0);
        } 
        return repository;
    }
    
    @Override
    public void store(String filename, Repository repository) { 
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(filename));       
            output.writeObject(repository);
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOObjImpl.class.getName())
                  .log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(DAOObjImpl.class.getName())
                      .log(Level.SEVERE, null, ex);
            }
        }         
    }
}
