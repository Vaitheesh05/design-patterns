package designpatterns.creationalpattern.restaurantapp.model;

/**
 * ## Prototype Pattern ##
 * This interface declares the `clone` method. Any class that can be cloned will implement this interface.
 */
public interface CloneableMeal {
    CloneableMeal clone();
}
