package designpatterns.creationalpattern.restaurantapp.kitchen.ingredients;

import designpatterns.creationalpattern.restaurantapp.kitchen.MainCourse;

public class Taco implements MainCourse {
    @Override
    public void prepare() {
        System.out.println("Assembling a spicy Taco.");
    }
}
