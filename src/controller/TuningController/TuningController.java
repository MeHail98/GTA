package controller.TuningController;

import controller.Controller;
import controller.Utils;
import controller.vehicleCreationController.ManualVehicleCreationController;
import controller.vehicleCreationController.RandomVehicleCreationController;
import controller.vehicleCreationController.ReadFileVehicleCreationController;
import exception.logicException.garageException.IndexException;
import exception.logicException.garageException.NullElementException;
import exception.logicException.partException.InappropriateValueException;
import exception.logicException.tunerException.BadBodyKitException;
import exception.logicException.tunerException.BadEngineKitException;
import exception.logicException.tunerException.ImpossibleToTuneException;
import model.entity.garage.Garage;
import model.entity.part.dye.Dye;
import model.entity.part.dye.DyeType;
import model.entity.tuning.kit.BodyKit;
import model.entity.tuning.kit.EngineKit;
import model.entity.tuning.tuneType.*;
import model.entity.vehicle.Vehicle;

import java.util.Random;
import java.util.Scanner;

public class TuningController {

    public static void chooseVehicleToTune(Garage garage){
        if(garage.getNumberOfVehicles() <1 ) {
            System.out.println("No vehicles in your garage");
            Controller.manageGarage(garage);
        }
        System.out.println("\nPlease choose vehicle you want to tune from your garage :");
        int count = 0;
        for (Vehicle vehicle: garage) {
            if(vehicle == null) break;
            count++;
            System.out.println(count + ". " + vehicle);
        }
        int input = Utils.inputCheck(garage.getNumberOfVehicles());
        try{
            Vehicle vehicle = garage.get(input-1);
            TuningList tuningList = new TuningList();
            chooseTuning(vehicle, tuningList, garage);
        } catch (IndexException e){
            System.out.println("Something gone wrong, please try again");
            chooseVehicleToTune(garage);
        }
    }

    public static void chooseTuning(Vehicle vehicle, TuningList tuningList, Garage garage) {
        System.out.println("""
                Here are types of tuning you can apply to your vehicle, please choose one
                1. Set body kit
                2. Set engine kit
                3. Repaint
                4. Reduce weight
                5. Manual engine overhaul (experimental)
                6. I want too see my garage
                """);
        int input = Utils.inputCheck(5);
        switch (input) {
            case 1 -> setBodyKit(vehicle, tuningList, garage);
            case 2 -> setEngineKit(vehicle,tuningList, garage);
            case 3 -> repaint(vehicle,tuningList, garage);
//            case 4 ->
            case 5 -> manualEngineOverhaul(vehicle,tuningList,garage);
            case 6 -> Controller.isGarageReady(garage);
        }
    }

    public static void setBodyKit(Vehicle vehicle, TuningList tuningList, Garage garage) {
        System.out.println("Choose type of body kit:");
        for (BodyKit bk : BodyKit.values()) {
            System.out.println(bk.ordinal() + 1 + ". " + bk.name());
        }
        int input = Utils.inputCheck(BodyKit.values().length);
        BodyKitSetter bodyKitSetter = new BodyKitSetter(vehicle, BodyKit.values()[input - 1]);
        try{
            tuningList.addTuning(bodyKitSetter);
            System.out.println("Your tuning: " + bodyKitSetter);
        } catch (ImpossibleToTuneException e){
            System.out.println("Looks like you already have this type of tuning in tuning list" +
                    ", please choose another one");
            chooseTuning(vehicle,tuningList,garage);
        }
        System.out.println("""
                Would you like to add something else?
                1. Yes
                2. No
                """);
        int input1 = Utils.inputCheck(2);
        switch (input1) {
            case 1 -> chooseTuning(vehicle, tuningList, garage);
            case 2 -> applyChanges(vehicle,tuningList, garage);
        }
    }

    public static void setEngineKit(Vehicle vehicle, TuningList tuningList, Garage garage) {
        System.out.println("Choose type of engine kit:");
        for (EngineKit ek : EngineKit.values()) {
            System.out.println(ek.ordinal() + 1 + ". " + ek.name());
        }
        int input = Utils.inputCheck(EngineKit.values().length);
        EngineKitSetter engineKitSetter = new EngineKitSetter(vehicle, EngineKit.values()[input - 1]);
        try{
            tuningList.addTuning(engineKitSetter);
            System.out.println("Your tuning: " + engineKitSetter);
        } catch (ImpossibleToTuneException e){
            System.out.println("Looks like you already have this type of tuning in tuning list" +
                    ", please choose another one");
            chooseTuning(vehicle,tuningList,garage);
        }
        System.out.println("""
                Would you like to add something else?
                1. Yes
                2. No
                """);
        int input1 = Utils.inputCheck(2);
        switch (input1) {
            case 1 -> chooseTuning(vehicle, tuningList, garage);
            case 2 -> applyChanges(vehicle,tuningList, garage);
        }
    }

    public static void repaint(Vehicle vehicle, TuningList tuningList, Garage garage) {
        System.out.println("Choose new colour:");
        for (DyeType dt : DyeType.values()) {
            System.out.println(dt.ordinal() + 1 + ". " + dt.name());
        }
        int input = Utils.inputCheck(DyeType.values().length);
        Repainter repainter = new Repainter(vehicle, new Dye(DyeType.values()[input - 1]));
        try{
            tuningList.addTuning(repainter);
        } catch (ImpossibleToTuneException e){
            System.out.println("Looks like you already have this type of tuning" +
                    ", please choose another one");
            chooseTuning(vehicle,tuningList,garage);
        }
        System.out.println("""
                Would you like to add something else?
                1. Yes
                2. No
                """);
        int input1 = Utils.inputCheck(2);
        switch (input1) {
            case 1 -> chooseTuning(vehicle, tuningList, garage);
            case 2 -> applyChanges(vehicle, tuningList, garage);
        }
    }

    public static void applyChanges(Vehicle vehicle, TuningList tuningList, Garage garage){
        System.out.println("Your tuning list: " + tuningList + "\nWould you like to apply?\n1.Yes\n2.No");
        int input = Utils.inputCheck(2);
        switch (input) {
            case 1 -> {
                int tuningCost = 0;
                for (TuneType tt : tuningList.getTuningList()) {
                    tuningCost += tt.getCost();
                    try {
                        tt.applyTuning();
                    } catch (InappropriateValueException | BadEngineKitException | BadBodyKitException
                            | ImpossibleToTuneException e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("You paid for tuning " + tuningCost);
                Controller.isGarageReady(garage);
            }
            case 2 -> chooseTuning(vehicle, tuningList, garage);
        }
    }

    public static void manualEngineOverhaul(Vehicle vehicle, TuningList tuningList, Garage garage){
        System.out.println("In your vehicle you have "+vehicle.getEngine());
        System.out.println("""
                It doesn't cost anything but it will reflect on your vehicle price if successful
                If you lucky you will do it, otherwise you will destroy your engine
                Type here horsepower you want to get from your engine
                """);
        Random random = new Random();
        int input = Utils.inputCheck(100000000);
        System.out.println("Looks like you want to get "+vehicle.getEngine().getEngineType().getName()
        +" with "+input+" horsepower. Are you sure?\n1.Yes");
        Utils.scanConsole();
        if(random.nextInt(100) < 30) {
            System.out.println("OOOps, looks like you are unlucky, vehicle has blown up" +
                    ", vehicle will be removed from your garage");
            try {
                garage.remove(vehicle);
                Controller.isGarageReady(garage);
            } catch (IndexException | NullElementException e) {
                System.out.println(e.getMessage());
            }
        }
        ManualOverhaul manualOverhaul = new ManualOverhaul(vehicle,input);
        try {
            manualOverhaul.applyTuning();
            System.out.println("Success! Your vehicle now: " + vehicle);
            Controller.isGarageReady(garage);
        } catch (InappropriateValueException e){
            try {
                garage.remove(vehicle);
                System.out.println("Looks like you blow up your engine due too much power" +
                        ", vehicle will be removed from your garage");
                Controller.isGarageReady(garage);
            }catch (IndexException | NullElementException r){
                System.out.println(r.getMessage());
            }
        } catch (ImpossibleToTuneException e){
            System.out.println("No engine in this vehicle, try again");
            chooseTuning(vehicle,tuningList,garage);
        }
        }
}
