package designpatterns.creationalpattern.restaurantapp.kitchen;

public abstract class Restaurant {

    /**
     * ## Factory Method Pattern ##
     * This is the "Factory Method". It lets subclasses decide which `MealFactory` to instantiate.
     */
    public abstract MealFactory getMealFactory();

    public void serveMeal() {
        MealFactory factory = getMealFactory();
        System.out.println("--- Serving a meal from the " + factory.getClass().getSimpleName().replace("MealFactory", "") + " kitchen ---");
        MainCourse main = factory.createMainCourse();
        Dessert dessert = factory.createDessert();
        main.prepare();
        dessert.prepare();
    }
}
