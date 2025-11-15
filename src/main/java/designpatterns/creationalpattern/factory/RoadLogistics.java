package designpatterns.creationalpattern.factory;

public class RoadLogistics implements Logistics {
    @Override
    public void deliver() {
        System.out.println("Delivering by road");
    }

    @Override
    public void receive() {
        System.out.println("Receiving by road");
    }

    @Override
    public void track() {
        System.out.println("Tracking by road");
    }
}
