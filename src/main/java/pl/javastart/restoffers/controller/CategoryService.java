package pl.javastart.restoffers.controller;

import org.springframework.stereotype.Service;
import pl.javastart.restoffers.repository.CategoryRepository;
import pl.javastart.restoffers.repository.OfferRepository;

@Service
public class CategoryService {

    private OfferRepository offerRepository;
    private CategoryRepository categoryRepository;

    public CategoryService(OfferRepository offerRepository, CategoryRepository categoryRepository) {

        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;

    }
}
