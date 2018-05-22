package app.beer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

@Service
@Transactional
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    public void create(List<Beer> beers) {
//        beers.forEach(b -> b.setId(null));
        beerRepository.saveAll(beers);
    }

    public Iterable<Beer> getAll() {
        return beerRepository.findAll();
    }

    public List<Beer> getAllByPhrase(String phrase) {
        return beerRepository.findAllByFoodPairing(phrase);
    }

    public void getBeers() throws Exception {
        Type listType = new TypeToken<List<Beer>>() {
        }.getType();

        Reader reader = new InputStreamReader(new URL("https://api.punkapi.com/v2/beers").openStream());

        Gson gson = new Gson();
        List<Beer> beers = gson.fromJson(reader, listType);
        create(beers);
    }
}

