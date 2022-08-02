package model.logic.stream.simpleParsing;

import exception.techException.FileNotFoundException;
import model.entity.part.Part;
import model.entity.part.body.Body;
import model.entity.part.dye.Dye;
import model.entity.part.engine.Engine;
import model.entity.part.wheel.Wheel;
import model.entity.vehicle.Vehicle;
import model.logic.stream.PartEnum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class VehicleWriter {

    private String fileName;

    public VehicleWriter(String fileName){
        this.fileName = fileName;
    }

    public void setFileName(String fileName){
        if(fileName == null) return;
        this.fileName = fileName;
    }

    public void writeVehicle(Vehicle vehicle) throws FileNotFoundException{
        if(fileName == null) throw new FileNotFoundException("No file to write vehicle");

        try(BufferedWriter stream = new BufferedWriter(new FileWriter(fileName))){
            for (Part part: vehicle) {
                if (part instanceof Body body) {
                    stream.write(PartEnum.BODY.ordinal() + " ");
                    stream.write(body.getBodyType().ordinal() + " ");
                    stream.write(body.getBodyType().name()+ "\n");

                } else if (part instanceof Engine engine) {
                    stream.write(PartEnum.ENGINE.ordinal()+ " ");
                    stream.write(engine.getEngineType().ordinal()+ " ");
                    stream.write(engine.getEngineType().name()+ "\n");

                } else if (part instanceof Wheel wheel) {
                    stream.write(PartEnum.WHEEL.ordinal()+ " ");
                    stream.write(wheel.getWheelType().ordinal()+ " ");
                    stream.write(wheel.getWheelType().name()+ "\n");

                } else if (part instanceof Dye dye) {
                    stream.write(PartEnum.DYE.ordinal()+ " ");
                    stream.write(dye.getDyeType().ordinal()+ " ");
                    stream.write(dye.getDyeType().name()+ "\n");
                }
            }
            stream.flush();
        } catch (IOException e){
            System.err.println(e);
        }
    }
}
