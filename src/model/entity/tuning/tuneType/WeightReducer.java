package model.entity.tuning.tuneType;

import exception.logicException.partException.InappropriateValueException;
import exception.logicException.tunerException.ImpossibleToTuneException;
import model.entity.part.Part;
import model.entity.vehicle.Vehicle;
import model.logic.tunerLogic.TunerLogic;

public class WeightReducer extends TuneType{
    private Vehicle vehicle;
    private int percentage;
    private static final int WEIGHT_REDUCE_PRICE = 2000;
    private static final int MAX_ELEMENT_WEIGHT_REDUCE_PERCENTAGE = 50;

    public WeightReducer(Vehicle vehicle, int percentage){
        this.vehicle = vehicle;
         this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    //не понятно как крссиво обр экспешн
    @Override
    public void applyTuning()
            throws InappropriateValueException, ImpossibleToTuneException {
        if (percentage > MAX_ELEMENT_WEIGHT_REDUCE_PERCENTAGE)
            throw new InappropriateValueException("Max reduce percentage is " + MAX_ELEMENT_WEIGHT_REDUCE_PERCENTAGE);
        for (Part part : vehicle.getListOfParts()) {
            if (part.isWeightReduced()) throw new ImpossibleToTuneException("Next element already has reduced weight: "
                    + part);
            TunerLogic.reduceWeight(part, percentage);
            part.markWeightReduced();
        }
    }

    @Override
    public int getCost() {
        return WEIGHT_REDUCE_PRICE;
    }
}
