package model.entity.garage.garageSubtypes;

import exception.logicException.garageException.CapacityException;
import exception.logicException.garageException.IndexException;
import exception.logicException.garageException.NullElementException;
import model.entity.garage.Garage;
import model.entity.vehicle.Vehicle;

import static model.logic.garageLogic.GarageUtils.*;

public class StaticGarage extends Garage implements Iterable<Vehicle> {
    private static final int DEFAULT_CAPACITY = 10;
    private Vehicle[] vehicleArray;

    public StaticGarage(int capacity) {
        super(capacity,0);
        vehicleArray = new Vehicle[capacity];
    }

    public StaticGarage() {
        super(DEFAULT_CAPACITY,0);
        vehicleArray = new Vehicle[DEFAULT_CAPACITY];
    }

    public StaticGarage (Vehicle[] vehicleArray){
        this.vehicleArray = moveNulls(vehicleArray);
        capacity = vehicleArray.length;
        numberOfVehicles = countNotNulls(vehicleArray);
    }

    public Vehicle[] getVehicles() {
        return vehicleArray;
    }

    public void setVehicleArray(Vehicle[] vehicleArray) throws CapacityException{
        if(countNotNulls(vehicleArray)>capacity) throw new CapacityException("Too many elements for this capacity");
        this.vehicleArray = moveNulls(vehicleArray,capacity);
        numberOfVehicles = countNotNulls(vehicleArray);
    }

    public void setVehicle(int index, Vehicle vehicle) throws IndexException, NullElementException {
        if (index < 0 || index >= capacity) {
            throw new IndexException("Not valid index");
        } else if(vehicle == null){
            throw new NullElementException("Not valid element");
        } else{
            vehicleArray[index] = vehicle;
        }
    }

    public void add(Vehicle vehicle) throws NullElementException, CapacityException {
        if(vehicle == null) throw new NullElementException("Not valid element");
        if(numberOfVehicles<capacity){
            vehicleArray[numberOfVehicles] = vehicle;
            numberOfVehicles++;
        } else{
            throw new CapacityException("Too many elements for this capacity");
        }
    }

    public void remove (Vehicle vehicle) throws IndexException{
        for (int i = 0; i < capacity; i++) {
            if (vehicleArray[i] ==vehicle) {
                try{
                    remove(i);
                } catch (IndexException e){
                    throw new IndexException("Something went wrong");
                }
            }
        }
    }

    public void remove(int index) throws IndexException {
        if (index == capacity - 1) vehicleArray[index] = null;
        if (index < 0 || index >= capacity) {
            throw new IndexException("Not valid index");
        } else {
            System.arraycopy(vehicleArray, index + 1, vehicleArray, index, capacity - index - 1);
            vehicleArray[numberOfVehicles - 1] = null;
            numberOfVehicles--;
        }
    }

    @Override
    public String toString(){
        if(numberOfVehicles == 0){
            return super.toString()+"\nGarage is empty";
        }
        StringBuilder builder = new StringBuilder();
        for (Vehicle vh:vehicleArray) {
            builder.append(vh).append("\n");
        }
        return super.toString()+"\n"+builder;
    }

    @Override
    public java.util.Iterator<Vehicle> iterator() {
        return new Iterator(0,vehicleArray);
    }

    static class Iterator implements java.util.Iterator<Vehicle> {

        Vehicle[] array;
        int current;

        private Iterator(int current, Vehicle[] array){
            this.current = current;
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return current< array.length;
        }

        @Override
        public Vehicle next() {
            return array[current++];
        }
    }
}
