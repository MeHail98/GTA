package model.entity.part.engine;

import exception.logicException.partException.InappropriateValueException;

import static model.logic.partLogic.EngineLogic.*;

public class ToyotaJZ extends Engine{
    private static final int MAX_HORSEPOWER = 1000;

    private static final int DEFAULT_HORSEPOWER = 500;
    private static final int DEFAULT_WEIGHT = 350;
    private static final int DEFAULT_RELIABILITY = 7;
    private static final int DEFAULT_PRICE = 2000;

    public ToyotaJZ() {
        super(DEFAULT_HORSEPOWER,DEFAULT_RELIABILITY,DEFAULT_WEIGHT,DEFAULT_PRICE);
    }

    public ToyotaJZ(int horsepower) throws InappropriateValueException {
        super(horsepower,calculateReliability(horsepower));
        if(horsepower>MAX_HORSEPOWER || horsepower<1)
            throw new InappropriateValueException("Too much horsepower for this engine");
        weight = calculateWeight(horsepower);
        price = calculatePrice(horsepower);
    }

    public int getMaxHorsepower(){
        return MAX_HORSEPOWER;
    }

    public void setHorsepower(int horsepower) throws InappropriateValueException{
        if(horsepower>MAX_HORSEPOWER || horsepower<1){
            throw new InappropriateValueException("Unreal power");
        } else{
            super.horsepower = horsepower;
        }
    }

    public void setReliability(int reliability)throws InappropriateValueException{
        if(reliability > MAX_RELIABILITY) {
            throw new InappropriateValueException("Unreal reliability");
        } else {
            this.reliability = reliability;
        }
    }

    @Override
    public String toString(){
        return String.format("Toyota JZ engine, horsepower: %d, reliability: %d, ",horsepower,reliability)
                + super.toString();
    }
}
