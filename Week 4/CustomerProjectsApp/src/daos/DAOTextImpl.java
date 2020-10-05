package daos;

import model.Customer;
import repositories.Repository;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOTextImpl implements DAOInterface {

    static final char DELIMITER = ',';

    public DAOTextImpl() {
        super();
    }

    @Override
    public Repository load(String filename) {
        Repository repository = new Repository();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] temp;
            String line = br.readLine();
            while(line!=null){
                temp=line.split(Character.toString(DELIMITER));
                int customerId = Integer.parseInt(temp[0]);
                String customerName = stripQuotes(temp[1]);
                Customer customer = new Customer(customerId, customerName);
                int noProjects = Integer.parseInt(temp[2]);
                for (int i=0; i<noProjects; i++) {
                    String project = stripQuotes(temp[i+3]);
                    customer.addProjectToCustomer(project);
                }
                repository.add(customer);
                line = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }


        return repository;
    }

    @Override
    public void store(String filename, Repository repository) {

        try (PrintWriter output = new PrintWriter(filename)){
            output.print(repository.toString(DELIMITER));
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }
}
