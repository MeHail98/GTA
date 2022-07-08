package model.logic.vehicleLogic.vehicleBuilder;

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

import java.util.Random;

public class RandomVehicleBuilder {

    private static final transient Random random = new Random();

    public static Body createRandomBody(){
        return new Body(BodyType.values()[random.nextInt(BodyType.values().length)]);
    }

    public static Engine createRandomEngine(){
        return new Engine(EngineType.values()[random.nextInt(EngineType.values().length)]);
    }

    public static Dye createRandomDye(){
        return new Dye(DyeType.values()[random.nextInt(DyeType.values().length)]);
    }

    public static Wheel createRandomWheel(){
        return new Wheel(WheelType.values()[random.nextInt(WheelType.values().length)]);
    }

    public static Vehicle createRandomVehicle() {
        Vehicle vehicle;
        try {
            vehicle = new Vehicle(createRandomBody(), createRandomEngine(), createRandomWheel(), createRandomDye());
        } catch (InappropriateValueException e) {
            return null;
        }
        return vehicle;
    }
}
