package vroomvroom.entity;

import javax.persistence.*;

@Entity
@Table(name = "Vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "immatriculation")
    private String immatriculation;
    @Column(name = "modele")
    private String modele;
    @Column(name = "marque")
    private String marque;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Vehicule() {

    }

    public Vehicule(String immatriculation, String modele, String marque, Client client) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.marque = marque;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}