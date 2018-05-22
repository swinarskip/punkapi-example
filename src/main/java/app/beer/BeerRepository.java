package app.beer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, Long> {

    @Query("SELECT DISTINCT beer FROM Beer beer JOIN beer.foodPairing food WHERE LOWER(food) LIKE LOWER(CONCAT('%', :ing_name, '%'))")
    List<Beer> findAllByFoodPairing(@Param("ing_name") String foodPairing);
}
