package models;

public class category {
    private static category instance; // Singleton instance
    private int value; // The value the class stores

    // Private constructor to prevent direct instantiation
    private category() {
        this.value = 0; // Default value
    }

    // Public method to get the singleton instance
    public static category getInstance() {
        if (instance == null) {
            instance = new category();
        }
        return instance;
    }

    // Getter for value
    public int getValue() {
        return value;
    }

    // Setter for value
    public void setValue(int value) {
        this.value = value;
    }

    // Method to delete the singleton instance
    public static void deleteInstance() {
        instance = null;
    }
}
