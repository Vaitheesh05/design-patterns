package designpatterns.creationalpattern.abstractfactory;

/**
 * Concrete Factory 2: Implements the LogisticsFactory interface to create
 * a family of related products for sea logistics (Ship and SeaTracking).
 */
public class SeaLogisticsFactory implements LogisticsFactory {
    @Override
    public Transport createTransport() {
        return new Ship();
    }

    @Override
    public Tracking createTracking() {
        return new SeaTracking();
    }
}
