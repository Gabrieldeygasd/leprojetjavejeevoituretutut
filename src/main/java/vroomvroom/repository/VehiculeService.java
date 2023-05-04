package vroomvroom.repository;

import vroomvroom.entity.Client;
import vroomvroom.entity.Vehicule;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VehiculeService {
    private EntityManager entityManager;

    public VehiculeService() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vroomvroom");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void addVehicule(Vehicule vehicule) {
        entityManager.getTransaction().begin();
        entityManager.persist(vehicule);
        entityManager.getTransaction().commit();
    }

    public Vehicule getVehiculeById(long id) {
        return entityManager.find(Vehicule.class, id);
    }

    public List<Vehicule> getAllVehicules() {
        Query query = entityManager.createQuery("SELECT v FROM Vehicule v");
        return query.getResultList();
    }

    public List<Vehicule> getVehiculesByClient(Client client) {
        Query query = entityManager.createQuery("SELECT v FROM Vehicule v WHERE v.client = :client");
        query.setParameter("client", client);
        return query.getResultList();
    }

    public void updateVehicule(Vehicule vehicule) {
        entityManager.getTransaction().begin();
        entityManager.merge(vehicule);
        entityManager.getTransaction().commit();
    }

    public void deleteVehicule(Vehicule vehicule) {
        entityManager.getTransaction().begin();
        entityManager.remove(vehicule);
        entityManager.getTransaction().commit();
    }
}