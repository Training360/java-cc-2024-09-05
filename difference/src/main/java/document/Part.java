package document;

public class Part {

    enum PartType {HEADER, PARAGRAPH, LINK}

    private PartType type;

    private String content;

    public Part(PartType type, String content) {
        this.type = type;
        this.content = content;
    }

    public PartType getType() {
        return type;
    }

    public void setType(PartType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
