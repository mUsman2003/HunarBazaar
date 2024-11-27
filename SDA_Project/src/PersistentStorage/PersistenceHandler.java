package PersistentStorage;
// Interface for persistence handlers
public interface PersistenceHandler {
    void saveData(String data);   // Save data to the storage
    String loadData();            // Load data from the storage
	void close();
}
