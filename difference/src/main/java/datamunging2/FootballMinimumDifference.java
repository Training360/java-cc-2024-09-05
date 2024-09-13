package datamunging2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FootballMinimumDifference extends MinimumDifference {

    private static final String WHITE_SPACE = " ";

    public static void main(String[] args) throws IOException {
        System.out.println(new FootballMinimumDifference().findFirstMinDifference());
    }

    @Override
    protected String getFilename() {
        return "src/main/resources/football.dat";
    }

    @Override
    protected Line parseLine(String currentLine) {
        List<String> values = Arrays.stream(currentLine.split(WHITE_SPACE)).filter(this::isValidToken).toList();
        String team = values.get(1);
        int goalsFor = Integer.parseInt(values.get(6));
        int goalsAgainst = Integer.parseInt(values.get(8));
        return new FootballLine(team, goalsFor, goalsAgainst);
    }

    @Override
    protected int getExpectedLines() {
        return 21;
    }

    @Override
    protected List<String> skipHeader(List<String> inputFile) {
        return inputFile.subList(1, inputFile.size());
    }

    @Override
    protected boolean isInvalidLine(String currentLine) {
        return currentLine.contains("---");
    }
}
