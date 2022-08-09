package model.entity.garage;

import exception.logicException.garageException.CapacityException;
import exception.logicException.garageException.IndexException;
import exception.logicException.garageException.NullElementException;
import model.entity.vehicle.Vehicle;

import java.io.Serial;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public abstract class Garage implements Serializable, Iterable<Vehicle>{
    @Serial
    private static final long serialVersionUID = 1;
    protected int capacity;
    protected int numberOfVehicles;

    public Garage(int capacity, int numberOfVehicles) {
        this.capacity = capacity;
        this.numberOfVehicles = numberOfVehicles;
    }

    public Garage() {
        capacity = 0;
        numberOfVehicles = 0;
    }

    public abstract void add(Vehicle vehicle)throws NullElementException, CapacityException;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) throws CapacityException {
        if(capacity<numberOfVehicles) throw new CapacityException("Small capacity for this number of vehicles");
        this.capacity = capacity;
    }

    public abstract void remove(int index) throws IndexException;

    public abstract void remove(Vehicle vehicle) throws IndexException, NullElementException;

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public String toString(){
        return "capacity = " + capacity + ",number of vehicles = " + numberOfVehicles;
    }

    public Vehicle get(int index) throws IndexException {
        return null;
    }

    public Vehicle[] getVehicles(){
        return null;
    }

    public List<Vehicle> getVehicleList(){
        return null;
    }

    @Override
    public abstract Iterator<Vehicle> iterator();
}
