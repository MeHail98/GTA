package model.logic.comparator;

import model.entity.vehicle.Vehicle;

import java.util.Comparator;

public class HorsepowerCompareAsc implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle vehicle1, Vehicle vehicle2) {
        if(vehicle1 == null || vehicle2 == null) return 0;
        return vehicle1.getEngine().getHorsepower() - vehicle2.getEngine().getHorsepower();
    }
}
