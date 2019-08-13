package pl.javastart.restoffers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.javastart.restoffers.model.Category;
import pl.javastart.restoffers.model.Offer;
import pl.javastart.restoffers.repository.CategoryRepository;
import pl.javastart.restoffers.repository.OfferRepository;

import java.util.List;

@Controller
public class MainController {
// sa dwie opcje na circuall json -> albo dto, albo ignoruj pole
    private OfferRepository offerRepository;
    private CategoryRepository categoryRepository;

    public MainController(OfferRepository offerRepository, CategoryRepository categoryRepository){
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
    }

    @ResponseBody
    @GetMapping("/api/offers")
    public List<Offer> getOffers(){
        return offerRepository.findAll();
    }

    @GetMapping("/")
    public String getMainPage(){
        return "home.html";
    }



}
