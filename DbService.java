// External service interfaces (stubs)
public interface DbService {
    void save(AssessmentInstrument instrument);
    AssessmentInstrument getAssessmentInstrument(String id);
    void update(AssessmentInstrument instrument);
    void delete(String id);
}