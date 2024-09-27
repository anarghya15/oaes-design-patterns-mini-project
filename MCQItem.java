import java.util.List;

public class MCQItem implements Item {
    private String id;
    private ItemMetadata metadata;
    private List<String> options;
    private int correctOption;

    public MCQItem(String id, ItemMetadata metadata, List<String> options, int correctOption) {
        this.id = id;
        this.metadata = metadata;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return "MCQ";
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

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }

}