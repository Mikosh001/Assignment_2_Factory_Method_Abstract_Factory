package factorymethod;

public class Truck implements Transport {
    @Override
    public void deliver(String cargo, String destination) {
        System.out.println("Truck delivers " + cargo + " to " + destination + " by road");
    }
}
