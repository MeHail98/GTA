package controller.vehicleCreationController;

import controller.CreationController;
import controller.Utils;
import exception.logicException.partException.InappropriateValueException;
import model.entity.garage.Garage;
import model.entity.part.body.Body;
import model.entity.part.body.BodyType;
import model.entity.part.dye.Dye;
import model.entity.part.dye.DyeType;
import model.entity.part.engine.Engine;
import model.entity.part.engine.EngineType;
import model.entity.part.wheel.Wheel;
import model.entity.part.wheel.WheelType;
import model.entity.vehicle.Vehicle;

public class ManualVehicleCreationController {

    public static void createVehicleManually(Garage garage){
        System.out.println("Pick body type from following:");
        for (BodyType bt: BodyType.values()){
            System.out.println(bt.ordinal()+1 +". "+ bt.name());
        }
        int bodyType = Utils.inputCheck(BodyType.values().length)-1;
        System.out.println("Pick engine type from following:");
        for (EngineType et: EngineType.values()){
            System.out.println(et.ordinal()+1 +". "+ et.name());
        }
        int engineType = Utils.inputCheck(EngineType.values().length)-1;
        System.out.println("Pick wheel type from following:");
        for (WheelType wt: WheelType.values()){
            System.out.println(wt.ordinal()+1 +". "+ wt.name());
        }
        int wheelType = Utils.inputCheck(WheelType.values().length)-1;
        System.out.println("Pick dye from following:");
        for (DyeType dt: DyeType.values()){
            System.out.println(dt.ordinal()+1 +". "+ dt.name());
        }
        int dyeType = Utils.inputCheck(DyeType.values().length)-1;
        Vehicle vehicle = null;
        try{
            vehicle = new Vehicle(new Body(BodyType.values()[bodyType]), new Engine(EngineType.values()[engineType])
                    ,new Wheel(WheelType.values()[wheelType]), new Dye(DyeType.values()[dyeType]));
        } catch (InappropriateValueException e){
            System.out.println("Looks like your vehicle consists of nulls element, please try again");
            createVehicleManually(garage);
        }
        if(!CreationController.addVehicleToGarage(garage,vehicle)) {
            createVehicleManually(garage);
        } else CreationController.createVehicle(garage);
    }
}
