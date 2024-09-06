package document;

import java.util.List;

public class DocumentMain {

    public static void main(String[] args) {
        var document = List.of(
                new Part(Part.PartType.HEADER, "Hello Clean Code"),
                new Part(Part.PartType.PARAGRAPH, "lorem ipsum dolor sit amet"),
                new Part(Part.PartType.HEADER, "Hello Java"),
                new Part(Part.PartType.PARAGRAPH, "sit amet ")
        );

        for (var part : document) {
            switch (part.getType()) {
                case HEADER ->
                    System.out.println(part.getContent().toUpperCase());
                case PARAGRAPH ->
                    System.out.println(part.getContent());
            }
        }
    }
}
