package datamunging2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WeatherMinimumDifference extends MinimumDifference {

    private static final int IGNORED_LINES_COUNT = 2;

    private static final String WEATHER_DATA_PATH = "src/main/resources/weather.dat";

    private static final int EXPECTED_NUMBER_OF_DAYS = 30;

    private static final String DIGIT_REGEX = "\\D";
    private static final String WHITE_SPACE = " ";
    private static final String EMPTY_STRING = "";


    public static void main(String[] args) throws IOException {
        System.out.println(new WeatherMinimumDifference().findFirstMinDifference());
    }

    @Override
    protected String getFilename() {
        return WEATHER_DATA_PATH;
    }

    @Override
    protected int getExpectedLines() {
        return EXPECTED_NUMBER_OF_DAYS;
    }

    protected List<String> skipHeader(List<String> inputFile) {
        return inputFile.subList(IGNORED_LINES_COUNT, inputFile.size());
    }

    @Override
    protected WeatherLine parseLine(String currentLine) {
        List<String> values = Arrays.stream(currentLine.split(WHITE_SPACE))
                .filter(this::isValidToken)
                .toList();
        String day = values.get(0);
        String max = values.get(1).replaceAll(DIGIT_REGEX, EMPTY_STRING);
        String min = values.get(2).replaceAll(DIGIT_REGEX, EMPTY_STRING);
        WeatherLine weatherLine = new WeatherLine(day, max, min);
        return weatherLine;
    }

    @Override
    protected boolean isInvalidLine(String currentLine) {
        return false;
    }
}