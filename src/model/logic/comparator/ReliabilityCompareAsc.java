package model.logic.comparator;

import model.entity.vehicle.Vehicle;

import java.util.Comparator;

public class ReliabilityCompareAsc implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle vh1, Vehicle vh2) {
        return vh1.getEngine().getReliability() - vh2.getEngine().getReliability();
    }
}
