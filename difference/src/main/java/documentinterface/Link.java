package documentinterface;

public record Link(String href) implements Part {

    @Override
    public void print() {
        System.out.println(href);
    }
}
