public class ApprovedState implements AssessmentInstrumentState {
    AssessmentInstrument instrument;
    
    public ApprovedState(AssessmentInstrument instrument) {
        this.instrument = instrument;
    }

    public void review() {
        throw new IllegalStateException("Cannot review an approved instrument");
    }

    public void approve() {
        // Already approved
    }
}