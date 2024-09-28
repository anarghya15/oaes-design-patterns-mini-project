// Main manager class
public class AssessmentInstrumentManager {
    private DbService dbService;
    private ItemBankManager itemBankManager;

    public AssessmentInstrumentManager(DbService dbService,
                                       ItemBankManager itemBankManager) {
        this.dbService = dbService;
        this.itemBankManager = itemBankManager;
    }

    public AssessmentInstrument createAssessmentInstrument(AssessmentInstrumentMetadata metadata) {
        System.out.println("Creating new Assessment Instrument");
        AssessmentInstrument instrument = new AssessmentInstrument(metadata);
        dbService.save(instrument);
        return instrument;
    }

    public AssessmentInstrument getAssessmentInstrument(String id) {
        System.out.println("Getting Assessment Instrument: " + id);
        return dbService.getAssessmentInstrument(id);
    }

    public void updateAssessmentInstrument(String userId, AssessmentInstrument instrument) {
        System.out.println("Updating Assessment Instrument: " + instrument.getId() + "by user: " + userId);
        dbService.update(instrument);
        
    }

    public void deleteAssessmentInstrument(String userId, String id) {
        System.out.println("Deleting Assessment Instrument: " + id);        
        dbService.delete(id);
        
    }

    public void reviewAssessmentInstrument(String id, String reviewerId) {
        System.out.println("Reviewing Assessment Instrument: " + id + " by reviewer: " + reviewerId);        
        AssessmentInstrument instrument = dbService.getAssessmentInstrument(id);
        instrument.setState(instrument.getReviewState());
        dbService.update(instrument);
    }

    public void approveAssessmentInstrument(String id, String approverId) {
        System.out.println("Approving Assessment Instrument: " + id + " by approver: " + approverId);        
        AssessmentInstrument instrument = dbService.getAssessmentInstrument(id);
        if (instrument.getState() instanceof DraftState) {
            throw new IllegalStateException("Cannot approve an instrument under draft");
        }
        instrument.setState(instrument.getApprovedState());
        dbService.update(instrument);
        
    }

    //TODO
    public void addItem(String userId, String instrumentId, String itemType, ItemMetadata itemMetadata) {
        System.out.println("Adding item to Assessment Instrument: " + instrumentId+ "by user: " + userId);        
        AssessmentInstrument instrument = dbService.getAssessmentInstrument(instrumentId);
        if (instrument.getState() instanceof ReviewState) {
            throw new IllegalStateException("Cannot modify an instrument under review");
        }
        Item item = itemBankManager.getItem(itemType, itemMetadata);
        instrument.addItem(item);
        dbService.update(instrument);
        
    }

    public void removeItem(String userId, String instrumentId, String itemId) {
        System.out.println("Removing item from Assessment Instrument: " + instrumentId+ "by user: " + userId);
        AssessmentInstrument instrument = dbService.getAssessmentInstrument(instrumentId);
        if (instrument.getState() instanceof ReviewState) {
            throw new IllegalStateException("Cannot modify an instrument under review");
        }
        instrument.removeItem(itemId);
        dbService.update(instrument);
        
    }
}