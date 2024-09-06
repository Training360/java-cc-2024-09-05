package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class EmployeesMain {

    public static void main(String[] args) {
        var names = IntStream.range(0, 5)
                .mapToObj(i -> "John Doe" + i)
                .toList();

        System.out.println(names);

        var employees = List.of(
                new Employee(1L, "John Doe"),
                new Employee(2L, "Jane Doe")
        );

        var count = employees.stream()
                // Mellékhatás
                .peek(employee -> employee.setName("grrr"))
                .filter(employee -> employee.getName().startsWith("J"))
                .count();
        System.out.println(count);
        System.out.println(employees);
    }

    // Sose írjunk ilyet! Mellékhatás: paraméterként átadott listába írunk!
    public static int parse(String s, List<String> errors) {
        if (s == null) {
            errors.add("Error, the string is null");
        }
        return 0;
    }
}
