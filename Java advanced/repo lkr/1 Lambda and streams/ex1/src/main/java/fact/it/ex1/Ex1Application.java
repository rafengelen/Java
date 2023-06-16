package fact.it.ex1;

import fact.it.ex1.model.PrimeCalculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Ex1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex1Application.class, args);


        /*PrimeCalculator pc = new PrimeCalculator();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(13);
        list.add(15);
        list.add(50);

        for(Integer number : list){
            System.out.println(number + " " + pc.isPrime(number));
        }
        System.out.println(pc.getAllPrimesUntil(7000));*/
    }



}
