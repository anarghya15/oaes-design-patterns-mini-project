// ItemMetadata class
public class ItemMetadata {
    private String subject;
    private String topic;
    private String difficultyLevel;

    public ItemMetadata(String subject, String topic, String difficultyLevel) {
        this.subject = subject;
        this.topic = topic;
        this.difficultyLevel = difficultyLevel;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    // Getters and setters
}