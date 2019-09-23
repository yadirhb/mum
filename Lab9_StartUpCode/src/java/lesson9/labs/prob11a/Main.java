package lesson9.labs.prob11a;

import lesson9.labs.prob11b.TriFunction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    static TriFunction<List<Employee>, Integer, String, String> filterEmployeeBySalaryAndName = (emps, sal, nameFilter) -> emps == null ? null : emps.stream()
            .filter(e -> e.getSalary() > sal && e.getLastName().matches(nameFilter))
            .map(e -> e.getFirstName() + " " + e.getLastName())
            .sorted(Comparator.comparing(s -> s))
            .reduce((str1, str2) -> str1 + ", " + str2).get();

    public static void main(String[] args) {
        List<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
                new Employee("John", "Sims", 110000),
                new Employee("Joe", "Stevens", 200000),
                new Employee("Andrew", "Reardon", 80000),
                new Employee("Joe", "Cummings", 760000),
                new Employee("Steven", "Walters", 135000),
                new Employee("Thomas", "Blake", 111000),
                new Employee("Alice", "Richards", 101000),
                new Employee("Donald", "Trump", 100000));

        System.out.println(filterEmployeeBySalaryAndName.apply(emps, 100000, "^[N-Z].*"));
    }
}
