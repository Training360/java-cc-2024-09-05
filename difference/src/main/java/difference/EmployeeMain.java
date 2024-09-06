package difference;

import java.util.List;

public class EmployeeMain {

    public static void main(String[] args) {
        var employee = new Employee(1L, "John Doe");
        System.out.println(employee);

        var employees = List.of(new Employee(1L, "John"), new Employee(2L, "Jane"));
    }
}
