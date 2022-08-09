package controller.garageCreationController;

import controller.Controller;
import controller.CreationController;
import exception.logicException.garageException.CapacityException;
import exception.logicException.garageException.NullElementException;
import model.entity.garage.Garage;
import model.entity.garage.garageSubtypes.StaticGarage;
import model.logic.garageLogic.GarageBuilder.RandomGarageBuilder;

import java.util.Random;

public class RandomGarageCreationController {

    static Random random = new Random();

    public static void fulfillRandomly(Garage garage, int initialCapacity)  {
        try{
            RandomGarageBuilder.fulfillRandomly(garage, initialCapacity);
        } catch (NullElementException | CapacityException e){
            System.out.println("Something gone wrong, try again");
            if(garage instanceof StaticGarage){
                CreationController.createStaticGarage2(garage);
            } else CreationController.createDynamicGarage2(garage, initialCapacity);
        }
        Controller.isGarageReady(garage);
    }


    public static void generateRandomGarage(){
        Garage garage = RandomGarageBuilder.createRandomGarage(random.nextInt(1));
        Controller.isGarageReady(garage);
    }
}
