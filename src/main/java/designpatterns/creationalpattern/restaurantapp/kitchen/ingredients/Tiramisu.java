package designpatterns.creationalpattern.restaurantapp.kitchen.ingredients;

import designpatterns.creationalpattern.restaurantapp.kitchen.Dessert;

public class Tiramisu implements Dessert {
    @Override
    public void prepare() {
        System.out.println("Preparing classic Tiramisu.");
    }
}
