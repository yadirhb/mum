package lesson9.labs.prob9;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static Function<Integer, Stream<Integer>> getSquares = (num) -> IntStream.iterate(1, i -> (int) Math.pow(Math.sqrt(i) + 1, 2)).limit(num).boxed();

    public static void printSquares(int num) {
        System.out.println(getSquares.apply(num).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        printSquares(4);
    }
}
