package model.logic.stream.simpleParsing;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.body.Body;
import model.entity.part.body.BodyType;
import model.entity.part.dye.Dye;
import model.entity.part.dye.DyeType;
import model.entity.part.engine.Engine;
import model.entity.part.engine.EngineType;
import model.entity.part.wheel.Wheel;
import model.entity.part.wheel.WheelType;
import model.entity.vehicle.Vehicle;
import model.logic.stream.PartEnum;

import java.io.*;
import java.util.Arrays;

public class VehicleReader {

    public static Vehicle readVehicle(String filePath) throws InappropriateValueException, IOException {
        Vehicle vehicle = new Vehicle();
        BufferedReader reader = new BufferedReader( new FileReader(filePath));
            String str;
            while ((str = reader.readLine()) != null){
                String[] line = str.split(" ");
                switch (PartEnum.values()[Integer.parseInt(line[0])]){
                    case BODY -> {
                        BodyType bodyType = BodyType.values()[Integer.parseInt(line[1])];
                        Body body = new Body(bodyType);
                        vehicle.addPart(body);
                    }
                    case ENGINE -> {
                        EngineType engineType = EngineType.values()[Integer.parseInt(line[1])];
                        Engine engine = new Engine(engineType);
                        vehicle.addPart(engine);
                    }
                    case DYE -> {
                        DyeType dyeType = DyeType.values()[Integer.parseInt(line[1])];
                        Dye dye = new Dye(dyeType);
                        vehicle.addPart(dye);
                    }
                    case WHEEL ->  {
                        WheelType wheelType = WheelType.values()[Integer.parseInt(line[1])];
                        Wheel wheel = new Wheel(wheelType);
                        vehicle.addPart(wheel);
                    }
                }
            }
        return vehicle;
    }
}
