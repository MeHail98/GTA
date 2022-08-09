package model.logic.comparator;

import model.entity.vehicle.Vehicle;

import java.util.Comparator;

public class ReliabilityCompareAsc implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle vh1, Vehicle vh2) {
        if(vh1 == null || vh2 == null) return 0;
        return vh1.getEngine().getReliability() - vh2.getEngine().getReliability();
    }
}
