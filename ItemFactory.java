import java.util.ArrayList;
import java.util.UUID;

// ItemFactory class
public class ItemFactory {
    public static Item createItem(String type, ItemMetadata metadata) {
        if ("MCQ".equals(type)) {
            return new MCQItem(UUID.randomUUID().toString(), metadata, new ArrayList<>(), 0);
        } else if ("FillIn".equals(type)) {
            return new FillInItem(UUID.randomUUID().toString(), metadata, "");
        }
        throw new IllegalArgumentException("Unknown item type: " + type);
    }
}
