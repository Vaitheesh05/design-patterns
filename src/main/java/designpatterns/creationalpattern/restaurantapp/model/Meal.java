package designpatterns.creationalpattern.restaurantapp.model;

/**
 * The main "Product" class in our application.
 */
public class Meal implements CloneableMeal {
    private final String mainCourse;
    private final String sideDish;
    private final String drink;
    private final String dessert;

    /**
     * ## Builder Pattern ##
     * The constructor is private, forcing object creation through the `MealBuilder`.
     */
    private Meal(MealBuilder builder) {
        this.mainCourse = builder.mainCourse;
        this.sideDish = builder.sideDish;
        this.drink = builder.drink;
        this.dessert = builder.dessert;
    }

    /**
     * ## Prototype Pattern ##
     * By implementing `clone()`, we can create copies of existing meal objects.
     */
    @Override
    public Meal clone() {
        return new MealBuilder(this.mainCourse)
                .withSideDish(this.sideDish)
                .withDrink(this.drink)
                .withDessert(this.dessert)
                .build();
    }

    // Getters and other methods...
    @Override
    public String toString() {
        return "Meal [Main Course=" + mainCourse + ", Side Dish=" + sideDish + ", Drink=" + drink + ", Dessert=" + dessert + "]";
    }

    /**
     * ## Builder Pattern ##
     * The static nested Builder class for constructing a Meal.
     */
    public static class MealBuilder {
        private final String mainCourse;
        private String sideDish = "Fries";
        private String drink = "Water";
        private String dessert;

        public MealBuilder(String mainCourse) {
            this.mainCourse = mainCourse;
        }

        public MealBuilder withSideDish(String sideDish) {
            this.sideDish = sideDish;
            return this;
        }

        public MealBuilder withDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public MealBuilder withDessert(String dessert) {
            this.dessert = dessert;
            return this;
        }

        public Meal build() {
            return new Meal(this);
        }
    }
}
