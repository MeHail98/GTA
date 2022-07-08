package model.logic.comparator;

import model.entity.vehicle.Vehicle;

import java.util.Comparator;

public class PriceCompareAsc implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle vehicle1, Vehicle vehicle2) {
        return vehicle1.getPrice() - vehicle2.getPrice();
    }
}
