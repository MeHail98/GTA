package model.logic.stream.byteStream;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.Part;
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

public class ByteStreamReader {

    public ByteStreamReader(){
    }

    public Vehicle createVehicleByteStream(String fileName) throws exception.techException.FileNotFoundException
            , InappropriateValueException {

        if(fileName == null) throw new exception.techException.FileNotFoundException("No such file");
        Vehicle vehicle = new Vehicle();
        try (DataInputStream stream = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))){
            while (stream.available() != 0){
                int partType = stream.readInt();
                switch (PartEnum.values()[partType]){
                    case BODY -> {
                        BodyType bodyType = BodyType.values()[stream.readInt()];
                       Body body = new Body(bodyType);
                       body.setStreamlining(stream.readInt());
                       body.setPrice(stream.readInt());
                       body.setWeight(stream.readInt());
                       vehicle.addPart(body);
                    }
                    case ENGINE -> {
                        EngineType engineType = EngineType.values()[stream.readInt()];
                        Engine engine = new Engine(engineType);
                        engine.setHorsepower(stream.readInt());
                        engine.setReliability(stream.readInt());
                        engine.setPrice(stream.readInt());
                        engine.setWeight(stream.readInt());
                        vehicle.addPart(engine);
                    }
                    case DYE -> {
                        DyeType dyeType = DyeType.values()[stream.readInt()];
                        Dye dye = new Dye(dyeType);
                        dye.setPrice(stream.readInt());
                        dye.setWeight(stream.readInt());
                        vehicle.addPart(dye);
                    }
                    case WHEEL ->  {
                        WheelType wheelType = WheelType.values()[stream.readInt()];
                        Wheel wheel = new Wheel(wheelType);
                        wheel.setStability(stream.readInt());
                        wheel.setPrice(stream.readInt());
                        wheel.setWeight(stream.readInt());
                        vehicle.addPart(wheel);
                    }
                }
            }
        } catch (IOException e){
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
        return vehicle;
    }
}
