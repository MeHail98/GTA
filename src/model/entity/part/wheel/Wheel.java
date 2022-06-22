package model.entity.part.wheel;

import model.entity.part.Part;

public class Wheel extends Part {

    private static final int DEFAULT_WEIGHT = 80;
    private static final int DEFAULT_PRICE = 500;

    private static final int MAX_STABILITY = 10;

    private static WheelType wheelType;
    private static int stability;

    public Wheel() {
        super(DEFAULT_WEIGHT,DEFAULT_PRICE);
        wheelType = WheelType.STANDARD_WHEEL;
        stability = WheelType.STANDARD_WHEEL.getStability();
    }

    public Wheel(WheelType wheelType){
        super(wheelType.getWeight(), wheelType.getPrice());
        stability = wheelType.getStability();
    }

    public WheelType getWheelType() {
        return wheelType;
    }

    public int getStability(){
        return stability;
    }

    public int getMaxStability(){
        return MAX_STABILITY;
    }

    @Override
    public String toString() {
        return "Wheel, " + super.toString();
    }
}
