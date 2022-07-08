package model.entity.tuning.tuneType;

import exception.logicException.partException.InappropriateValueException;
import model.entity.vehicle.Vehicle;

public abstract class TuneType {

    public abstract int getCost();
    public abstract void applyTuning(Vehicle vehicle) throws InappropriateValueException;
}
