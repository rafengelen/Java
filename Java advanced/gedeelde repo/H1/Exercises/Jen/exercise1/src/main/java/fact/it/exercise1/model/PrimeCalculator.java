package fact.it.exercise1.model;

import org.apache.el.stream.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeCalculator {
    public boolean isPrime(int number){
        //als nummer kleiner is dan 2, return false
        if (number < 2){
            return false;
        }
        return this.getListOfAllNumbersUntil(2, (int) Math.sqrt(number)).stream().allMatch(n -> number % n != 0);
    }

    public List<Integer> getAllPrimesUntil(Integer number){
        return this.getListOfAllNumbersUntil(0, number).stream().filter(this::isPrime).toList();
    }

    public List<Integer> getListOfAllNumbersUntil(Integer start, Integer end){
        return IntStream.range(start, end + 1).boxed().toList();
    }
}
