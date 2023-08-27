package telran.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTasks {
	private static final int N_NUMBERS = 1_000_000;
	
	public void printDigitStatics(){
		int[] numbers = getRandomNumbers(N_NUMBERS);
		
		Map<Object, Long> map = Arrays.stream(numbers).mapToObj(Integer::toString)
				.flatMapToInt(String::chars).boxed()
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		
		map.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
		.forEach(e -> System.out.printf("%c -> %d\n", e.getKey(), e.getValue()));
	}

	
	private int[] getRandomNumbers(int nNumbers) {
		
		return new Random().ints(nNumbers, 0, Integer.MAX_VALUE).toArray();
	}
	
}
