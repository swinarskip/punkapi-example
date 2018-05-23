package app.service;

import app.entity.Beer;
import app.repository.BeerRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Collection;

@Service
@Transactional
public class BeerService {

    private static final String PUNKAPI_URL = "https://api.punkapi.com/v2/beers";

    @Autowired
    private BeerRepository beerRepository;

    public void addBeers(Iterable<Beer> beers) {
        beerRepository.saveAll(beers);
    }

    public Iterable<Beer> getBeers() {
        return beerRepository.findAll();
    }

    public Iterable<Beer> getBeersByFoodPairing(String foodPairing) {
        return beerRepository.findAllByFoodPairing(foodPairing);
    }

    public void importBeers() throws Exception {
        Type type = new TypeToken<Collection<Beer>>() {
        }.getType();
        Reader reader = new InputStreamReader(new URL(PUNKAPI_URL).openStream());
        Collection<Beer> beers = new Gson().fromJson(reader, type);
        addBeers(beers);
    }
}