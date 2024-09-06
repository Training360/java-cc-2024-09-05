package employees;

import java.time.LocalDate;

public record GasDay(LocalDate day) {

    static GasDay of(LocalDate localDate) {
        return null;
    }
}
