package model.entity.tuning.tuneType;

import exception.logicException.partException.InappropriateValueException;
import exception.logicException.tunerException.BadBodyKitException;
import exception.logicException.tunerException.BadEngineKitException;
import exception.logicException.tunerException.ImpossibleToTuneException;
import model.entity.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public abstract class TuneType {

    public abstract int getCost();
    public abstract void applyTuning() throws InappropriateValueException, BadEngineKitException
            , BadBodyKitException, ImpossibleToTuneException;
}
