package designpatterns.creationalpattern.singleton;

/**
 * The Singleton design pattern is a creational pattern that ensures a class has only one instance and provides a global point of access to it.
 * This is useful when exactly one object is needed to coordinate actions across the system.
 *
 * <h2>Problem it solves</h2>
 * The Singleton pattern solves two problems at once:
 * <ol>
 *     <li><b>Ensuring a single instance:</b> It guarantees that a class has just a single instance. This is important when you have a shared resource like a database connection or a file, and you want to avoid conflicts.</li>
 *     <li><b>Providing a global access point:</b> It provides a global access point to that instance, making it accessible from anywhere in the code.</li>
 * </ol>
 *
 * <h2>Use Case</h2>
 * A classic example is a database connection pool. You want to have only one connection pool object to manage the connections.
 * Using the Singleton pattern, you can ensure that all parts of your application use the same connection pool.
 * Other examples include logger objects, configuration managers, and hardware interface accessors.
 *
 * <h2>Example</h2>
 * In this example, we demonstrate a multi-threaded environment where multiple threads try to get an instance of `DBInstance`.
 * The `DBInstance` class is implemented as a Singleton, so both threads will receive the exact same instance, which is verified by printing their hash codes.
 * This ensures that both threads are working with the same database connection instance.
 */
public class Singleton {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () ->{
            DBInstance db = DBInstance.getInstance();
            System.out.println(Thread.currentThread().getName() +"->"+ db.hashCode());
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();

    }
}
