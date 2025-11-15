package designpatterns.creationalpattern.restaurantapp.kitchen;

import designpatterns.creationalpattern.restaurantapp.kitchen.ingredients.Pasta;
import designpatterns.creationalpattern.restaurantapp.kitchen.ingredients.Tiramisu;

/**
 * ## Abstract Factory Pattern ##
 * Concrete Factory 1: Creates a family of Italian dishes.
 */
public class ItalianMealFactory implements MealFactory {
    @Override
    public MainCourse createMainCourse() {
        return new Pasta();
    }

    @Override
    public Dessert createDessert() {
        return new Tiramisu();
    }
}
