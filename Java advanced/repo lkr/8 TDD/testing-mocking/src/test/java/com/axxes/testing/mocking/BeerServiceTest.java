package com.axxes.testing.mocking;

import com.axxes.testing.mocking.exception.BeerAlreadyExistsException;
import com.axxes.testing.mocking.exception.BeerNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

class BeerServiceTest {

    private final Database db = mock(Database.class);
    private final BeerService beerService = new BeerService(db);

    void verifyBeerIsEqualToEntity(Beer beer, BeerEntity beerEntity) {
        assertThat(beer.getId()).isEqualTo(beerEntity.getId());
        assertThat(beer.getName()).isEqualTo(beerEntity.getName());
        assertThat(beer.getPrice()).isEqualTo(beerEntity.getPrice());
        assertThat(beer.getRating()).isEqualTo(beerEntity.getRating());
    }

    @Test
    void when_getAllBeers_allBeersAreReturned(){
        List<BeerEntity> entities = List.of(
                new BeerEntity(12L, "Stella", 3.50, 4.9),
                new BeerEntity(45L, "Westmalle", 4.50, 3.6),
                new BeerEntity(86L, "Viswijf", 4.50, 5.0)
        );
        when(db.getAll()).thenReturn(entities);

        List<Beer> allBeers = beerService.getAllBeers();
        assertThat(allBeers).isNotNull()
                .isNotEmpty()
                .hasSize(3);
        verifyBeerIsEqualToEntity(allBeers.get(0), entities.get(0));
        verifyBeerIsEqualToEntity(allBeers.get(1), entities.get(1));
        verifyBeerIsEqualToEntity(allBeers.get(2), entities.get(2));

        verify(db, times(1)).getAll();
        verifyNoMoreInteractions(db);

    }
/*
    @Test
    void when_beerCreated_beerInDatabase(){
        long id = 33L;
        Beer beer = new Beer(id, "lekker", 5.0,4.0);

        beerService.createBeer(beer);
        Optional<BeerEntity> beerEntityOptional = db.findById(id);
        if(beerEntityOptional.isPresent()){
            verify(db, times(1)).create(eq(new BeerEntity(12L, "Stella", 3.50, 4.9)));
        }
        else{
            throw new BeerNotFoundException(id);
        }
    }*/
@Test
void when_createBeer_beerDoesNotExist_beerIsCreated() {
    when(db.findById(12)).thenReturn(Optional.empty());

    Beer stella = new Beer(12L, "Stella", 3.50, 4.9);
    Beer result = beerService.createBeer(stella);

    assertThat(result).isEqualTo(stella);
    verify(db, times(1)).findById(12);
    verify(db, times(1)).create(eq(new BeerEntity(12L, "Stella", 3.50, 4.9)));
    verifyNoMoreInteractions(db);
}
    @Test
    void when_createBeer_beerExists_beerIsNotCreated(){
        // als we zoeken in de db naar een beer met id 12, dan willen we een optional terugkrijgen van een beer (id 12 bestaat al)
        when(db.findById(12)).thenReturn(Optional.of(new BeerEntity(12L, "Stella", 3.50, 4.9)));

        // maak beer aan
        Beer stella = new Beer(12L, "Stella", 3.50, 4.9);

        // exception nakijken of van onze class komt en komt uit createBeer(stella)
        assertThatExceptionOfType(BeerAlreadyExistsException.class).isThrownBy(() -> beerService.createBeer(stella));
        verify(db, times(1)).findById(12);
        verifyNoMoreInteractions(db);
    }

    @Test
    void when_updateBeer_beerDoesNotExists_exception(){
        //zeker zijn dat er geen Beer is met id 12
        when(db.findById(12)).thenReturn(Optional.empty());

        // maak beer aan
        Beer stella = new Beer(12L, "Stella", 3.50, 4.9);

        assertThatExceptionOfType(BeerNotFoundException.class).isThrownBy(() -> beerService.updateBeer(stella));

        verify(db, times(1)).findById(12);
        verifyNoMoreInteractions(db);
    }

    @Test
    void when_updateBeer_beerNotChanged_MethodNotCalled(){

    /*when(db.findById(12)).thenReturn(Optional.of(new BeerEntity(12L, "Stella", 3.50, 4.9)));
        beerService.updateBeer(new Beer(12L, "Stella", 3.50, 4.9));
        verifyNoInteractions(db);*/
        when(db.findById(12)).thenReturn(Optional.of(new BeerEntity(12L, "Stella", 3.50, 4.9)));

        beerService.updateBeer(new Beer(12L, "Stella", 3.90, 4.9));

        verify(db, times(1)).update(new BeerEntity(12L, "Stella", 3.90, 4.9));
        verify(db, times(1)).findById(12);
        verifyNoMoreInteractions(db);

    }

    @Test
    void when_deleteBeer_beerDoesNotExist_false(){
        when(db.findById(12)).thenReturn(Optional.empty());

    }
    @Test
    void when_deleteBeer_beerDoesExist_true(){

    }

}
