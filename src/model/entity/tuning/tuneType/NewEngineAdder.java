package model.entity.tuning.tuneType;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.engine.Engine;
import model.entity.vehicle.Vehicle;

public class NewEngineAdder extends TuneType{
    private Vehicle vehicle;
    private Engine newEngine;
    public static final int ADD_NEW_ENGINE_COST = 1500;

    public NewEngineAdder(Vehicle vehicle, Engine newEngine){
        this.vehicle = vehicle;
        this.newEngine = newEngine;
    }

    public Engine getNewEngine(){
        return newEngine;
    }

    public void setNewEngine(Engine newEngine) {
        this.newEngine = newEngine;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    @Override
    public int getCost() {
        return newEngine.getPrice()+ADD_NEW_ENGINE_COST;
    }

    @Override
    public void applyTuning() throws InappropriateValueException {
        if(newEngine == null) {
            throw new InappropriateValueException("Not valid engine");
        }else if(vehicle.getEngine() == null){
            vehicle.addPart(newEngine);
        } else vehicle.setPart(newEngine);
    }

    @Override
    public String toString() {
        return "new engine: " + newEngine;
    }

}
