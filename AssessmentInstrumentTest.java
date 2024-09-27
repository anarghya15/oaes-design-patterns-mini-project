import java.util.HashMap;
import java.util.Map;

public class AssessmentInstrumentTest {
    public static void main(String[] args) {
        // Create mock services
        DbService dbService = new MockPersistenceService();
        ItemBankManager itemBankManager = new MockItemBankManager();

        // Create AssessmentInstrumentManager
        AssessmentInstrumentManager manager = new AssessmentInstrumentManager(dbService, itemBankManager);

        // Test creating an assessment instrument
        AssessmentInstrumentMetadata metadata = new AssessmentInstrumentMetadata("Math", 10, 60, 100);
        AssessmentInstrument instrument = manager.createAssessmentInstrument(metadata);
        System.out.println("Created instrument with ID: " + instrument.getId());

        // Test getting an assessment instrument
        AssessmentInstrument retrievedInstrument = manager.getAssessmentInstrument(instrument.getId());
        System.out.println("Retrieved instrument: " + (retrievedInstrument != null ? "success" : "failure"));

        // Test updating an assessment instrument

        manager.updateAssessmentInstrument("user1", retrievedInstrument);
        System.out.println("Updated instrument successfully");

        // Test adding an item to the instrument

        ItemMetadata itemMetadata = new ItemMetadata("Math", "Algebra", "Medium");
        manager.addItem("user1", instrument.getId(), "MCQ", itemMetadata);
        System.out.println("Added item successfully");

        // Test reviewing the instrument

        manager.reviewAssessmentInstrument(instrument.getId(), "reviewer1");
        System.out.println("Instrument sent for review");

        // Add item after review should give exception
        try{
            itemMetadata = new ItemMetadata("Math", "Geometry", "Medium");
            manager.addItem("user1", instrument.getId(), "MCQ", itemMetadata);
            System.out.println("Added item successfully");
        }
        catch(Exception e){
            System.out.println("Test case #1 PASS: Could not add item during review");        
        }
        

        // Test approving the instrument
        manager.approveAssessmentInstrument(instrument.getId(), "approver1");
        System.out.println("Instrument approved");

        itemMetadata = new ItemMetadata("Math", "Geometry", "Medium");
        manager.addItem("user1", instrument.getId(), "MCQ", itemMetadata);
        System.out.println("Added item successfully");

        // Test deleting the instrument

        manager.deleteAssessmentInstrument("user1", instrument.getId());
        System.out.println("Instrument deleted");

    }

    // Mock implementations of services
    static class MockPersistenceService implements DbService {
        private Map<String, AssessmentInstrument> storage = new HashMap<>();

        public void save(AssessmentInstrument instrument) {
            storage.put(instrument.getId(), instrument);
        }

        public AssessmentInstrument getAssessmentInstrument(String id) {
            return storage.get(id);
        }

        public void update(AssessmentInstrument instrument) {
            storage.put(instrument.getId(), instrument);
        }

        public void delete(String id) {
            storage.remove(id);
        }
    }

    static class MockItemBankManager implements ItemBankManager {
        public Item getItem(String itemType, ItemMetadata itemMetadata) {
            return ItemFactory.createItem(itemType, itemMetadata);
        }
    }
}
