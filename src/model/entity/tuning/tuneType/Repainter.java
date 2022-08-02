package model.entity.tuning.tuneType;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.dye.Dye;
import model.entity.vehicle.Vehicle;

public class Repainter extends TuneType{
    private Vehicle vehicle;
    private Dye dye;
    private final static int REPAINT_COST = 1000;

    public Repainter(Vehicle vehicle, Dye dye){
        this.vehicle = vehicle;
        this.dye = dye;
    }

    public Dye getDye(){
        return dye;
    }

    public void setDye(Dye dye) {
        this.dye = dye;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    @Override
    public int getCost() {
        return dye.getPrice()+REPAINT_COST;
    }

    @Override
    public void applyTuning() throws InappropriateValueException {
        if(dye == null) {
            throw new InappropriateValueException("Not valid dye type");
        }else if(vehicle.getDye() == null){
            vehicle.addPart(dye);
        } else vehicle.setPart(dye);
    }

    @Override
    public String toString() {
        return "new dye: " + dye;
    }

}
