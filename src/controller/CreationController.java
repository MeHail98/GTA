package controller;

import controller.garageCreationController.RandomGarageCreationController;
import controller.vehicleCreationController.ManualVehicleCreationController;
import controller.vehicleCreationController.RandomVehicleCreationController;
import controller.vehicleCreationController.ReadFileVehicleCreationController;
import exception.logicException.garageException.CapacityException;
import exception.logicException.garageException.IndexException;
import exception.logicException.garageException.NullElementException;
import model.entity.garage.Garage;
import model.entity.garage.garageSubtypes.DynamicGarage;
import model.entity.garage.garageSubtypes.StaticGarage;
import model.entity.vehicle.Vehicle;
import model.logic.comparator.HorsepowerCompareAsc;
import model.logic.comparator.PriceCompareAsc;
import model.logic.comparator.ReliabilityCompareAsc;
import model.logic.comparator.WeightCompareAsc;

import java.util.Arrays;

public class CreationController {

    public static void createGarageManually() {
        System.out.println("""
                Would you like your garage to be static or dynamic (possible to add infinite number of vehicles)
                1. Static - number of vehicles is restrained by it's capacity
                2. Dynamic - possible to add an infinite number of vehicles, the capacity will grow with it
                """);

        int input = Utils.inputCheck(2);
        switch (input) {
            case 1 -> createStaticGarage();
            case 2 -> createDynamicGarage();
        }
    }

    public static void createStaticGarage() {
        System.out.println("""
                Enter capacity of your garage(must be from 1 to 10)
                You can not expand it in the future
                Capacity: 
                """);

        int input = Utils.inputCheck(10);
        StaticGarage sg = new StaticGarage(input);
        createStaticGarage2(sg);
    }

    public static void createStaticGarage2(Garage garage) {
        System.out.println("""
                Would you like to fill your garage with randomly generated vehicles?
                1. Want to fulfill the capacity with randomly generated vehicles
                2. Want to create each vehicle manually               
                """);
        int input = Utils.inputCheck(2);
        switch (input) {
            case 1 -> RandomGarageCreationController.fulfillRandomly(garage, garage.getCapacity());
            case 2 -> createVehicle(garage);
        }
    }


    public static void createVehicle(Garage garage){
        System.out.println("Your garage capacity is: " + garage.getCapacity()+" and you have "
                + garage.getNumberOfVehicles() + " vehicles in it");
        System.out.println("""
                How would you like to add vehicle to your garage?
                1. Create vehicle manually
                2. Read vehicle from file
                3. Generate random vehicle
                4. See my garage
                """);
        int input = Utils.inputCheck(4);
        switch (input) {
            case 1 -> ManualVehicleCreationController.createVehicleManually(garage);
            case 2 -> ReadFileVehicleCreationController.readVehicleFromFile(garage);
            case 3 -> RandomVehicleCreationController.generateRandomVehicle(garage);
            case 4 -> Controller.isGarageReady(garage);
        }
    }

    public static void removeVehicle(Garage garage){
        if(garage.getNumberOfVehicles() <= 0){
            System.out.println("Looks like your garage doesn't have any vehicle in it");
            Controller.manageGarage(garage);
        }
        System.out.println("\nPlease choose vehicle you want to remove from your garage :");
        int count = 0;
        for (Vehicle vehicle: garage) {
            if(vehicle == null) break;
            count++;
            System.out.println(count + ". " + vehicle);
        }
        int input = Utils.inputCheck(garage.getNumberOfVehicles());
        try {
            garage.remove(input-1);
        } catch (IndexException e){
            System.out.println("Looks like something goes wrong, please try again");
            removeVehicle(garage);
        }
        if(Utils.isEnough(garage)) Controller.manageGarage(garage);
        else removeVehicle(garage);
    }


    /////
    ///// !!! проверить будет ли работать компаратор на обычном массиве
    ////
    public static void sortVehicles(Garage garage){
        System.out.println("""
                Please, choose how you want to sort your vehicles:
                1. Sort by horsepower
                2. Sort by price
                3. Sort by reliability
                4. Sort by weight """);
        int input = Utils.inputCheck(4);
        switch (input){
            case 1: {
                if(garage instanceof DynamicGarage) garage.getVehicleList().sort(new HorsepowerCompareAsc());
                else Arrays.sort(garage.getVehicles(), new HorsepowerCompareAsc());
            } break;
            case 2: {
                if(garage instanceof DynamicGarage) garage.getVehicleList().sort(new PriceCompareAsc());
                else Arrays.sort(garage.getVehicles(), new PriceCompareAsc());

            } break;
            case 3: {
                if(garage instanceof DynamicGarage) garage.getVehicleList().sort(new ReliabilityCompareAsc());
                else Arrays.sort(garage.getVehicles(), new ReliabilityCompareAsc());
            }
            case 4: {
                if(garage instanceof DynamicGarage) garage.getVehicleList().sort(new WeightCompareAsc());
                else Arrays.sort(garage.getVehicles(), new WeightCompareAsc());
            }
        }
        Controller.isGarageReady(garage);
    }


    public static boolean addVehicleToGarage(Garage garage, Vehicle vehicle){
        System.out.println("Here is your vehicle: " + vehicle);
        System.out.println("""
                Would you like to add this vehicle into your garage?
                1. Yes, Add into garage
                2. No, I want to create new vehicle
                """);
        int input = Utils.inputCheck(2);
        switch (input) {
            case 1: {
                try{
                    garage.add(vehicle);
                }catch (NullElementException e){
                    System.out.println("Something gone wrong, please try again");
                    return false;
                } catch (CapacityException e){
                    System.out.println("Looks like your garage is already full");
                    Controller.isGarageReady(garage);
                    return true;
                }
            } break;
            case 2: return false;
        }
        return true;
    }

    public static void createDynamicGarage(){
        System.out.println("""
                Enter "Initial" capacity of your garage(must be from 1 to 10) only if you want to fulfil randomly
                Your garage will expand as you add vehicle to it and decrease as you remove one               
                Initial capacity: 
                """);

        int input = Utils.inputCheck(10);
        DynamicGarage dg = new DynamicGarage();
        createDynamicGarage2(dg, input);
    }

    public static void createDynamicGarage2(Garage garage, int initialCapacity) {
        System.out.println("""
                Would you like to fill your garage with randomly generated vehicles?
                1. Want to fulfill the initial capacity with randomly generated vehicles
                2. Want to create each vehicle manually               
                """);
        int input = Utils.inputCheck(2);
        switch (input) {
            case 1 -> RandomGarageCreationController.fulfillRandomly(garage, initialCapacity);
            case 2 -> createVehicle(garage);
        }
    }
}
