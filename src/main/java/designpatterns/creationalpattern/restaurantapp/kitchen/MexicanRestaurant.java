package designpatterns.creationalpattern.restaurantapp.kitchen;

/**
 * ## Factory Method Pattern ##
 * Concrete Creator 2: Implements the factory method to return a `MexicanMealFactory`.
 */
public class MexicanRestaurant extends Restaurant {
    @Override
    public MealFactory getMealFactory() {
        return new MexicanMealFactory();
    }
}
