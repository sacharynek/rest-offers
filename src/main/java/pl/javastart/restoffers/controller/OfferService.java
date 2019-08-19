package pl.javastart.restoffers.controller;

import org.springframework.stereotype.Service;
import pl.javastart.restoffers.model.Category;
import pl.javastart.restoffers.model.Offer;
import pl.javastart.restoffers.model.dto.OfferDto;
import pl.javastart.restoffers.repository.CategoryRepository;
import pl.javastart.restoffers.repository.OfferRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private OfferRepository offerRepository;
    private CategoryRepository categoryRepository;

    public OfferService(OfferRepository offerRepository, CategoryRepository categoryRepository) {

        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;

    }

    List<OfferDto> findAllOffers(String titleSearch) {

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
        return categoryRepository
                .findAll()
                .stream()
                .map(a -> a.getName())
                .collect(Collectors.toSet());

    }

    public OfferDto insert(OfferDto offerDto) {

        Offer offer = toOffer(offerDto);

        if (null == offer.getId()) {
            throw new IllegalArgumentException("Id should not be present when adding");
        } else {
            Offer savedOffer = offerRepository.save(offer);
            return savedOffer.toDto();
        }
    }

    public Offer toOffer(OfferDto offerDto) {
        Offer output = new Offer();
        output.setId(offerDto.getId());
        output.setTitle(offerDto.getTitle());
        output.setDescription(offerDto.getDescription());
        output.setImgUrl(offerDto.getImgUrl());
        output.setPrice(offerDto.getPrice());

        Category category = categoryRepository.findAllByName(offerDto.getCategory());

        output.setCategory(category);

        return output;
    }
}
