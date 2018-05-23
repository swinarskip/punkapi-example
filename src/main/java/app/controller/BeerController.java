package app.controller;

import app.entity.Beer;
import app.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class BeerController {

    @Autowired
    private BeerService beerService;

    @GetMapping("/")
    public Iterable<Beer> index() {
        return beerService.getBeers();
    }

    @GetMapping("/foodpairings/search/{phrase}")
    public Iterable<Beer> get(@PathVariable String phrase) {
        return beerService.getBeersByFoodPairing(phrase);
    }

    @PostMapping("/beers")
    public String beers(Beer beer) {
        // Validation is omitted for simplicity
        beerService.addBeers(Collections.singleton(beer));
        return "Beer has been added.";
    }
}