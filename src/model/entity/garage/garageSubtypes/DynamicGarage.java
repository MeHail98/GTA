package model.entity.garage.garageSubtypes;

import exception.logicException.garageException.IndexException;
import exception.logicException.garageException.NullElementException;
import model.entity.garage.Garage;
import model.entity.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static model.logic.garageLogic.GarageUtils.*;

public class DynamicGarage extends Garage {
    private List<Vehicle> vehicleList;

    public DynamicGarage(int initialCapacity) {
        super(initialCapacity,0);
        vehicleList = new ArrayList<>(initialCapacity);
    }

    public DynamicGarage() {
        vehicleList = new ArrayList<>();
    }

    public DynamicGarage (List<Vehicle> vehicleList){
        super(vehicleList.size(), vehicleList.size());
        this.vehicleList = vehicleList;
    }

    public DynamicGarage (Vehicle[] vehicleList){
        this.vehicleList = new ArrayList<>(List.of(removeNulls(vehicleList)));
        capacity = numberOfVehicles = this.vehicleList.size();
    }

    public List<Vehicle> getVehicles() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList){
        this.vehicleList = vehicleList;
        capacity = numberOfVehicles = vehicleList.size();
    }

    public void setVehicleList(Vehicle[] vehicleList){
        this.vehicleList = new ArrayList<>(List.of(removeNulls(vehicleList)));
        capacity = numberOfVehicles = this.vehicleList.size();
    }

    public Vehicle get (int index) throws IndexException {
        if(index>= vehicleList.size() || index<0) throw new IndexException("Index out of bounds");
        return vehicleList.get(index);
    }

    public void set(int index, Vehicle vehicle) throws IndexException, NullElementException {
        if(index>= vehicleList.size() || index<0) {
            throw new IndexException("Index out of bounds");
        } else if (vehicle == null){
            throw new NullElementException("Not valid element");
        } else {
            vehicleList.set(index, vehicle);
        }
    }

    public void remove(Vehicle vehicle) throws NullElementException{
        if (vehicle == null)  throw new NullElementException("Not valid element");
        vehicleList.remove(vehicle);
        capacity = numberOfVehicles = vehicleList.size();
    }

    public void remove(int index) throws IndexException {
        if (index >= vehicleList.size() || index < 0) {
            throw new IndexException("Index out of bounds");
        }
        vehicleList.remove(index);
        capacity = numberOfVehicles = vehicleList.size();
    }

    public void add(Vehicle vehicle) throws NullElementException {
        if (vehicle == null)  throw new NullElementException("Not valid element");
        vehicleList.add(vehicle);
        capacity = numberOfVehicles = vehicleList.size();
    }

    @Override
    public String toString(){
        if(numberOfVehicles == 0){
            return super.toString()+"\nGarage is empty";
        }
        StringBuilder builder = new StringBuilder();
        for (Vehicle vh:vehicleList) {
            builder.append(vh).append("\n");
        }
        return super.toString()+"\n"+builder;
    }
}
