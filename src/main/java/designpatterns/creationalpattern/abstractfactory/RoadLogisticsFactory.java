package designpatterns.creationalpattern.abstractfactory;

/**
 * Concrete Factory 1: Implements the LogisticsFactory interface to create
 * a family of related products for road logistics (Truck and RoadTracking).
 */
public class RoadLogisticsFactory implements LogisticsFactory {
    @Override
    public Transport createTransport() {
        return new Truck();
    }

    @Override
    public Tracking createTracking() {
        return new RoadTracking();
    }
}
