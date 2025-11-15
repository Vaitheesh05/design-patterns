package designpatterns.creationalpattern.abstractfactory;

/**
 * The Abstract Factory interface.
 * Declares a set of methods for creating a family of related products.
 * In this case, it's for creating a Transport object and a Tracking object.
 */
public interface LogisticsFactory {
    Transport createTransport();
    Tracking createTracking();
}
