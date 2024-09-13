package demeter;

import java.util.List;

// Anemic model
public class EmployeeService {

    void saveAddress(long employeeId, Address address) {
        var employee = findEmployeeById(employeeId);
        // Demeter törvényének megsértése
        // Demeter törvénye: csak a közvetlen barátaiddal beszélhetsz
        employee.addAddress(address);

        // Builder design pattern
        // Fluent interface
//        entityManager
//                .createQuery("sdrtwe")
//                .setParameter("swe", "werqw") // return this;
//                .setParameter("ertwer", "wertqw")
//                .setMaxResult(15)
//                .getResultList();

//        List.of("alma", "korte")
//                .stream()
//                .filter()
    }

    private Employee findEmployeeById(long employeeId) {
        return null;
    }
}
