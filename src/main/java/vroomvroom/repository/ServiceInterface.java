package vroomvroom.repository;

import vroomvroom.entity.Client;

import java.util.List;

public interface ServiceInterface {
    Client findById(Integer id);
    List<Client> findAll();
    Client modifClient(Integer id, Client c);

    void addClient(Client c);

    Client findByNameAndFirstname(String name, String Firstname);

    void delClient(Integer id);

}
