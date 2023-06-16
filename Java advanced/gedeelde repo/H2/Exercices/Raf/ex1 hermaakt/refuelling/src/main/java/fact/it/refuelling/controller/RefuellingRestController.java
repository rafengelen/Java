package fact.it.refuelling.controller;

import fact.it.refuelling.model.Refuelling;
import fact.it.refuelling.model.RefuellingService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RefuellingRestController {
    private RefuellingService refuellingService;

    @PostConstruct
    public void fillRefuellingService(){
        this.refuellingService = new RefuellingService();
    }

    @GetMapping("/refuellings")
    public List<Refuelling> getAllRefuelling(){
        return refuellingService.getRefuellingList();
    }
    @GetMapping("/refuelling/{id}")
    public ResponseEntity<Refuelling> getOneRefuelling(@PathVariable("id") int id){
        Optional<Refuelling> optionalRefuelling = refuellingService.getOptionalRefuellingById(id);
        return optionalRefuelling.map(refuelling -> new ResponseEntity<>(refuelling, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("refuellings/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Refuelling addRefuelling(@RequestBody Refuelling newRefuelling){
        return refuellingService.addRefuelling(newRefuelling);
    }

    @PutMapping("refuellings/update/{id}")
    public ResponseEntity<Refuelling> updateRefuelling(@RequestBody Refuelling updateRefuelling, @PathVariable("id") int id){
        Refuelling refuelling = refuellingService.updateRefuellingById(updateRefuelling, id);
        if (refuelling == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(refuelling, HttpStatus.OK);
    }

    @DeleteMapping("refuellings/delete/{id}")
    public ResponseEntity<Integer> deleteRefuelling(@PathVariable("id") int id){
        Optional<Refuelling> optionalRefuelling = refuellingService.getOptionalRefuellingById(id);
        if(optionalRefuelling.isPresent()){
            refuellingService.getRefuellingList().remove(optionalRefuelling.get());

            return new ResponseEntity<>(refuellingService.getRefuellingList().size(), HttpStatus.OK);
        }
        return new ResponseEntity<>(refuellingService.getRefuellingList().size(), HttpStatus.NOT_FOUND);
    }


    @GetMapping("refuellings/totalConsumption")
    public double totalConsumption(){
        ArrayList<Refuelling> refuellingList = refuellingService.getRefuellingList();
        return refuellingList.stream().mapToDouble(Refuelling::getFuelConsumption).sum();
    }




}
