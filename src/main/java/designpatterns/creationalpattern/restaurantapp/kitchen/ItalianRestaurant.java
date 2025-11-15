package designpatterns.creationalpattern.restaurantapp.kitchen;

/**
 * ## Factory Method Pattern ##
 * Concrete Creator 1: Implements the factory method to return an `ItalianMealFactory`.
 */
public class ItalianRestaurant extends Restaurant {
    @Override
    public MealFactory getMealFactory() {
        return new ItalianMealFactory();
    }
}
