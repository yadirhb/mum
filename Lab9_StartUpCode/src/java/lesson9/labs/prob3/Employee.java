package lesson9.labs.prob3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Employee {
    static Function<List<Employee>, List<Employee>> sortEmployee = (l) -> l.stream().sorted(Comparator.comparing((Employee e) -> e.getName()).thenComparing(Employee::getSalary)).collect(Collectors.toList());
    String name;
    int salary;

    public Employee(String n, int s) {
        this.name = n;
        this.salary = s;
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>() {
            {
                add(new Employee("Joe", 50000));
                add(new Employee("Jim", 75000));
                add(new Employee("Tom", 80000));
                add(new Employee("Jim", 70000));
                add(new Employee("Steve", 55000));
                add(new Employee("Jim", 100000));
                add(new Employee("Joe", 59000));
                add(new Employee("Rich", 88000));
            }
        };

        //expected output:
        //[[Jim, 100000], [Jim, 75000], [Jim, 70000], [Joe, 59000], [Joe, 50000], [Rich, 88000], [Steve, 55000], [Tom, 80000]]
        System.out.println(sortEmployee.apply(list));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + salary + "]";
    }
}

