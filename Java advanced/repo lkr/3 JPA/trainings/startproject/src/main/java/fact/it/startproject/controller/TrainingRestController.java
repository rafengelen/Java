package fact.it.startproject.controller;

import fact.it.startproject.model.Training;
import fact.it.startproject.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TrainingRestController {
    @Autowired
    TrainingRepository trainingRepository;

    @GetMapping("/training")
    public List<Training> trainings(){
        List<Training> trainings = trainingRepository.findAllByOrderByTheme();
        return trainings;
    }
    @GetMapping("/training/{id}")
    public ResponseEntity<Training> training(@PathVariable Long id){
        Optional<Training> trainingOptional = trainingRepository.findById(id);
        if(trainingOptional.isPresent()){
            return new ResponseEntity<>(trainingOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/training/title")
    public ResponseEntity<List<Training>> searchTitle(@RequestBody String title){
        List<Training> trainings = trainingRepository.findAll().stream().filter(t->t.getTitle().contains(title)).toList();
        if(trainings.isEmpty()){return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(trainings, HttpStatus.OK);
    }
    @PostMapping("/training")
    //@ResponseStatus(HttpStatus.CREATED)
    public Training createTraining(@RequestBody Training training){
        trainingRepository.save(training);
        return (training);

    }

    @DeleteMapping("training/{id}")
    public ResponseEntity<Integer> deleteTraining(@PathVariable Long id){
        Optional<Training> training = trainingRepository.findById(id);
        if (training.isPresent()){
            trainingRepository.delete(training.get());

            return new ResponseEntity<>(trainingRepository.findAmount(), HttpStatus.OK);
        }
        return new ResponseEntity<>(trainingRepository.findAmount(), HttpStatus.NOT_FOUND);
    }
    @PutMapping("training/{id}")
    public ResponseEntity<Training> editTraining(@PathVariable Long id, @RequestBody Training training){
        Optional<Training> trainingOptional = trainingRepository.findById(id);
        if(trainingOptional.isPresent()){
            training.setId(trainingOptional.get().getId());
            trainingRepository.save(training);
            return new ResponseEntity<>(training, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
