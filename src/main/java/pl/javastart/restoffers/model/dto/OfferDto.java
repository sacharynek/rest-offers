package pl.javastart.restoffers.model.dto;

import pl.javastart.restoffers.model.Category;
import pl.javastart.restoffers.model.Offer;

import java.math.BigDecimal;
//Dto - data transfer object
// w większych aplikacjach praktyznie nie zwraca się encji tylko Dto
public class OfferDto {


    private long Id;
    private String title;
    private String description;
    private String imgUrl;
    private BigDecimal price;


    private String category;

    public OfferDto(){}


    public OfferDto(Offer offer) {
        this.Id = offer.getId();
        this.title = offer.getTitle();
        this.description = offer.getDescription();
        this.imgUrl = offer.getImgUrl();
        this.price = offer.getPrice();
        this.category = offer.getCategory().getName();

    }

    public Offer toOffer(){
        Offer output = new Offer();
        output.setId(this.getId());
        output.setTitle(this.getTitle());
        output.setDescription(this.getDescription());
        output.setImgUrl(this.getImgUrl());
        output.setPrice(this.getPrice());

        Category category = new Category();
        category.setName(this.getCategory());
        output.setCategory(category);

        return output;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
