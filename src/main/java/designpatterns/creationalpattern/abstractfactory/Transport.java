package designpatterns.creationalpattern.abstractfactory;

/**
 * Abstract Product A: Defines the interface for a transport object.
 * All concrete transport types (like Truck, Ship) will implement this interface.
 */
public interface Transport {
    void deliver();
}
