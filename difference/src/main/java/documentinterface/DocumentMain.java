package documentinterface;

import java.util.List;

public class DocumentMain {

    public static void main(String[] args) {
        var document = List.of(
                new Header("Hello Clean Code"),
                new Paragraph("lorem ipsum dolor sit amet"),
                new Header("Hello Java"),
                new Paragraph("sit amet ")
        );

        for (var part: document) {
            part.print();
        }
    }
}
