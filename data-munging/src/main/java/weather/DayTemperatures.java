package weather;

public record DayTemperatures(int day, int minimumTemperature, int maximumTemperature) {

    public static DayTemperatures parse(String line) {
        int day = Integer.parseInt(line.substring(0, 4).trim());
        int maximumTemperature = Integer.parseInt(line.substring(6, 8));
        int minimumTemperature = Integer.parseInt(line.substring(12, 14));
        return new DayTemperatures(day, minimumTemperature, maximumTemperature);
    }

    public int getDifference() {
        return maximumTemperature - minimumTemperature;
    }
}
