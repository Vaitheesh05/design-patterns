package designpatterns.creationalpattern.restaurantapp.kitchen;

import designpatterns.creationalpattern.restaurantapp.kitchen.ingredients.Taco;
import designpatterns.creationalpattern.restaurantapp.kitchen.ingredients.Churro;

/**
 * ## Abstract Factory Pattern ##
 * Concrete Factory 2: Creates a family of Mexican dishes.
 */
public class MexicanMealFactory implements MealFactory {
    @Override
    public MainCourse createMainCourse() {
        return new Taco();
    }

    @Override
    public Dessert createDessert() {
        return new Churro();
    }
}
