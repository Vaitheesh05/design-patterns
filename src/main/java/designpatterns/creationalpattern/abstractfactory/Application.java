package designpatterns.creationalpattern.abstractfactory;

/**
 * The client code that uses the Abstract Factory.
 * The client doesn't know the concrete types of the products it gets.
 * It only knows that it gets a Transport and a Tracking object from the factory.
 */
public class Application {
    private final Transport transport;
    private final Tracking tracking;

    public Application(LogisticsFactory factory) {
        transport = factory.createTransport();
        tracking = factory.createTracking();
    }

    public void performLogistics() {
        transport.deliver();
        tracking.track();
    }

    public static void main(String[] args) {
        LogisticsFactory factory;
        String environment = "sea"; // or "road"

        if (environment.equalsIgnoreCase("road")) {
            factory = new RoadLogisticsFactory();
        } else if (environment.equalsIgnoreCase("sea")) {
            factory = new SeaLogisticsFactory();
        } else {
            throw new IllegalArgumentException("Unknown environment");
        }

        Application app = new Application(factory);
        app.performLogistics();
    }
}
