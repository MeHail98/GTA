package model.entity.tuning.tuneType;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.dye.Dye;
import model.entity.vehicle.Vehicle;

public class Repainter extends TuneType{
    private Dye dye;

    public Repainter(Dye dye){
        this.dye = dye;
    }

    public Dye getDye(){
        return dye;
    }

    public void setDye(Dye dye) {
        this.dye = dye;
    }

    @Override
    public int getCost() {
        return dye.getPrice();
    }

    @Override
    public void applyTuning(Vehicle vehicle) throws InappropriateValueException {
        if(dye == null) {
            throw new InappropriateValueException("Not valid dye type");
        }else if(vehicle.getDye() == null){
            vehicle.addPart(dye);
        } else vehicle.setPart(dye);
    }

    @Override
    public String toString() {
        return "dye: " + dye;
    }

}
