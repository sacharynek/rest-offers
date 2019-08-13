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
    private long Id;
    private String Name;
    private String Description;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Offer> offers;

    public Category() {
    }

    public Category(String name, String description, List<Offer> offers) {
        Name = name;
        Description = description;
        this.offers = offers;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
