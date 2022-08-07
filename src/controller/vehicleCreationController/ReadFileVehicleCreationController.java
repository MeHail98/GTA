package controller.vehicleCreationController;

import controller.Controller;
import controller.CreationController;
import controller.Utils;
import exception.logicException.garageException.IndexException;
import exception.logicException.partException.InappropriateValueException;
import exception.techException.FileNotFoundException;
import model.entity.garage.Garage;
import model.entity.vehicle.Vehicle;
import model.logic.stream.simpleParsing.VehicleReader;
import model.logic.stream.simpleParsing.VehicleWriter;

import java.io.IOException;

public class ReadFileVehicleCreationController {


    public static void readVehicleFromFile(Garage garage){
        System.out.println("""
                
                Here you can read your vehicle from file
                Make sure your file name meet following format: DiskName:/fileName.txt
                Make sure there is no blank spaces in your file name, then tap Enter
                Type file name:
                """);
        String fileName = Utils.scanConsole();
        Vehicle vehicle = null;
        try{
            vehicle = VehicleReader.readVehicle(fileName);
        } catch (IOException e){
            System.out.println("Looks like your file name has inappropriate format, please try again");
            readVehicleFromFile(garage);
        } catch (InappropriateValueException e){
            System.out.println("Looks like your file has inappropriate values, please try again");
            readVehicleFromFile(garage);
        }
        if(!CreationController.addVehicleToGarage(garage,vehicle)){
            readVehicleFromFile(garage);
        }else {
            CreationController.createVehicle(garage);
        }
    }

    public static void writeVehicleInFile(Garage garage){
        System.out.println("\nPlease choose vehicle you want to write from your garage :");
        int count = 0;
        for (Vehicle vehicle: garage) {
            if(vehicle == null) break;
            count++;
            System.out.println(count + ". " + vehicle);
        }
        int input = Utils.inputCheck(garage.getNumberOfVehicles());
        System.out.println("""

                File will be created on your disk. Make sure your file name meet following format: DiskName:/fileName.txt
                Make sure there is no blank spaces in your file name, then tap Enter
                Type file name:
                """);
        String fileName = Utils.scanConsole();
        VehicleWriter vw = new VehicleWriter(fileName);
        try{
            vw.writeVehicle(garage.get(input-1));
        } catch (IndexException e){
            System.out.println("Index out of bounds");
        } catch (FileNotFoundException e){
            System.out.println("Looks like your file path is incorrect, please try again");
            writeVehicleInFile(garage);
        }
        Controller.end();
    }
}
