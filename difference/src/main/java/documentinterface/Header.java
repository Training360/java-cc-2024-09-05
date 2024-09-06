package documentinterface;

public record Header(String content) implements Part {

    @Override
    public void print() {
        System.out.println(content.toUpperCase());
    }
}
