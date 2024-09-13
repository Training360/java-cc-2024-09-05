package datamunging;

import java.util.List;
import java.util.function.Predicate;

public class FunctionalMain {

    public static void main(String[] args) {
        List<String> lines = List.of("Jack Doe", "Jane Doe", "Jack Smith");
        new FunctionalMain().findMinimumDifference(lines, 1, 2, 3,
                line -> line.contains("Smith")
                );
    }

    public String findMinimumDifference(List<String> lines, int labelIndex, int minIndex, int maxIndex, Predicate<String> isValidLine) {
        for (String line: lines) {
            if (isValidLine.test(line)) {
                System.out.println(line);
            }
        }
        return null;
    }

}
