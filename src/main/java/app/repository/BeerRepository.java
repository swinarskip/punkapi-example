package app.repository;

import app.entity.Beer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BeerRepository extends CrudRepository<Beer, Integer> {

    @Query("SELECT DISTINCT b FROM Beer b JOIN b.foodPairing fp WHERE LOWER(fp) LIKE LOWER(CONCAT('%', :foodPairing, '%'))")
    Iterable<Beer> findAllByFoodPairing(@Param("foodPairing") String foodPairing);
}