package designpatterns.creationalpattern.restaurantapp.kitchen.ingredients;

import com.example.designpatterns.creationalpattern.restaurantapp.kitchen.MainCourse;

public class Taco implements MainCourse {
    @Override
    public void prepare() {
        System.out.println("Assembling a spicy Taco.");
    }
}
