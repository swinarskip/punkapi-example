package app.beer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class BeerController {

    private static final Logger logger = LoggerFactory.getLogger(BeerController.class);
    @Autowired
    private BeerService beerService;

    @GetMapping("/")
    public Iterable<Beer> index() {
        return beerService.getAll();
    }

    @GetMapping("/foodpairings/search/{phrase}")
    public List<Beer> get(@PathVariable String phrase) {
        logger.info("Getting employee with id " + phrase);
        List<Beer> beers = beerService.getAllByPhrase(phrase);
        return beers;
    }

    @PostMapping
//    @PreAuthorize("hasRole('ROLE_USER')")
    public String beers(Beer beer) {
        // Validation is omitted for simplicity
        beerService.create(Collections.singletonList(beer));
        return "Beer has been added.";
    }
}