package datamunging;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MinimumDifference {

    public static void main(String[] args) {
        MinimumDifference minimumDifference = new MinimumDifference();

        String temperatureFile = "src/main/resources/weather.dat";
        minimumDifference.findMinimumDifferenceLabel(temperatureFile, new TemperatureFileStrategy());

        String footballFile = "src/main/resources/football.dat";
        minimumDifference.findMinimumDifferenceLabel(footballFile, new FootballFileStrategy());
    }

    public String findMinimumDifferenceLabel(String filePath, FileStrategy strategy) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String minValueLabel = "0";
            double minValueDifference = Double.MAX_VALUE;

            while ((line = br.readLine()) != null) {
                String[] splittedLine = line.trim().split("\\s+");

                if (strategy.isHeaderOrFooterLine(splittedLine)) {
                    continue;
                }

                String label = splittedLine[strategy.indexOfLabel()];
                double maxValue = convertStringToDouble(splittedLine[strategy.indexOfMax()]);
                double minValue = convertStringToDouble(splittedLine[strategy.indexOfMin()]);
                double valueDifference = Math.abs(maxValue - minValue);

                if (valueDifference < minValueDifference) {
                    minValueLabel = label;
                    minValueDifference = valueDifference;
                }
            }
            System.out.printf(strategy.message(minValueLabel));
            return minValueLabel;
        } catch (IOException e) {
            throw new RuntimeException("Can not parse file", e);
        }
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
            throw new RuntimeException(String.format("%s nem konvertálható számmá!", stringValue), e);
        }
    }
}
