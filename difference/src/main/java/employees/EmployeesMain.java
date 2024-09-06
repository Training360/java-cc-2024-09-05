package employees;

import java.time.LocalDate;

public class EmployeesMain {

    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2020, 1, 1);
    }

    public Employee of(String... args) {
        // SOSE:
//        var name = args[0];
//        var salary = Double.parseDouble(args[1]);
        return null;
    }

    public void apply(boolean update) {
        if (update) {
            String sql = "update";
            // ..
        }
        else {
            String sql = "insert";
            // ..
        }
    }

    public void update() {}
    public void insert() {}
}
