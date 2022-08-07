package controller.garageCreationController;

import controller.Controller;
import controller.Utils;
import model.entity.garage.Garage;
import model.logic.stream.serialization.DeserializationGarage;
import model.logic.stream.serialization.SerializationGarage;

import java.io.IOException;

public class ReadFileGarageCreationController {

    public static void serializeGarage(Garage garage){
        System.out.println("""
                
                Here you can serialize your garage. File will be created on your disk
                Make sure your file name meet following format: DiskName:/fileName.txt
                Make sure there is no blank spaces in your file name, then tap Enter
                Type file name:
                """);
        String fileName = Utils.scanConsole();
        SerializationGarage sg = new SerializationGarage(fileName);
        try{
            sg.serializeGarage(garage);
        } catch (IOException e){
            System.out.println("Looks like something wrong with your file name, please try again");
            serializeGarage(garage);
        }
        Controller.end();
    }

    public static void deserializeGarage(){
        System.out.println("""
                
                Here you can create your garage from file
                Make sure your file name meet following format: DiskName:/fileName.txt
                Make sure there is no blank spaces in your file name, then tap Enter
                Type file name:
                """);
        String fileName = Utils.scanConsole();
        Garage garage = null;
        try {
            garage = DeserializationGarage.deserializeGarage(fileName);
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Looks like something wrong with your file, please try again");
            deserializeGarage();
        }
        Controller.isGarageReady(garage);
    }
}
