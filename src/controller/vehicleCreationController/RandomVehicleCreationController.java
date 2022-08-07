package controller.vehicleCreationController;

import controller.CreationController;
import model.entity.garage.Garage;
import model.entity.vehicle.Vehicle;
import model.logic.vehicleLogic.vehicleBuilder.RandomVehicleBuilder;

public class RandomVehicleCreationController {

    public static void generateRandomVehicle(Garage garage){

        Vehicle vehicle = RandomVehicleBuilder.createRandomVehicle();
        if(!CreationController.addVehicleToGarage(garage,vehicle)) {
            generateRandomVehicle(garage);
        } else CreationController.createVehicle(garage);
    }
}
