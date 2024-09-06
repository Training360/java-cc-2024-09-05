package datamunging;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MinimumTemperature {

    public static void main(String[] args) {
        String filePath = "src/main/resources/weather.dat";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            double minTemperatureDay = 0;
            double minTemperatureDifference = Double.MAX_VALUE;

            while ((line = br.readLine()) != null) {
                String[] splittedLine = line.trim().split("\\s+");

                if (isHeaderOrFooterLine(splittedLine)) {
                    continue;
                }

                double day = convertStringToDouble(splittedLine[0]);
                double maxTemperature = convertStringToDouble(splittedLine[1]);
                double minTemperature = convertStringToDouble(splittedLine[2]);
                double temperatureDifference = (maxTemperature - minTemperature);

                if (temperatureDifference < minTemperatureDifference) {
                    minTemperatureDay = day;
                    minTemperatureDifference = temperatureDifference;
                }
            }
            System.out.printf("A legkisebb hömérséklet különbségű nap: %s%n", minTemperatureDay);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isHeaderOrFooterLine(String[] splittedLine) {
        return splittedLine[0] == null || splittedLine[0].isEmpty()
                || "Dy".equals(splittedLine[0])
                || "mo".equals(splittedLine[0]);
    }

    private static double convertStringToDouble(String stringValue) {
        if (stringValue == null || stringValue.isEmpty()) {
            throw new IllegalArgumentException("Üres stringet nem lehet számmá konvertálni!");
        }
        try {
            int indexOfStarCharacter = stringValue.trim().indexOf("*");
            if (indexOfStarCharacter != -1) {
                stringValue = stringValue.substring(0, indexOfStarCharacter);
            }
            return Double.parseDouble(stringValue);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(String.format("%s nem konvertálható számmá!", stringValue));
        }
    }
}
