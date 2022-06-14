package model.entity.garage;

public class Garage {
    protected int capacity;
    protected int numberOfVehicles;

    protected Garage(int capacity, int numberOfVehicles) {
        this.capacity = capacity;
        this.numberOfVehicles = numberOfVehicles;
    }

    protected Garage() {
        capacity = 0;
        numberOfVehicles = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if(capacity<numberOfVehicles) return;
        this.capacity = capacity;
    }

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public String toString(){
        return "capacity = " + capacity + ",number of vehicles = " + numberOfVehicles;
    }
}
