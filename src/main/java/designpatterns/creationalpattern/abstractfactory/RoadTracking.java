package designpatterns.creationalpattern.abstractfactory;

/**
 * Concrete Product B1: Implements the Tracking interface for road logistics.
 */
public class RoadTracking implements Tracking {
    @Override
    public void track() {
        System.out.println("Tracking shipment on the road.");
    }
}
