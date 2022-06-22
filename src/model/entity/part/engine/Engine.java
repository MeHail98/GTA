package model.entity.part.engine;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.Part;

    public abstract class Engine extends Part {
    protected static final int MAX_RELIABILITY = 10;
    protected int horsepower;
    protected int reliability;

    Engine(int horsepower, int reliability, int weight, int price) {
        super(weight, price);
        this.horsepower = horsepower;
        this.reliability = reliability;
    }

    Engine (int horsepower, int reliability){
        this.horsepower = horsepower;
        this.reliability = reliability;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getReliability() {
        return reliability;
    }

    abstract void setHorsepower(int horsepower) throws InappropriateValueException;

    abstract void setReliability(int reliability) throws InappropriateValueException;

    abstract int getMaxHorsepower();

}
