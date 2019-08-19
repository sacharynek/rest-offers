package pl.javastart.restoffers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Offer> offers;

    public Category() {
    }

    public Category(String name, String description, List<Offer> offers) {
        this.name = name;
        this.description = description;
        this.offers = offers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
