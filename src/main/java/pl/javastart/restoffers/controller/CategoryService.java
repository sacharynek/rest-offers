package pl.javastart.restoffers.controller;

import org.springframework.stereotype.Service;
import pl.javastart.restoffers.repository.CategoryRepository;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
