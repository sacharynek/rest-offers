package pl.javastart.restoffers.controller;

import org.springframework.stereotype.Service;
import pl.javastart.restoffers.model.Offer;
import pl.javastart.restoffers.model.dto.OfferDto;
import pl.javastart.restoffers.repository.OfferRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    List<OfferDto> findAllOffers(String titleSearch){

        System.out.println(titleSearch);

        if (titleSearch == null) {
            return this.findAll();
        } else {
            return this.findAll(titleSearch);
        }
    }


    private List<OfferDto> findAll() {
        return offerRepository.findAll().stream().map(Offer::toDto).collect(Collectors.toList());
    }

    int getOfferCount() {
        return offerRepository.findAll().size();
    }

    private List<OfferDto> findAll(String titleSearch) {
        return offerRepository
                .findAll()
                .stream()
                .filter(a -> a.getTitle().toLowerCase().contains(titleSearch.toLowerCase()))
                .map(Offer::toDto)
                .collect(Collectors.toList());
    }

    Set<String> getCategories() {
        return offerRepository
                .findAll()
                .stream()
                .map(a -> a.getCategory().getName())
                .collect(Collectors.toSet());
    }

    void saveOffer(Offer offer){
        offerRepository.save(offer);
    }
}
