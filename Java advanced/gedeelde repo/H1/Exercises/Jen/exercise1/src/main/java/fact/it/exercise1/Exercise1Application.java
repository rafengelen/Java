package fact.it.exercise1;

import fact.it.exercise1.model.PrimeCalculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Exercise1Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise1Application.class, args);

//		PrimeCalculator pc = new PrimeCalculator();
//
//		System.out.println(pc.getAllPrimesUntil(40));

//		List<Integer> divisors = pc.getListOfAllNumbersUntil(2, 4);

//		Boolean divisors2 = divisors.stream().peek(System.out::println).map((x) -> {return 5 % x;}).peek(e -> System.out.println("mapped value: " + e)).noneMatch(x -> x == 0);
//
//		System.out.println();
//		System.out.println(divisors2);
//		System.out.println(pc.isPrime(4));

//		divisors.stream().filter(e->e>1).peek(e-> System.out.println(13%e)).collect(Collectors.toList());

//		System.out.println(divisors);
//		divisors.forEach((x) -> {System.out.println(x % 2);});
//		divisors.forEach((x) -> {divisions.add(7 % x);});
//		System.out.println(divisions);
//		System.out.println(pc.isPrime(6));
//		System.out.println(1 * 2 == 2);
	}
}
