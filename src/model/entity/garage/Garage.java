package model.entity.garage;

import exception.logicException.garageException.CapacityException;
import exception.logicException.garageException.NullElementException;
import model.entity.vehicle.Vehicle;

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

    public void add(Vehicle vehicle)throws NullElementException, CapacityException {

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) throws CapacityException {
        if(capacity<numberOfVehicles) throw new CapacityException("Small capacity for this number of vehicles");
        this.capacity = capacity;
    }

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public String toString(){
        return "capacity = " + capacity + ",number of vehicles = " + numberOfVehicles;
    }
}
