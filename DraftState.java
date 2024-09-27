public class DraftState implements AssessmentInstrumentState {
    AssessmentInstrument instrument;
    

    public DraftState(AssessmentInstrument instrument) {
        this.instrument = instrument;
    }

    public void review() {
        instrument.setState(instrument.getReviewState());
    }

    public void approve() {
        throw new IllegalStateException("Cannot approve a draft instrument");
    }
}