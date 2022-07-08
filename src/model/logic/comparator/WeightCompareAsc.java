package model.logic.comparator;

import model.entity.vehicle.Vehicle;

import java.util.Comparator;

public class WeightCompareAsc implements Comparator<Vehicle> {

    @Override
    public int compare (Vehicle vh1, Vehicle vh2){
        return vh1.getWeight()- vh2.getWeight();
    }
}
