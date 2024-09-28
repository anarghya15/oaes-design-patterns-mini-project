public abstract class Item {
    ItemMetadata metadata;
    abstract String getId();
    abstract String getType();
    abstract ItemMetadata getMetadata();
}