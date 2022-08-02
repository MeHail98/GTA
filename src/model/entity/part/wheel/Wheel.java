package model.entity.part.wheel;

import model.entity.part.Part;
import model.entity.part.dye.Dye;

import java.util.Objects;

public class Wheel extends Part {

    private static final int DEFAULT_WEIGHT = 80;
    private static final int DEFAULT_PRICE = 500;

    private WheelType wheelType;
    private int stability;

    public Wheel() {
        super(DEFAULT_WEIGHT,DEFAULT_PRICE);
        wheelType = WheelType.STANDARD_WHEEL;
        stability = wheelType.getStability();
    }

    public Wheel(WheelType wheelType){
        super(wheelType.getWeight(), wheelType.getPrice());
        this.wheelType = wheelType;
        stability = wheelType.getStability();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return wheelType == wheel.wheelType;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        return prime + Objects.hash(wheelType);
    }

    public WheelType getWheelType() {
        return wheelType;
    }

    public int getStability(){
        return stability;
    }

    public void setWheelType(WheelType wheelType){
        this.wheelType = wheelType;
    }

    public void setStability(int stability){
        this.stability = stability;
    }

    public int getMaxStability(){
        return wheelType.getMaxStability();
    }

    @Override
    public String toString() {
        return wheelType.name() + ", stability: " + wheelType.getStability();
    }
}
