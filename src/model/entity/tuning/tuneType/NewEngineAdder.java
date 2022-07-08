package model.entity.tuning.tuneType;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.dye.Dye;
import model.entity.part.engine.Engine;
import model.entity.vehicle.Vehicle;

public class NewEngineAdder extends TuneType{
    private Engine engine;

    public NewEngineAdder(Engine engine){
        this.engine = engine;
    }

    public Engine getDye(){
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public int getCost() {
        return engine.getPrice();
    }

    @Override
    public void applyTuning(Vehicle vehicle) throws InappropriateValueException {
        if(engine == null) {
            throw new InappropriateValueException("Not valid engine");
        }else if(vehicle.getEngine() == null){
            vehicle.addPart(engine);
        } else vehicle.setPart(engine);
    }

    @Override
    public String toString() {
        return "engine: " + engine;
    }

}
