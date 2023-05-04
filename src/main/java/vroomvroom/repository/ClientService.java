package vroomvroom.repository;

import vroomvroom.entity.Client;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements ServiceInterface {

    EntityManagerFactory factory;
    EntityManager manager;

    public ClientService() {
       this.factory = Persistence.createEntityManagerFactory("UserDb");
       this.manager = factory.createEntityManager();
    }
    @Override
    public Client findById(Integer id) {
        Client c = new Client();
        try {
            c = this.manager.find(Client.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }

    @Override
    public List<Client> findAll() {
        List<Client> personnes = new ArrayList<Client>();
        try {
            Query query = this.manager.createQuery("select c from Client c", Client.class);
            List clients = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personnes;
    }

    @Override
    public Client modifClient(Integer id, Client c) {
        Client old = this.manager.find(Client.class, id);
        this.manager.getTransaction().begin();
        old.setLastName(c.getLastName());
        old.setLastName(c.getFirstName());
        old.setEmail(c.getEmail());
        old.setAddress(c.getAddress());
        this.manager.getTransaction().commit();
        this.manager.close();
        this.factory.close();
        return null;
    }

    @Override
    public void addClient(Client c) {
        Client doublon = this.findByNameAndFirstname(c.getLastName(), c.getFirstName());
        if (doublon != null) {
            return;
        } else {

            try {
                this.manager.getTransaction().begin();
                this.manager.persist(c);
                this.manager.getTransaction().commit();
                this.manager.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Client findByNameAndFirstname(String firstName, String lastName) {
        Client c = new Client();
        try {
            Query query = this.manager.createQuery("select c from Client c where lastName = :nom and firstName = :prenom", Client.class);
            query.setParameter("nom", lastName);
            query.setParameter("prenom", firstName);
            c = (Client) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public void delClient(Integer id) {
        Client p = this.findById(id);
        try {
            this.manager.getTransaction().begin();
            this.manager.remove(p);
            this.manager.getTransaction().commit();
            this.manager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
