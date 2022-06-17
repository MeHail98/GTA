package model.entity.part.engine;

import exception.logicException.partException.InappropriateValueException;

import static model.logic.partLogic.EngineLogic.*;

public class Standard extends Engine{

    private static final int MAX_HORSEPOWER = 400;

    public Standard() {
        weight = 300;
        price = 300;
        reliability = 10;
        horsepower = 150;
    }

    public Standard(int horsepower) throws InappropriateValueException{
        super(horsepower,calculateReliability(horsepower));
        if(horsepower>MAX_HORSEPOWER || horsepower<1)
            throw new InappropriateValueException("Too much horsepower for this engine");
        weight = calculateWeight(horsepower);
        price = calculatePrice(horsepower);
    }
}
