package employees;

public class Divison {

    /**
     *
     * @param a
     * @param b nem lehet nulla
     * @return
     */
    public double calculate(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("B can not be 0!");
        }
        return a / b;
    }
}
