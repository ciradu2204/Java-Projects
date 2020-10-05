package daos;

import repositories.Repository;

import java.io.*;

public class DAOObjectImpl implements DAOInterface{

    Repository repository;
    @Override
    public Repository load(String filename) {
        try {
            FileInputStream inputStream = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            repository = (Repository) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
     return repository;
    }

    @Override
    public void store(String filename, Repository repository) {

        try {
            FileOutputStream output = new FileOutputStream(filename);
            ObjectOutputStream oos  = new ObjectOutputStream(output);
            oos.writeObject(repository);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
