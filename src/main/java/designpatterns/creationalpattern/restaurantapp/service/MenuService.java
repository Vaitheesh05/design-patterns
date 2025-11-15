package designpatterns.creationalpattern.restaurantapp.service;

import designpatterns.creationalpattern.restaurantapp.model.Meal;
import java.util.HashMap;
import java.util.Map;

/**
 * ## Singleton Pattern ##
 * This service class is implemented as a Singleton to ensure only one instance of the menu exists.
 */
public class MenuService {
    private static final MenuService INSTANCE = new MenuService();
    private final Map<String, Meal> mealPrototypes = new HashMap<>();

    private MenuService() {
        mealPrototypes.put("VEGGIE_BURGER", new Meal.MealBuilder("Veggie Patty").withSideDish("Salad").withDrink("Juice").build());
        mealPrototypes.put("CHICKEN_BURGER", new Meal.MealBuilder("Chicken Patty").withSideDish("Fries").withDrink("Coke").build());
        mealPrototypes.put("FISH_COMBO", new Meal.MealBuilder("Fish Fillet").withSideDish("Coleslaw").withDrink("Sprite").withDessert("Ice Cream").build());
    }

    public static MenuService getInstance() {
        return INSTANCE;
    }

    /**
     * ## Prototype Pattern ##
     * This method acts as a registry. When a meal is requested, we clone the prototype.
     */
    public Meal getMeal(String mealName) {
        Meal prototype = mealPrototypes.get(mealName);
        return (prototype != null) ? (Meal) prototype.clone() : null;
    }

    public void listMeals() {
        System.out.println("--- Restaurant Menu ---");
        mealPrototypes.keySet().forEach(System.out::println);
        System.out.println("-----------------------");
    }
}
