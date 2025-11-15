package designpatterns.creationalpattern.restaurantapp.kitchen.ingredients;

import designpatterns.creationalpattern.restaurantapp.kitchen.MainCourse;

public class Pasta implements MainCourse {
    @Override
    public void prepare() {
        System.out.println("Preparing delicious Pasta.");
    }
}
