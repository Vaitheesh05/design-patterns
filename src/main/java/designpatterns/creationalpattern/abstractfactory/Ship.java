package designpatterns.creationalpattern.abstractfactory;

/**
 * Concrete Product A2: Implements the Transport interface for sea logistics.
 */
public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by sea in a container ship.");
    }
}
