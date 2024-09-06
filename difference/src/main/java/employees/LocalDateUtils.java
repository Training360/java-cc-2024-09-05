package employees;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateUtils {

    public static long getLengthInDays(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end);

    }
}
