package designpatterns.creationalpattern.factory;

public class SeaLogistics implements Logistics {
    @Override
    public void deliver() {
        System.out.println("Delivering by sea");
    }

    @Override
    public void receive() {
        System.out.println("Receiving by sea");
    }

    @Override
    public void track() {
        System.out.println("Tracking by sea");
    }
}
