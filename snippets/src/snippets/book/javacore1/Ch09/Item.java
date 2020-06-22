package snippets.book.javacore1.Ch09;

import java.util.Objects;

public class Item implements Comparable<Item> {
    private int partNumber;
    private String description;

    public Item(String description, int partNumber) {
        this.partNumber = partNumber;
        this.description = description;
    }

    @Override
    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }

    @Override
    public String toString() {
        return "[description=" + description + ",partNumber=" + partNumber + "]";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject)
            return true;
        if (otherObject == null)
            return false;
        if (getClass() != otherObject.getClass())
            return false;
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description) && partNumber == other.partNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public String getDescription() {
        return this.description;
    }
}
