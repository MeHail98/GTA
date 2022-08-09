package model.entity.tuning.tuneType;

import exception.logicException.tunerException.ImpossibleToTuneException;
import model.entity.part.Part;

import java.util.ArrayList;

import static model.logic.vehicleLogic.VehicleLogic.calculatePrice;
import static model.logic.vehicleLogic.VehicleLogic.calculateWeight;

public class TuningList {
    private ArrayList<TuneType> tuningList;

    public TuningList(){
        tuningList = new ArrayList<>();
    }

    public void addTuning(TuneType tuning) throws ImpossibleToTuneException{
        for (TuneType tt:tuningList) {
            if(tuning.getClass() == tt.getClass()) throw new ImpossibleToTuneException("Already in tuning list");
        }
        tuningList.add(tuning);
    }

    public void removeTuning(int index){
        tuningList.remove(index);
    }

    public ArrayList<TuneType> getTuningList(){
        return tuningList;
    }

    @Override
    public String toString() {
        if(tuningList.isEmpty()) return "No tuning";
        StringBuilder builder = new StringBuilder();
        for (TuneType tt:tuningList) {
            builder.append(tt).append("\n");
        }
        return builder+"";
    }
}
