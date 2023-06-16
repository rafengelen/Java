package fact.it.ex1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


import static java.util.stream.IntStream.range;

public class PrimeCalculator {
    public boolean isPrime(int number){
        if (number <= 1) {
            return false;
        }
        return getListOfAllNumbersUntil(2, (int) Math.sqrt(number)).stream().allMatch(n -> number % n != 0);

    }
    public List<Integer> getAllPrimesUntil(int number){
        return getListOfAllNumbersUntil(0, number)
                .stream()
                .filter(this::isPrime)
                .toList();
    }
    public List<Integer> getListOfAllNumbersUntil(int start, int end){
        return IntStream.range(start, end+1).boxed().toList();
    }
}
