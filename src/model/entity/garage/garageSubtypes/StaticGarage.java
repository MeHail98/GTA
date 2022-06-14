package model.entity.garage.garageSubtypes;

import model.entity.garage.Garage;
import model.entity.vehicle.Vehicle;

import static model.logic.garageLogic.GarageUtils.*;

public class StaticGarage extends Garage {
    private static final int DEFAULT_CAPACITY = 10;
    private Vehicle[] vehicles;

    public StaticGarage(Vehicle[] vehicles) {
        super(vehicles.length, countNotNulls(vehicles));
        this.vehicles = moveNulls(vehicles);
    }

    public StaticGarage() {
        vehicles = new Vehicle[DEFAULT_CAPACITY];
    }

    public StaticGarage(int capacity){
        vehicles = new Vehicle[capacity];
        super.capacity = capacity;
        numberOfVehicles = 0;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = moveNulls(vehicles);
        capacity = vehicles.length;
        numberOfVehicles = countNotNulls(vehicles);
    }

    public void add(Vehicle vehicle) {
        if (numberOfVehicles == capacity || vehicle == null) return;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = vehicle;
                numberOfVehicles++;
                break;
            }
        }
    }

    public void add (Vehicle...vehicles){
        if (numberOfVehicles + vehicles.length > this.vehicles.length) return;
        System.arraycopy(vehicles,0,this.vehicles,numberOfVehicles,vehicles.length);
        this.vehicles = moveNulls(this.vehicles);

        int notNulls = countNotNulls(vehicles);
        numberOfVehicles = numberOfVehicles + notNulls;
    }
}
