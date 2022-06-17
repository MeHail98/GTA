package model.logic.garageLogic;

import model.entity.vehicle.Vehicle;

public class GarageUtils {
     public static Vehicle[] moveNulls(Vehicle[] vehicles){
        Vehicle[] newArray = new Vehicle[vehicles.length];
        int index = 0;
        for (Vehicle vehicle:vehicles) {
            if (vehicle != null) newArray[index++] = vehicle;
        }
        return newArray;
    }

    public static Vehicle[] moveNulls(Vehicle[] vehicles, int capacity){
        Vehicle[] newArray = new Vehicle[capacity];
        int index = 0;
        for (Vehicle vehicle:vehicles) {
            if (vehicle != null) newArray[index++] = vehicle;
        }
        return newArray;
    }

     public static Vehicle[] removeNulls(Vehicle[] vehicles){
        Vehicle[] newArray = new Vehicle[countNotNulls(vehicles)];
        int index = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) newArray[index++] = vehicle;
        }
        return newArray;
    }

     public static int countNotNulls(Vehicle[] vehicles){
        int c=0;
        for (Vehicle vehicle: vehicles) {
            if(vehicle != null) c++;
        }
        return c;
    }
}
