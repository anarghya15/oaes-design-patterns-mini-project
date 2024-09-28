import java.util.ArrayList;
import java.util.UUID;

// ItemFactory class
public class ItemFactory {
    public static Item createItem(String type, ItemMetadata metadata) {
        if ("MCQ".equals(type)) {
            return new MCQItem(UUID.randomUUID().toString().substring(0, 8), metadata, new ArrayList<>(), 0);
        } else if ("FillIn".equals(type)) {
            return new FillInItem(UUID.randomUUID().toString().substring(0, 8), metadata, "");
        }
        throw new IllegalArgumentException("Unknown item type: " + type);
    }
}
