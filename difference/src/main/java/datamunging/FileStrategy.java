package datamunging;

public interface FileStrategy {
    int indexOfLabel();

    int indexOfMax();

    int indexOfMin();

    boolean isHeaderOrFooterLine(String[] splittedLine);

    String message(String label);
}
