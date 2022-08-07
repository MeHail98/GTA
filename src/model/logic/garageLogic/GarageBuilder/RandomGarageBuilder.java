package model.logic.garageLogic.GarageBuilder;

import exception.logicException.garageException.CapacityException;
import exception.logicException.garageException.NullElementException;
import model.entity.garage.Garage;
import model.entity.garage.garageSubtypes.DynamicGarage;
import model.entity.garage.garageSubtypes.StaticGarage;
import model.entity.vehicle.Vehicle;
import model.logic.vehicleLogic.vehicleBuilder.RandomVehicleBuilder;

import java.util.Random;

import static model.logic.vehicleLogic.vehicleBuilder.RandomVehicleBuilder.createRandomVehicle;

public class RandomGarageBuilder {

    private static final int MAX_CAPACITY = 10;
    private static final transient Random random = new Random();

    public static Garage createRandomGarage(int type){
        Garage garage;
        int capacity = random.nextInt(MAX_CAPACITY+1);
        if (type == 1) {
            garage = new DynamicGarage(capacity);
        } else {
            garage = new StaticGarage(capacity);
        }
        for (int i = 0; i < capacity; i++) {
            try {
                garage.add(createRandomVehicle());
            } catch (NullElementException | CapacityException e){
                return null;
            }
        }
        return garage;
    }

    public static void fulfillRandomly(Garage garage, int capacity) throws NullElementException, CapacityException{
        for (int i = garage.getNumberOfVehicles(); i < capacity; i++) {
            Vehicle vehicle = RandomVehicleBuilder.createRandomVehicle();
            garage.add(vehicle);
        }
    }
}
