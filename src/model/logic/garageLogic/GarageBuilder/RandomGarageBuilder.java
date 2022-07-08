package model.logic.garageLogic.GarageBuilder;

import exception.logicException.garageException.CapacityException;
import exception.logicException.garageException.NullElementException;
import model.entity.garage.Garage;
import model.entity.garage.garageSubtypes.DynamicGarage;
import model.entity.garage.garageSubtypes.StaticGarage;

import java.util.Random;

import static model.logic.vehicleLogic.vehicleBuilder.RandomVehicleBuilder.createRandomVehicle;

public class RandomGarageBuilder {

    private static final int MAX_CAPACITY = 10;
    private static final transient Random random = new Random();

    public static Garage createRandomGarage(){
        int type = random.nextInt(2);
        Garage garage;
        if (type == 1) {
            garage = new DynamicGarage(random.nextInt(MAX_CAPACITY+1));
        } else {
            garage = new StaticGarage(random.nextInt(MAX_CAPACITY+1));
        }
        for (int i = 0; i < garage.getCapacity(); i++) {
            try {
                garage.add(createRandomVehicle());
            } catch (NullElementException | CapacityException e){
                return null;
            }
        }
        return garage;
    }
}
