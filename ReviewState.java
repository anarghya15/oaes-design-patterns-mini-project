public class ReviewState implements AssessmentInstrumentState {
    AssessmentInstrument instrument;
    
    public ReviewState(AssessmentInstrument instrument) {
        this.instrument = instrument;
    }

    public void review() {
        // Already in review state
    }

    public void approve() {
        instrument.setState(instrument.getApprovedState());
    }
}