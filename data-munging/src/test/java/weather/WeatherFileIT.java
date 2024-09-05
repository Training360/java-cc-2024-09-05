package weather;

import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherFileIT {

    @Test
    void shouldReturnDay22() {
        var day = new WeatherFile().findDayWithMinimumTemperatureDifference(
                new InputStreamReader(WeatherFileIT.class.getResourceAsStream("/weather.dat")));
        assertEquals(14, day);
    }
}
