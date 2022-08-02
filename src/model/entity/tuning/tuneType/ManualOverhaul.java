package model.entity.tuning.tuneType;

import exception.logicException.partException.InappropriateValueException;
import exception.logicException.tunerException.BadBodyKitException;
import exception.logicException.tunerException.BadElementException;
import exception.logicException.tunerException.BadEngineKitException;
import exception.logicException.tunerException.ImpossibleToTuneException;
import model.entity.vehicle.Vehicle;
import model.logic.tunerLogic.TunerLogic;

public class ManualOverhaul extends TuneType{

    private Vehicle vehicle;
    private int horsepower;

    public ManualOverhaul(Vehicle vehicle, int horsepower){
        this.vehicle = vehicle;
        this.horsepower = horsepower;
    }

    public int getNewHorsepower() {
        return horsepower;
    }

    public void setNewHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public void applyTuning() throws InappropriateValueException, ImpossibleToTuneException {
        if(vehicle == null) throw new InappropriateValueException("Not valid vehicle");
        if(vehicle.getEngine() == null) throw new ImpossibleToTuneException("No engine in vehicle");
        TunerLogic.manualOverhaul(vehicle.getEngine(),horsepower);
    }
}
