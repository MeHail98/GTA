package model.entity.part.engine;

import exception.logicException.partException.InappropriateValueException;

import static model.logic.partLogic.EngineLogic.*;

public class StandardEngine extends Engine{

    private static final int MAX_HORSEPOWER = 400;

    private static final int DEFAULT_HORSEPOWER = 150;
    private static final int DEFAULT_RELIABILITY = 10;
    private static final int DEFAULT_WEIGHT = 300;
    private static final int DEFAULT_PRICE = 300;

    public StandardEngine() {
        super(DEFAULT_HORSEPOWER,DEFAULT_RELIABILITY,DEFAULT_WEIGHT,DEFAULT_PRICE);
    }

    public StandardEngine(int horsepower) throws InappropriateValueException{
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
        return String.format("standard engine, horsepower: %d, reliability: %d, ",horsepower,reliability)
                + super.toString();
    }
}
