package designpatterns.creationalpattern.singleton;

/**
 * This class is an example of the Singleton design pattern.
 * It uses the "Initialization-on-demand holder idiom", which is a thread-safe and lazy-initialized way to implement a Singleton.
 *
 * <h2>Implementation Details</h2>
 * <ul>
 *     <li><b>Private Constructor:</b> The constructor is private to prevent instantiation from other classes.</li>
 *     <li><b>Static Inner Class (DBInstanceHelper):</b> The magic happens here. The inner class `DBInstanceHelper` is not loaded into memory until the `getInstance()` method is called for the first time.</li>
 *     <li><b>Static Final Instance:</b> Inside the `DBInstanceHelper`, the `INSTANCE` is created. Since it's `final`, it's guaranteed to be created only once. The JVM ensures that the class loading is a serialized process, making this approach thread-safe without explicit synchronization.</li>
 *     <li><b>Public Static `getInstance()` Method:</b> This is the global access point to the Singleton instance.</li>
 * </ul>
 *
 * <h2>How Lazy Initialization and Thread-Safety Works Here</h2>
 * The magic lies in how the Java Virtual Machine (JVM) handles the loading of static inner classes. Here is the step-by-step breakdown:
 * <ol>
 *     <li><b>Lazy Loading:</b> When the `DBInstance` class is loaded, the inner class `DBInstanceHelper` is <strong>not</strong> loaded. The JVM only loads a class when it's actually needed. This is the "lazy" part.</li>
 *     <li><b>First Call to `getInstance()`:</b> The very first time any thread calls `DBInstance.getInstance()`, the code tries to access `DBInstanceHelper.INSTANCE`.</li>
 *     <li><b>Thread-Safe Class Initialization:</b> At this moment, the JVM loads and initializes the `DBInstanceHelper` class. The JVM specification guarantees that this initialization process is thread-safe. Even if multiple threads call `getInstance()` simultaneously, the JVM ensures only <strong>one</strong> thread initializes the class. The other threads will wait. During this one-time initialization, the static field `INSTANCE` is created by executing `new DBInstance()`. This is the only time the `new` keyword is ever called.</li>
 *     <li><b>Subsequent Calls:</b> After the helper class is initialized, for every subsequent call to `getInstance()`, the JVM simply returns the already created `INSTANCE`. The static initializer code is not run again.</li>
 * </ol>
 * In short, this pattern cleverly uses the JVM's own thread-safe class loading mechanism to achieve lazy and safe initialization without explicit `synchronized` blocks.
 * <p>
 * This approach is generally preferred over the double-checked locking approach because it's cleaner, easier to read, and guaranteed to be safe without the complexities of `volatile` and `synchronized` keywords.
 */
public class DBInstance {

    /**
     * The private constructor prevents direct instantiation of the class.
     */
    private DBInstance(){
    }

    /**
     * This static inner class holds the singleton instance.
     * It is loaded only when `getInstance()` is called, providing lazy initialization.
     */
    private static class DBInstanceHelper{
        private static final DBInstance INSTANCE = new DBInstance();
    }

    /**
     * Returns the single instance of the class.
     * @return The singleton `DBInstance` object.
     */
    public static DBInstance getInstance(){
        return DBInstanceHelper.INSTANCE;
    }
}
