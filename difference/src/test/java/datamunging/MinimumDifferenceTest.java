package datamunging;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumDifferenceTest {

    MinimumDifference minimumDifference = new MinimumDifference();

    @Test
    void findMinimumDifferenceLabelForTemperature() {
        var label = minimumDifference.findMinimumDifferenceLabel("weather.dat", new TemperatureFileStrategy());
        assertEquals("14", label);
    }

    @Test
    void findMinimumDifferenceLabelForFootball() {
        var label = minimumDifference.findMinimumDifferenceLabel("football.dat", new FootballFileStrategy());
        assertEquals("Aston_Villa", label);
    }
}