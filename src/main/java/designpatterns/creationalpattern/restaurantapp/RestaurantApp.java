package designpatterns.creationalpattern.restaurantapp;

import designpatterns.creationalpattern.restaurantapp.model.Meal;
import designpatterns.creationalpattern.restaurantapp.kitchen.ItalianRestaurant;
import designpatterns.creationalpattern.restaurantapp.kitchen.MexicanRestaurant;
import designpatterns.creationalpattern.restaurantapp.kitchen.Restaurant;
import designpatterns.creationalpattern.restaurantapp.service.MenuService;

/**
 * This is the main client class that runs the restaurant application. It demonstrates how
 * all five major creational design patterns can work together in a project with a realistic
 * package structure.
 *
 * <h2>Project Structure and Design Pattern Responsibilities:</h2>
 *
 * <dl>
 *     <dt><b>restaurantapp.model</b></dt>
 *     <dd>
 *         Contains the core data structures of the application.
 *         <ul>
 *             <li><b>Builder Pattern:</b> The {@link designpatterns.creationalpattern.restaurantapp.model.Meal} class uses a static nested {@code MealBuilder} to construct complex meal objects step-by-step. This provides a readable and flexible way to create objects with many optional parts.</li>
 *             <li><b>Prototype Pattern:</b> The {@link designpatterns.creationalpattern.restaurantapp.model.Meal} class implements the {@code CloneableMeal} interface, allowing instances to be cloned. This is used for creating copies of pre-defined meals from the menu.</li>
 *         </ul>
 *     </dd>
 *
 *     <dt><b>restaurantapp.service</b></dt>
 *     <dd>
 *         Contains application-wide services.
 *         <ul>
 *             <li><b>Singleton Pattern:</b> The {@link designpatterns.creationalpattern.restaurantapp.service.MenuService} is a Singleton. This ensures there is only one instance of the menu service in the entire application, providing a single, global point of access to the restaurant's menu.</li>
 *         </ul>
 *     </dd>
 *
 *     <dt><b>restaurantapp.kitchen</b></dt>
 *     <dd>
 *         Represents the area where food is prepared and contains the factory-related logic.
 *         <ul>
 *             <li><b>Factory Method Pattern:</b> The abstract {@link designpatterns.creationalpattern.restaurantapp.kitchen.Restaurant} class defines a "factory method" (`getMealFactory()`). Subclasses like {@link designpatterns.creationalpattern.restaurantapp.kitchen.ItalianRestaurant} and {@link designpatterns.creationalpattern.restaurantapp.kitchen.MexicanRestaurant} implement this method to provide a specific factory, deferring the choice of which factory to create to the subclasses.</li>
 *             <li><b>Abstract Factory Pattern:</b> The {@code MealFactory} interface defines a contract for creating a family of related products (a main course and a dessert). Concrete factories like {@code ItalianMealFactory} implement this interface to produce items that belong to a specific cuisine (e.g., Pasta and Tiramisu), ensuring consistency.</li>
 *         </ul>
 *     </dd>
 * </dl>
 */
public class RestaurantApp {
    public static void main(String[] args) {
        System.out.println("--- Welcome to the Restaurant! ---\n");

        // ## Singleton Pattern Demonstration ##
        // We get the single instance of the MenuService to ensure we are using one, and only one, menu.
        System.out.println("1. Getting the menu...");
        MenuService menu = MenuService.getInstance();
        menu.listMeals();
        System.out.println();

        // ## Builder Pattern Demonstration ##
        // We use the MealBuilder to construct a complex custom meal object step-by-step.
        System.out.println("2. Building a custom meal...");
        Meal customMeal = new Meal.MealBuilder("Double Patty Burger")
                .withSideDish("Onion Rings")
                .withDrink("Milkshake")
                .withDessert("Cheesecake")
                .build();
        System.out.println("   Custom meal created: " + customMeal);
        System.out.println();

        // ## Prototype Pattern Demonstration ##
        // We get a pre-defined meal from the menu. Instead of the original, we get a clone.
        System.out.println("3. Ordering a pre-defined meal (and cloning it)...");
        Meal veggieMeal = menu.getMeal("VEGGIE_BURGER");
        System.out.println("   Original Veggie Meal from menu: " + veggieMeal);
        Meal customizedVeggieMeal = veggieMeal.clone();
        System.out.println("   Cloned and customized Veggie Meal: " + customizedVeggieMeal);
        System.out.println("   Are the two veggie meals the same object? " + (veggieMeal == customizedVeggieMeal));
        System.out.println();

        // ## Factory Method & Abstract Factory Demonstration ##
        // We decide which restaurant to use. The Restaurant's `serveMeal` method
        // calls its `getMealFactory` (Factory Method) to get the right factory (e.g., ItalianMealFactory).
        // This factory (Abstract Factory) is then used to create a family of related products (Pasta and Tiramisu).
        System.out.println("4. Ordering from different restaurants...");
        Restaurant italianRestaurant = new ItalianRestaurant();
        italianRestaurant.serveMeal();

        System.out.println();

        Restaurant mexicanRestaurant = new MexicanRestaurant();
        mexicanRestaurant.serveMeal();
    }
}
