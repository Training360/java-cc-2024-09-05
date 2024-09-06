package datamunging;

public class TemperatureFileStrategy implements FileStrategy {

    @Override
    public int indexOfLabel() {
        return 0;
    }

    @Override
    public int indexOfMax() {
        return 1;
    }

    @Override
    public int indexOfMin() {
        return 2;
    }

    @Override
    public boolean isHeaderOrFooterLine(String[] splittedLine) {
        return splittedLine[0] == null || splittedLine[0].isEmpty()
                || "Dy".equals(splittedLine[0])
                || "mo".equals(splittedLine[0]);
    }

    @Override
    public String message(String label) {
        return "A legkisebb hömérséklet különbségű nap: %s%n".formatted(label);
    }
}
