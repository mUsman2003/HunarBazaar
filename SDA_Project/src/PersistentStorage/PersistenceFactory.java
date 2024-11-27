package PersistentStorage;

public class PersistenceFactory {

    // Singleton instance
    private static PersistenceFactory instance = null;

    // Private constructor to prevent direct instantiation
    public PersistenceFactory() {}

    // Synchronized method to get the Singleton instance
    public static synchronized PersistenceFactory getInstance() {
        if (instance == null) {
            instance = new PersistenceFactory();
        }
        return instance;
    }

    // Factory method to create persistence handlers
    public PersistenceHandler createPersistenceHandler(String handlerType) {
        if (handlerType.equalsIgnoreCase("SQLServer")) {
            return new SQLServerHandler();
        } //else if (handlerType.equalsIgnoreCase("MySQL")) {
          //  return new MySQLHandler(); // Implement MySQLHandler similarly
        //} //else if (handlerType.equalsIgnoreCase("XML")) {
            //return new XMLPersistence();
    //    }
    else {
            throw new IllegalArgumentException("Unknown persistence type: " + handlerType);
        }
    }
}

