package weather;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTemperaturesTest {

    @Test
    void shouldParseLine() {
        var input = "  18  82    52    67          52.6       0.00         230  4.0 190  12  5.0  93 34 1021.3";
        var output = DayTemperatures.parse(input);

        assertEquals(18, output.day());
        assertEquals(82, output.maximumTemperature());
        assertEquals(52, output.minimumTemperature());
    }

    @Test
    void shouldParseLineWithAsterix() {
        var input = "  18  82*   52    67          52.6       0.00         230  4.0 190  12  5.0  93 34 1021.3";
        var output = DayTemperatures.parse(input);

        assertEquals(18, output.day());
        assertEquals(82, output.maximumTemperature());
        assertEquals(52, output.minimumTemperature());
    }


}
