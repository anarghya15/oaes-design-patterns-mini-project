public class FillInItem implements Item {
    private String id;
    private ItemMetadata metadata;
    private String correctAnswer;

    public FillInItem(String id, ItemMetadata metadata, String correctAnswer) {
        this.id = id;
        this.metadata = metadata;
        this.correctAnswer = correctAnswer;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return "FillIn";
    }

    public ItemMetadata getMetadata() {
        return metadata;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMetadata(ItemMetadata metadata) {
        this.metadata = metadata;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    // Getter for correctAnswer
}