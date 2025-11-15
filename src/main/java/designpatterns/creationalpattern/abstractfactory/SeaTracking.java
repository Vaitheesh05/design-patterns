package designpatterns.creationalpattern.abstractfactory;

/**
 * Concrete Product B2: Implements the Tracking interface for sea logistics.
 */
public class SeaTracking implements Tracking {
    @Override
    public void track() {
        System.out.println("Tracking shipment on the sea.");
    }
}
