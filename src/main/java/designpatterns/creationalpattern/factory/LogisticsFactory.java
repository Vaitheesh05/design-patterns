package designpatterns.creationalpattern.factory;

/**
 * This class demonstrates the Simple Factory pattern.
 * The Factory pattern is a creational design pattern that provides a way to create objects without exposing the creation logic to the client.
 * It defines an interface or abstract class for creating an object but lets subclasses decide which class to instantiate.
 *
 * <h2>Problem it Solves</h2>
 * The Factory pattern solves the problem of creating objects without specifying the exact class of object that will be created.
 * This decouples the client code from the concrete classes it needs to instantiate. If you have a block of code that needs to create
 * an object based on a certain condition (like the 'type' parameter here), a factory can encapsulate this logic.
 * This makes the code easier to maintain and extend. If a new type of Logistics is added, you only have to modify the factory, not all the places where logistics objects are created.
 *
 * <h2>Use Case (Simple Factory)</h2>
 * A Simple Factory centralizes object creation in one place. It's not one of the original "Gang of Four" design patterns, but it's a very common and useful idiom.
 * It typically consists of a single static method that takes a parameter and returns an instance of one of several possible classes.
 *
 * <h2>Example</h2>
 * In this example, `LogisticsFactory` is a simple factory. The `createLogistics` method takes a `type` string.
 * Based on this string, it decides whether to instantiate a `RoadLogistics` or a `SeaLogistics` object.
 * The client code (the `main` method in this case) doesn't need to know about the concrete classes (`RoadLogistics`, `SeaLogistics`).
 * It just asks the factory for a `Logistics` object of a certain type.
 */
public class LogisticsFactory {
    /**
     * Creates and returns a Logistics object based on the given type.
     * This is the factory method.
     *
     * @param type The type of logistics to create ("road" or "sea").
     * @return A concrete implementation of Logistics.
     * @throws IllegalArgumentException if the type is unknown.
     */
    public static Logistics createLogistics(String type) {
        if (type.equalsIgnoreCase("road")) {
            return new RoadLogistics();
        } else if (type.equalsIgnoreCase("sea")) {
            return new SeaLogistics();
        } else {
            throw new IllegalArgumentException("Unknown logistics type: " + type);
        }
    }

    public static void main(String[] args) {
        // The client requests a logistics object without knowing the concrete class.
        Logistics roadLogistics = LogisticsFactory.createLogistics("road");
        Logistics seaLogistics = LogisticsFactory.createLogistics("sea");

        System.out.println("--- Road Logistics ---");
        roadLogistics.deliver();
        roadLogistics.receive();
        roadLogistics.track();

        System.out.println("\n--- Sea Logistics ---");
        seaLogistics.deliver();
        seaLogistics.receive();
        seaLogistics.track();
    }
}
