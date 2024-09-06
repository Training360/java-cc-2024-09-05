package employees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisonTest {

    @Test
    void calculate() {
        assertEquals(10.0, new Divison().calculate(30, 3), 0.001);
    }

    @Test
    void calculateThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Divison().calculate(15, 0);
        });
    }
}