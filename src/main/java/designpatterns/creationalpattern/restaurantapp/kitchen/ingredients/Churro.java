package designpatterns.creationalpattern.restaurantapp.kitchen.ingredients;

import designpatterns.creationalpattern.restaurantapp.kitchen.Dessert;

public class Churro implements Dessert {
    @Override
    public void prepare() {
        System.out.println("Frying a sweet Churro with cinnamon sugar.");
    }
}
