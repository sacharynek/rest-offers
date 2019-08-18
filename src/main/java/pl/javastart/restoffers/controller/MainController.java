package pl.javastart.restoffers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.javastart.restoffers.model.Offer;
import pl.javastart.restoffers.model.dto.OfferDto;

import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    // sa dwie opcje na circuall json -> albo dto, albo ignoruj pole
    //nie używa się bezpośrednio repository tylko robi się klase service !!!!  controller ma byc czysty a całe przetwarzanie ma być w serwisie -> patrz sellegro


    OfferService offerService;


    CategoryService categoryService;

    public MainController(OfferService offerService, CategoryService categoryService) {
        this.offerService = offerService;
        this.categoryService = categoryService;
    }

    //@component //@repository
    @ResponseBody
    @GetMapping("/api/offers")
    public List<OfferDto> getOffers(@RequestParam(value = "title", required = false) String titleSearch) {

        return offerService.findAllOffers(titleSearch);
    }

    @GetMapping("/")
    public String getMainPage() {
        return "home.html";
    }

    @ResponseBody
    @GetMapping("/api/offers/count")
    public int getOfferCount() {
        return offerService.getOfferCount();
    }

    @ResponseBody
    @GetMapping("/api/categories/names")
    public Set<String> getCategories() {
        return offerService.getCategories();
    }


    @PostMapping("/api/offers")
    public void addOffer(OfferDto offerDto) {
        Offer offer = offerDto.toOffer();

        offerService.saveOffer(offer);
    }


}
