package model.entity.tuning;

import exception.logicException.tunerException.AlreadyInTuningListException;
import exception.logicException.tunerException.ImpossibleToTuneException;
import model.entity.tuning.tuneType.TuneType;
import model.entity.vehicle.Vehicle;

import java.util.ArrayList;

public class Tuning {
    public static final int ADD_NEW_ENGINE_COST = 1500;
    public static final int REDUCE_WEIGHT_GENERAL_COST = 10000;
    public static final int REDUCE_PART_WEIGHT_COST = 200;
    private static int REPAINT_COST = 1000;
    public static final int SET_BODY_KIT_COST = 3000;
    public static final int SET_ENGINE_KIT_COST = 800;


    private Vehicle vehicle;
    private ArrayList<TuneType> listOfTuning;
    private static Tuning tunerInstance;

    private Tuning(){
    }

    public static Tuning getInstance(){
        if(tunerInstance == null) tunerInstance = new Tuning();
        return tunerInstance;
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        listOfTuning = new ArrayList<>();
    }

    public void addTuning(TuneType newTuning) throws AlreadyInTuningListException {
        if(listOfTuning.size() == 0) {
            listOfTuning.add(newTuning);
        } else {
            for (int i = 0; i < listOfTuning.size(); i++) {
                if(listOfTuning.get(i) == newTuning)
                    throw new AlreadyInTuningListException("This tuning already in tuning list for this vehicle");
                if(newTuning.getClass() == listOfTuning.get(i).getClass()) listOfTuning.set(i,newTuning);
            }
        }
    }

    public int getTuningCost(){
        int cost = 0;
        for (TuneType tuneType:listOfTuning) {
            cost += tuneType.getCost();
        }
        return cost;
    }




    public int getRepaintWorkCost(){
        return REPAINT_COST;
    }

    public static void setRepaintCost(int repaintCost) {
        REPAINT_COST = repaintCost;
    }

}
