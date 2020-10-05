package daos;

import repositories.Repository;

public interface DAOInterface {

    public Repository load(String filename);

    public void store(String filename, Repository repository);
}
