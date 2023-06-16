package fact.it.exercise1.controller;

import fact.it.exercise1.model.Refuelling;
import fact.it.exercise1.model.RefuellingService;
import javax.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api")
public class RefuellingRestController {
    private RefuellingService refuellingService;

    @PostConstruct
    public void fillRefuellingServiceWithRefuellings(){
        this.refuellingService = new RefuellingService();
    }

    @GetMapping("/refuellings")
    public List<Refuelling> getAllRefuellings(){
        return this.refuellingService.getRefuellingList();
    }

    @GetMapping("/refuelling/{id}")
    public ResponseEntity<Refuelling> getRefuellingById(@PathVariable("id") int refuellingId){
        Optional<Refuelling> refuelling = this.refuellingService.getOptionalRefuellingById(refuellingId);

        if (refuelling.isPresent()){
            return new ResponseEntity<>(refuelling.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/refuellings/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Refuelling addRefuelling(@RequestBody Refuelling refuelling){
        return this.refuellingService.addRefuelling(refuelling);
    }

    @PutMapping("refuelling/update/{id}")
    public ResponseEntity<Refuelling> updateRefuelling(@RequestBody Refuelling updateRefuelling, @PathVariable("id") int id){
        Refuelling refuelling = this.refuellingService.updateRefuellingById(updateRefuelling, id);
        if (refuelling==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(refuelling, HttpStatus.OK);
    }

    @DeleteMapping("refuelling/delete/{id}")
    public ResponseEntity<Integer> deleteRefuelling(@PathVariable("id") int id){
        Optional<Refuelling> refuelling = this.refuellingService.getOptionalRefuellingById(id);
        if (refuelling.isPresent()){
            refuellingService.getRefuellingList().remove(refuelling.get());
            return new ResponseEntity<>(refuellingService.getRefuellingList().size(), HttpStatus.OK);
        }
        return new ResponseEntity<>(refuellingService.getRefuellingList().size(), HttpStatus.NOT_FOUND);
    }
}
