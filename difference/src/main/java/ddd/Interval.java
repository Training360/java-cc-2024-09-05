package ddd;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record Interval(LocalDate start, LocalDate end) {

    public long lengthInDays() {
        return ChronoUnit.DAYS.between(start, end);
    }

    // 2024-12-01 - 2025-01-01

    public static Interval of(String text) {
        return new Interval(LocalDate.parse(text), LocalDate.now());
    }
}
