package model.entity.part.wheel;

import model.entity.part.Part;

public enum WheelType {
    TRUCK_WHEEL(200,400,4), RACING_WHEEL(40,300,9),
    DRIFT_WHEEL(100,200,1), STANDARD_WHEEL(80,100,6);

    private static final int MAX_STABILITY = 10;

    private final int weight;
    private final int price;
    private final int stability;

    WheelType(int weight, int price, int stability){
        this.weight = weight;
        this.price = price;
        this.stability = stability;
    }

    int getMaxStability(){
        return MAX_STABILITY;
    }

    int getWeight(){
        return weight;
    }

    int getPrice(){
        return price;
    }

    int getStability(){
        return stability;
    }
}
