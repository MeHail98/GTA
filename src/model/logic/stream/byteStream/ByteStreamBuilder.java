package model.logic.stream.byteStream;

import exception.techException.FileNotFoundException;
import model.entity.part.body.Body;
import model.entity.part.body.BodyType;
import model.entity.part.dye.Dye;
import model.entity.part.engine.Engine;
import model.entity.part.wheel.Wheel;
import model.entity.vehicle.Vehicle;
import model.logic.stream.PartEnum;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteStreamBuilder {

    private String fileName;

    public ByteStreamBuilder(String fileName) {
        this.fileName = fileName;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public void saveVehicle(Vehicle vehicle) throws FileNotFoundException {
        if (fileName == null) {
            throw new FileNotFoundException("No file to write object");
        }
        try(DataOutputStream stream= new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (model.entity.part.Part part : vehicle) {
                if (part instanceof Body body) {
                    stream.writeInt(PartEnum.BODY.ordinal());
                    stream.writeInt(body.getBodyType().ordinal());
                    stream.writeInt(body.getStreamlining());
                    stream.writeInt(body.getPrice());
                    stream.writeInt(body.getWeight());
                } else if (part instanceof Engine engine) {
                    stream.writeInt(PartEnum.ENGINE.ordinal());
                    stream.writeInt(engine.getEngineType().ordinal());
                    stream.writeInt(engine.getHorsepower());
                    stream.writeInt(engine.getReliability());
                    stream.writeInt(engine.getPrice());
                    stream.writeInt(engine.getWeight());
                } else if (part instanceof Wheel wheel) {
                    stream.writeInt(PartEnum.WHEEL.ordinal());
                    stream.writeInt(wheel.getWheelType().ordinal());
                    stream.writeInt(wheel.getStability());
                    stream.writeInt(wheel.getPrice());
                    stream.writeInt(wheel.getWeight());
                } else if (part instanceof Dye dye) {
                    stream.writeInt(PartEnum.DYE.ordinal());
                    stream.writeInt(dye.getDyeType().ordinal());
                    stream.writeInt(dye.getPrice());
                    stream.writeInt(dye.getWeight());
                }
            }
            stream.flush();
        } catch (IOException e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
