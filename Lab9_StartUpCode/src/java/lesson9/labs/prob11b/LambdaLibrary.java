package lesson9.labs.prob11b;

import lesson9.labs.prob11b.Employee;
import lesson9.labs.prob11b.TriFunction;

import java.util.Comparator;
import java.util.List;

public final class LambdaLibrary {
    public static TriFunction<List<Employee>, Integer, String, String> filterEmployeeBySalaryAndName = (emps, sal, nameFilter) -> emps == null ? null : emps.stream()
            .filter(e -> e.getSalary() > sal && e.getLastName().matches(nameFilter))
            .map(e -> e.getFirstName() + " " + e.getLastName())
            .sorted(Comparator.comparing(s -> s))
            .reduce((str1, str2) -> str1 + ", " + str2).get();
}
