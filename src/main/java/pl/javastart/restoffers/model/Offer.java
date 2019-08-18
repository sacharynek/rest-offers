package pl.javastart.restoffers.model;

import pl.javastart.restoffers.model.dto.OfferDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Offer {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long Id;
    private String Title;
    private String Description;
    private String imgUrl;
    private BigDecimal price;

    @ManyToOne()
    private Category category;

    public Offer() {
    }

    public Offer(String title, String description, String imgUrl, BigDecimal price, Category category) {
        Title = title;
        Description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public OfferDto toDto(){
        return new OfferDto(this);
    }
}
