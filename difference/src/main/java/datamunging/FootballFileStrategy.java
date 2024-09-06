package datamunging;

import java.util.Arrays;

public class FootballFileStrategy  implements FileStrategy {

    @Override
    public int indexOfLabel() {
        return 1;
    }

    @Override
    public int indexOfMax() {
        return 6;
    }

    @Override
    public int indexOfMin() {
        return 8;
    }

    @Override
    public boolean isHeaderOrFooterLine(String[] splittedLine) {
        return splittedLine[0].equals("Team") || splittedLine[0].contains("---");
    }

    @Override
    public String message(String label) {
        return "A legkisebb gólkülönbségű csapat: %s%n".formatted(label);
    }
}
