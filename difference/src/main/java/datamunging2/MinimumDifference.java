package datamunging2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class MinimumDifference {

    public String findFirstMinDifference() throws IOException {
        var lines = Files.readAllLines(Paths.get(getFilename()));
        var filteredLines = skipHeader(lines);
        var parsedLines = parseLines(filteredLines);
        return findMax(parsedLines);
    }

    protected abstract String getFilename();

    private List<Line> parseLines(List<String> lines) {
        List<Line> parsedLines = new ArrayList<>();
        for (int i = 0; i < getExpectedLines(); i++) {
            String currentLine = lines.get(i);
            if (isInvalidLine(currentLine)) {
                continue;
            }
            Line weatherData = parseLine(currentLine);
            parsedLines.add(weatherData);
        }
        return parsedLines;
    }

    protected abstract boolean isInvalidLine(String currentLine);

    protected abstract Line parseLine(String currentLine);

    private String findMax(List<Line> weatherDataList) {
        return weatherDataList.stream()
                .min(Comparator.comparing(Line::getDiff))
                .orElseThrow(() -> new IllegalArgumentException("No lines found in file"))
                .getLabel();
    }

    protected abstract int getExpectedLines();

    protected abstract List<String> skipHeader(List<String> inputFile);

    protected boolean isValidToken(String line) {
        return !line.isEmpty();
    }
}
