package com.axxes.testing.mocking;

import com.axxes.testing.mocking.exception.BeerAlreadyExistsException;
import com.axxes.testing.mocking.exception.BeerNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BeerService {

    private final Database database;

    public BeerService(Database database) {
        this.database = database;
    }

    public List<Beer> getAllBeers() {
        return database
                .getAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public Beer createBeer(Beer beer) {

        /*database.create(
                new BeerEntity(
                        beer.getId(),
                        beer.getName(),
                        beer.getPrice(),
                        beer.getRating()
                ));
        return beer;*/

        Optional<BeerEntity> optionalBeer = database.findById(beer.getId());
        if (optionalBeer.isPresent()) {
            throw new BeerAlreadyExistsException(beer);
        }
        BeerEntity beerEntity = map(beer);
        database.create(beerEntity);
        return beer;
    }

    public Beer updateBeer(Beer beer) {
        /*Optional<BeerEntity> optionalBeer = database.findById(beer.getId());

        if (optionalBeer.isPresent()) {
            BeerEntity beerEntityOriginal = optionalBeer.get();
            BeerEntity beerEntityUpdated = map(beer);
            if(beerEntityOriginal.equals(beerEntityUpdated)){
                database.update(beerEntityUpdated);
            }
            return beer;
        }
        throw new BeerNotFoundException(beer.getId());*/

        Optional<BeerEntity> optionalBeer = database.findById(beer.getId());

        BeerEntity entity = optionalBeer.orElseThrow(() -> new BeerNotFoundException(beer.getId()));

        if (!beer.getName().equals(entity.getName())) {
            entity.setName(beer.getName());
        }
        if (beer.getPrice() != entity.getPrice()) {
            entity.setPrice(beer.getPrice());
        }
        if (beer.getRating() != entity.getRating()) {
            entity.setRating(beer.getRating());
        }

        database.update(entity);

        return beer;
    }

    public boolean deleteBeer(long id) {
        Optional<BeerEntity> entity = database.findById(id);
        entity.map(BeerEntity::getId)
                .ifPresent(database::delete);
        return entity.isPresent();
    }

    private Beer map(BeerEntity entity) {
        return new Beer(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getRating());
    }

    private BeerEntity map(Beer beer) {
        return new BeerEntity(
                beer.getId(),
                beer.getName(),
                beer.getPrice(),
                beer.getRating());
    }



}
