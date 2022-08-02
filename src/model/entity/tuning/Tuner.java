package model.entity.tuning;

import exception.logicException.partException.InappropriateValueException;
import exception.logicException.tunerException.AlreadyInTuningListException;
import exception.logicException.tunerException.BadBodyKitException;
import exception.logicException.tunerException.BadEngineKitException;
import exception.logicException.tunerException.ImpossibleToTuneException;
import model.entity.tuning.tuneType.TuneType;
import model.entity.vehicle.Vehicle;

import java.util.ArrayList;

public class Tuner {

    Vehicle vehicle;
    private ArrayList<TuneType> listOfTuning;
    private static Tuner tunerInstance;

    private Tuner(){
    }

    public static Tuner getInstance(){
        if(tunerInstance == null) tunerInstance = new Tuner();
        return tunerInstance;
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        listOfTuning = new ArrayList<>();
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public ArrayList<TuneType> getListOfTunings(){
        return listOfTuning;
    }

    public void addTuning(TuneType newTuning) throws AlreadyInTuningListException {
        for (int i = 0; i < listOfTuning.size(); i++) {
            if (listOfTuning.get(i) == newTuning)
                throw new AlreadyInTuningListException("This tuning already in tuning list for this vehicle");
            if (newTuning.getClass() == listOfTuning.get(i).getClass()) listOfTuning.set(i, newTuning);
            else listOfTuning.add(newTuning);
        }
    }

    @Override
    public String toString() {
        return "Vehicle=" + vehicle +"\n"+
                "ListOfTuning=" + listOfTuning ;
    }

    public void applyTuning() throws InappropriateValueException, ImpossibleToTuneException,
            BadEngineKitException, BadBodyKitException {
        for (TuneType tuning: listOfTuning) {
            tuning.applyTuning();
        }
    }

    public int getTuningCost(){
        int cost = 0;
        for (TuneType tuneType:listOfTuning) {
            cost += tuneType.getCost();
        }
        return cost;
    }
}
