package designpatterns.creationalpattern.abstractfactory;

/**
 * Abstract Product B: Defines the interface for a tracking object.
 * All concrete tracking types (like RoadTracking, SeaTracking) will implement this interface.
 */
public interface Tracking {
    void track();
}
