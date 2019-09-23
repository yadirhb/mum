package lesson9.labs.prob7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
	static Function<String, String> reverse = (s) -> s == null || s.isEmpty() ? null : new StringBuilder(s).reverse().toString();

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(4, 5, -2, 0, -3, -1, -5, -4);
		//expected output: [0, -1, -2, -3, -4, 4, -5, 5]
		ordering1(intList);
		List<String> stringList = Arrays.asList("cba", "efg", "doe", "fie", "set");
		//expected output: [cba, fie, doe, efg, set]
		ordering2(stringList);
	}

	//Orders the integers according to this pattern:
	// 0, -1, 1, -2, 2, -3, 3, . . .
	//Using this ordering, this method sorts the list as part of
	//a stream pipeline, and prints to the console
	public static void ordering1(List<Integer> list) {
		System.out.println(list == null || list.isEmpty() ? "Empty list" : list.stream()
				.sorted((o1, o2) -> Math.abs(o1) - Math.abs(o2)).collect(Collectors.toList())
		);
	}

	//Orders words by first reversing each and comparing
	//in the usual way.  So
	//    cba precedes bed
	//since
	//    cba.reverse() precedes bed.reverse()
	//in the usual ordering
	//Using this ordering, this method sorts the list as part of
	//a stream pipeline, and prints to the console
	public static void ordering2(List<String> words) {
		System.out.println(words == null || words.isEmpty() ? "Empty list" : words.stream()
				.sorted(Comparator.comparing((String w) -> reverse.apply(w)).thenComparing((w1, w2) -> w1.compareTo(w2)))
				.collect(Collectors.toList())
		);
	}
}
