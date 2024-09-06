package datamunging2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Training360 {

    public static final String WEATHER_DATA_PATH = "src/main/resources/weather.dat";
    private static final int expectedNumberOfDays = 30;
    private static final int ignoredLinesCount = 2;
    private static final String DIGIT_REGEX = "\\D";
    private static final String WHITE_SPACE = " ";
    private static final String EMPTY_STRING = "";

    public static void main(String[] args) throws IOException {
        System.out.println(firstMinDifference());
    }

    public static int firstMinDifference() throws IOException {
        List<WeatherData> weatherDataList = new ArrayList<>();
        List<String> inputFile = Files.readAllLines(Paths.get(WEATHER_DATA_PATH));
        List<String> weatherDataForDays = skipHeader(inputFile);



        for (int i = 0; i < expectedNumberOfDays; i++) {
            var currentDay = weatherDataForDays.get(i);
            List<String> values = Arrays.stream(currentDay.split(WHITE_SPACE)).filter(Training360::isValidLine).collect(Collectors.toList());
            String day = values.get(0);
            String max = values.get(1).replaceAll(DIGIT_REGEX, EMPTY_STRING);
            String min = values.get(2).replaceAll(DIGIT_REGEX, EMPTY_STRING);

            weatherDataList.add(new WeatherData(day, max, min));
        }

        return weatherDataList.stream().min(Comparator.comparing(WeatherData::getDiff)).get().getDiff();
    }



    private static List<String> skipHeader(List<String> inputFile) {
        return inputFile.subList(ignoredLinesCount, inputFile.size());
    }


    private static boolean isValidLine(String line) {
        return !line.isEmpty();
    }
}