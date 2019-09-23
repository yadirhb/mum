package lesson9.labs.prob12;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LambdaLibrary {
    public static BiFunction<List<Employee>, Predicate<Employee>, Stream<String>> filterEmployeeByPredicate = (emps, filter) -> emps == null ? null : emps.stream()
            .filter(e -> filter.test(e))
            .map(e -> e.getFirstName() + " " + e.getLastName())
            .sorted(Comparator.comparing(s -> s));

    public static Function<List<Employee>, Long> getNumberOfEmployees = (list) ->
            filterEmployeeByPredicate.apply(list, (employee) -> employee.getLastName().matches("^[E-Z].*") && employee.getSalary() > 100000)
                    .count();

    public static Function<List<Employee>, List<String>> getUppercasedList = (list) ->
            filterEmployeeByPredicate.apply(list, (employee) -> employee.getFirstName().matches("^[A-R].*") && employee.getSalary() > 85000)
                    .map(s -> s.toUpperCase())
                    .collect(Collectors.toList());
}
