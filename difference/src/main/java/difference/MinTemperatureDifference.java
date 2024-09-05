package difference;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MinTemperatureDifference {

    public static final String WHITESPACE_CHARACTERS = "\\s+";
    public static final String PREFIX_OF_SUM_LINE = "mo";
    public static final String LIMIT_TEMPERATURE_SIGN = "*";
    public static final int MINIMUM_COLUMNS = 3;

    private enum REPLACE {
        NONE, SIGN
    }

    public static void main(String[] args) {
        String fileName = "weather.dat";
        int minDifferenceDay = 0;
        int minDifference = Integer.MAX_VALUE;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            skipHeader(br);

            while ((line = br.readLine()) != null) {
                if (sumLine(line)) {
                    continue;
                }

                ParsedLine parsedLine = parseLine(line);
//                if (parsedLine instanceof TemperatureDifferenceOnDay temperature) {
//                    if (temperature.difference() < minDifference) {
//                        minDifference = temperature.difference();
//                        minDifferenceDay = temperature.day();
//                    }
//                }

                switch (parsedLine) {
                    case TemperatureDifferenceOnDay(var day, var difference)  -> {
                        if (difference < minDifference) {
                            minDifference = difference;
                            minDifferenceDay = day;
                        }
                    }
                    case InvalidLine(var errorLine, var _) -> System.out.println("Invalid line: " + errorLine);
                }

            }
        } catch (IOException e) {
            System.out.println("Hiba a fájl beolvasása közben: " + e.getMessage());
        }

        System.out.println("Az a nap, ahol a legkisebb a hőmérséklet különbség: " + minDifferenceDay);
    }

    public static ParsedLine parseLine(String line) {
        String[] parts = splitLineByWhiteSpaces(line);
        if (parts.length > MINIMUM_COLUMNS) {
            try {
                int day =  getNumber(parts[2], REPLACE.NONE);
                int maxTemperature =  getNumber(parts[2], REPLACE.SIGN);
                int minTemperature = getNumber(parts[2], REPLACE.SIGN);
                int difference = maxTemperature - minTemperature;
                return new TemperatureDifferenceOnDay(day, difference);
            } catch (NumberFormatException _) {
                return new InvalidLine(line, "Not a number");
            }
        }
        return new InvalidLine(line, "Not enough column");
    }

    private static int getNumber(String part, REPLACE replace) {
        var replaced = part;
        if (replace == REPLACE.SIGN) {
            replaced = replaced.replace(LIMIT_TEMPERATURE_SIGN, "");
        }

        return Integer.parseInt(replaced);
    }


    private static boolean sumLine(String line) {
        return line.startsWith(PREFIX_OF_SUM_LINE);
    }

    private static String[] splitLineByWhiteSpaces(String line) {
        return line.trim().split(WHITESPACE_CHARACTERS);
    }

    private static void skipHeader(BufferedReader br) throws IOException {
        var _ = br.readLine();
    }
}
