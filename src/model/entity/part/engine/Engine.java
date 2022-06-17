package model.entity.part.engine;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.Part;

public class Engine extends Part {
    protected static final int MAX_RELIABILITY = 10;
    protected static final int MAX_HORSEPOWER = 1500;
    protected int horsepower;
    protected int reliability;

    protected Engine() {
        horsepower = 0;
        reliability = 0;
    }

    protected Engine(int horsepower, int reliability) {
        this.horsepower = horsepower;
        this.reliability = reliability;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getReliability() {
        return reliability;
    }

    public void setHorsepower(int horsepower) throws InappropriateValueException {

        if(horsepower>MAX_HORSEPOWER || horsepower<1) throw new InappropriateValueException("Unreal power");
        this.horsepower = horsepower;
    }

    public void setReliability(int reliability) throws InappropriateValueException {
        if(reliability > MAX_RELIABILITY) throw new InappropriateValueException("Unreal reliability");
        this.reliability = reliability;
    }
}
