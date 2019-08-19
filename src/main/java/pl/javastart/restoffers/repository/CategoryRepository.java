package pl.javastart.restoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.restoffers.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {


    Category findAllByName(String name);
}
