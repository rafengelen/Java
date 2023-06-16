package fact.it.exampleprojectjpa.controller;

import fact.it.exampleprojectjpa.model.Bread;
import fact.it.exampleprojectjpa.repository.BreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BreadRestController {
    @Autowired
    private BreadRepository breadRepository;


    //a service to retrieve all bread records from the database, sorted by price
    @GetMapping("/breads")
    public List<Bread> getBreads() {
        return breadRepository.giveListOfAllBreadsOrderedByPrice();
    }

    //a service to query all bread records from the database where the name starts with a certain letter combination
    @GetMapping("/breads/search")
    public List<Bread> getBreadsNaamdeel(@RequestBody String naamdeel) {
        return breadRepository.findAllByNameStartingWith(naamdeel);
    }

    //a service to find the cheapest bread
    @GetMapping("/breads/searchcheapest")
    public List<Bread> getBreadsCheapest() {
        return breadRepository.findCheapestBreads();
    }

    //a service to add a bread record in the database. This service also returns the added bread object
    @PostMapping("/breads")
    public Bread createBread(@RequestBody Bread bread) {
        return breadRepository.save(bread);
    }

    //a service to modify a bread record in the database. This service  returns the custom bread object if found, if not, HTTP 404
    @PutMapping("/breads/{id}")
    public ResponseEntity<Bread> changeBread(@RequestBody Bread updateBread, @PathVariable long id) {
        Optional<Bread> bread1 = breadRepository.findById(id);
        if (bread1.isPresent()) {
            Bread bread = bread1.get();
            bread.setName(updateBread.getName());
            bread.setPrice(updateBread.getPrice());
            breadRepository.save(bread);
            return new ResponseEntity<>(bread, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //a service to remove a bread record from the database. This service returns the number of breads in the database
    @DeleteMapping("/breads/{id}")
    public ResponseEntity<Integer> deleteBread(@PathVariable long id) {
        Optional<Bread> bread1 = breadRepository.findById(id);
        if (bread1.isPresent()) {
            Bread bread = bread1.get();
            breadRepository.delete(bread);
            return new ResponseEntity<>(breadRepository.findAll().size(), HttpStatus.OK);
        }
        return new ResponseEntity<>(breadRepository.findAll().size(), HttpStatus.NOT_FOUND);
    }
}
