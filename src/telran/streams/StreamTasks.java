package telran.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTasks {
	private static final int N_NUMBERS = 1_000_000;
	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = Integer.MAX_VALUE;
	
	public static void printDigitStatics1(){
		
		Map<Integer,Long> map = new Random().ints(N_NUMBERS, MIN_NUMBER, MAX_NUMBER)
		.flatMap(n -> Integer.toString(n).chars()).boxed()
		.collect(Collectors.groupingBy(d -> d, Collectors.counting()));
		
		map.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
		.forEach(e -> System.out.printf("%c -> %s\n", e.getKey(), e.getValue()));
	}
    public static void printDigitStatics2(){
		
		Map<Character,Long> map = new Random().ints(N_NUMBERS, MIN_NUMBER, MAX_NUMBER)
		.flatMap(n -> Integer.toString(n).chars()).mapToObj(d -> (char)d)
		.collect(Collectors.groupingBy(d -> d, Collectors.counting()));
		
		map.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
		.forEach(e -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue()));
	}
    public static void printDigitStatics3(){
		
		var map = new Random().ints(N_NUMBERS, MIN_NUMBER, MAX_NUMBER)
				.mapToObj(Integer::toString).flatMap(s -> Arrays.stream(s.split("")))
				.collect(Collectors.groupingBy(d -> d, Collectors.counting()));
		
		map.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
		.forEach(e -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue()));
	}
    public static void printSportLotoNumbers() {
    	new Random().ints(1, 50).distinct().limit(6).forEach(n -> System.out.print(n + " "));
    }
	
}
