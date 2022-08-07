package controller;

import controller.garageCreationController.RandomGarageCreationController;
import controller.garageCreationController.ReadFileGarageCreationController;
import controller.vehicleCreationController.ReadFileVehicleCreationController;
import model.entity.garage.Garage;

public class Controller {

    public static void start() {

        System.out.println("""
                Hello, here you can create your garage and modify vehicles in it!
                How would you like to start? (Type a number)
                1. Create new garage manually
                2. Read from file (if you already have one)
                3. Generate random garage with random number of vehicles in it
                """);

        int input = Utils.inputCheck(3);
        switch (input) {
            case 1 -> CreationController.createGarageManually();
            case 2 -> ReadFileGarageCreationController.deserializeGarage();
            case 3 -> RandomGarageCreationController.generateRandomGarage();
        }
    }

    public static void manageGarage(Garage garage) {
        System.out.println("""
                What would you like to do:
                1. Remove vehicle
                2. Add vehicle
                3. Sort vehicles
                4. Tune vehicle
                5. My garage is ready
                """);
        int input = Utils.inputCheck(5);
        switch (input) {
            case 1 -> CreationController.removeVehicle(garage);
            case 2 -> CreationController.createVehicle(garage);
            case 3 -> CreationController.sortVehicles(garage);
//            case 4 ->
            case 5 -> isGarageReady(garage);
    }
}

    public static void isGarageReady(Garage garage) {
        System.out.println("Here is your garage :\n" + garage);
        System.out.println("""
                Would you like to leave it and serialize/write in file
                1. I want to continue managing my garage
                2. I want to write vehicle in txt file
                3. I want to serialize garage
                4. I want to stop this program              
                """);
        int input = Utils.inputCheck(4);
        switch (input) {
            case 1 -> manageGarage(garage);
            case 2 -> ReadFileVehicleCreationController.writeVehicleInFile(garage);
            case 3 -> ReadFileGarageCreationController.serializeGarage(garage);
            case 4 -> Controller.end();
        }
    }

    public static void end(){
        System.out.println("""
                Looks like that's it!
                You can restart the program if you want
                1. Restart the program
                2. Stop it
                """);
        int input = Utils.inputCheck(2);
        switch (input) {
            case 1 -> start();
            case 2 -> System.exit(0);
        }
    }
    }

