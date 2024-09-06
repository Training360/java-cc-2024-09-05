package documentswitch;

import java.util.List;

public class DocumentMain {

    public static void main(String[] args) {
        List<Part> document = List.of(
                new Header("Hello Clean Code"),
                new Paragraph("lorem ipsum dolor sit amet"),
                new Header("Hello Java"),
                new Paragraph("sit amet ")
        );

        for (var part: document) {
            switch (part) {
                case Header(var content) -> System.out.println(content.toUpperCase());
                case Paragraph(var content) -> System.out.println(content);
            }
        }
    }
}
