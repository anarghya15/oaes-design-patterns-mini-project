// AssessmentInstrumentMetadata class
public class AssessmentInstrumentMetadata {
    private String subject;
    private int numberOfQuestions;
    private int duration;
    private int totalMarks;

    public AssessmentInstrumentMetadata(String subject, int numberOfQuestions, int duration, int totalMarks) {
        this.subject = subject;
        this.numberOfQuestions = numberOfQuestions;
        this.duration = duration;
        this.totalMarks = totalMarks;
    }

    public String getSubject() {
        return subject;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public int getDuration() {
        return duration;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

}