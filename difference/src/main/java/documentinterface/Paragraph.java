package documentinterface;

public record Paragraph(String content) implements Part {

    @Override
    public void print() {
        System.out.println(content);
    }
}
