package designpatterns.creationalpattern.restaurantapp.kitchen;

/**
 * ## Abstract Factory Pattern ##
 * The Abstract Factory Interface. It declares methods for creating a family of related products.
 */
public interface MealFactory {
    MainCourse createMainCourse();
    Dessert createDessert();
}
