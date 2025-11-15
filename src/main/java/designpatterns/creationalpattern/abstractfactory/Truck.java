package designpatterns.creationalpattern.abstractfactory;

/**
 * Concrete Product A1: Implements the Transport interface for road logistics.
 */
public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by land in a truck.");
    }
}
