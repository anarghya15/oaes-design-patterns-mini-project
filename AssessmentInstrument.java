import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AssessmentInstrument {
    private String id;
    private AssessmentInstrumentMetadata metadata;
    private List<Item> items;

    private DraftState draftState;
    private ReviewState reviewState;
    private ApprovedState approvedState;
    private AssessmentInstrumentState state;

    public AssessmentInstrument(AssessmentInstrumentMetadata metadata) {
        id = UUID.randomUUID().toString();
        this.metadata = metadata;
        items = new ArrayList<>();

        draftState = new DraftState(this);
        reviewState = new ReviewState(this);
        approvedState = new ApprovedState(this);
        state = draftState;
    }

    public String getId() {
        return id;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String itemId) {
        items.removeIf(item -> item.getId().equals(itemId));
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public void setState(AssessmentInstrumentState state) {
        this.state = state;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AssessmentInstrumentMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AssessmentInstrumentMetadata metadata) {
        this.metadata = metadata;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public AssessmentInstrumentState getState() {
        return state;
    }

    public DraftState getDraftState() {
        return draftState;
    }

    public void setDraftState(DraftState draftState) {
        this.draftState = draftState;
    }

    public ReviewState getReviewState() {
        return reviewState;
    }

    public void setReviewState(ReviewState reviewState) {
        this.reviewState = reviewState;
    }

    public ApprovedState getApprovedState() {
        return approvedState;
    }

    public void setApprovedState(ApprovedState approvedState) {
        this.approvedState = approvedState;
    }

    public void review(){
        state.review();
    }

    public void approve(){
        state.approve();
    }

}