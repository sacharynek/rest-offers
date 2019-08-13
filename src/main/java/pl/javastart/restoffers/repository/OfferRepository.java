package pl.javastart.restoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.restoffers.model.Offer;

public interface OfferRepository extends JpaRepository<Offer,Long> {

}
