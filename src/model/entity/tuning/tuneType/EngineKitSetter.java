package model.entity.tuning.tuneType;

import exception.logicException.partException.InappropriateValueException;
import exception.logicException.tunerException.BadEngineKitException;
import exception.logicException.tunerException.ImpossibleToTuneException;
import model.entity.part.engine.Engine;
import model.entity.tuning.kit.EngineKit;
import model.entity.vehicle.Vehicle;
import model.logic.tunerLogic.TunerLogic;

public class EngineKitSetter extends TuneType{

    private Vehicle vehicle;
    private EngineKit engineKit;
    public static final int ADD_ENGINE_KIT_COST = 1500;

    public EngineKitSetter(Vehicle vehicle, EngineKit engineKit){
        this.vehicle = vehicle;
        this.engineKit = engineKit;
    }

    public EngineKit getEngineKit(){
        return engineKit;
    }

    public void setEngineKit(EngineKit engineKit){
        this.engineKit = engineKit;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    @Override
    public int getCost() {
        return engineKit.getCost()+ADD_ENGINE_KIT_COST;
    }

    @Override
    public void applyTuning() throws BadEngineKitException, ImpossibleToTuneException {
        if(engineKit == null) {
            throw new BadEngineKitException("Not valid engine kit");
        }else if(vehicle.getEngine() == null){
            throw new ImpossibleToTuneException("No engine to tune in this vehicle");
        } else TunerLogic.overhaulEngine(vehicle.getEngine(), engineKit.getImprovement_percentage());
    }

    @Override
    public String toString() {
        return "engine kit: " + engineKit;
    }

}
