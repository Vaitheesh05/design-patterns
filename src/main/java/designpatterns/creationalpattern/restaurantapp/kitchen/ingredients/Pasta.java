package designpatterns.creationalpattern.restaurantapp.kitchen.ingredients;

import com.example.designpatterns.creationalpattern.restaurantapp.kitchen.MainCourse;

public class Pasta implements MainCourse {
    @Override
    public void prepare() {
        System.out.println("Preparing delicious Pasta.");
    }
}
