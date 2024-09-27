// Main manager class
public class AssessmentInstrumentManager {
    private DbService persistenceService;
    private ItemBankManager itemBankManager;

    public AssessmentInstrumentManager(DbService persistenceService,
                                       ItemBankManager itemBankManager) {
        this.persistenceService = persistenceService;
        this.itemBankManager = itemBankManager;
    }

    public AssessmentInstrument createAssessmentInstrument(AssessmentInstrumentMetadata metadata) {
        System.out.println("Creating new Assessment Instrument");
        AssessmentInstrument instrument = new AssessmentInstrument(metadata);
        persistenceService.save(instrument);
        return instrument;
    }

    public AssessmentInstrument getAssessmentInstrument(String id) {
        System.out.println("Getting Assessment Instrument: " + id);
        return persistenceService.getAssessmentInstrument(id);
    }

    public void updateAssessmentInstrument(String userId, AssessmentInstrument instrument) {
        System.out.println("Updating Assessment Instrument: " + instrument.getId());
        persistenceService.update(instrument);
        
    }

    public void deleteAssessmentInstrument(String userId, String id) {
        System.out.println("Deleting Assessment Instrument: " + id);        
        persistenceService.delete(id);
        
    }

    public void reviewAssessmentInstrument(String id, String reviewerId) {
        System.out.println("Reviewing Assessment Instrument: " + id + " by reviewer: " + reviewerId);        
        AssessmentInstrument instrument = persistenceService.getAssessmentInstrument(id);
        instrument.setState(instrument.getReviewState());
        persistenceService.update(instrument);
    }

    public void approveAssessmentInstrument(String id, String approverId) {
        System.out.println("Approving Assessment Instrument: " + id + " by approver: " + approverId);        
        AssessmentInstrument instrument = persistenceService.getAssessmentInstrument(id);
        if (instrument.getState() instanceof DraftState) {
            throw new IllegalStateException("Cannot approve an instrument under draft");
        }
        instrument.setState(instrument.getApprovedState());
        persistenceService.update(instrument);
        
    }

    //TODO
    public void addItem(String userId, String instrumentId, String itemType, ItemMetadata itemMetadata) {
        System.out.println("Adding item to Assessment Instrument: " + instrumentId);        
        AssessmentInstrument instrument = persistenceService.getAssessmentInstrument(instrumentId);
        if (instrument.getState() instanceof ReviewState) {
            throw new IllegalStateException("Cannot modify an instrument under review");
        }
        Item item = itemBankManager.getItem(itemType, itemMetadata);
        instrument.addItem(item);
        persistenceService.update(instrument);
        
    }

    public void removeItem(String userId, String instrumentId, String itemId) {
        System.out.println("Removing item from Assessment Instrument: " + instrumentId);
        AssessmentInstrument instrument = persistenceService.getAssessmentInstrument(instrumentId);
        if (instrument.getState() instanceof ReviewState) {
            throw new IllegalStateException("Cannot modify an instrument under review");
        }
        instrument.removeItem(itemId);
        persistenceService.update(instrument);
        
    }
}