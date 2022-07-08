package model.logic.tunerLogic;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.Part;
import model.entity.part.body.Body;
import model.entity.part.engine.Engine;

import static model.logic.partLogic.EngineLogic.*;

public class TunerLogic {

    public static void reduceWeight(Part part, int percentage){
        int weight = part.getWeight();
        int price = part.getPrice();
        if(weight>0){
            weight = weight*(100-percentage)/100;
            price = price*2*(100+percentage)/100;
            part.setWeight(weight);
            part.setPrice(price);
        }
    }
    public static void improveStreamlining(Body body, int percentage){
        double newStreamlining = body.getStreamlining()*(1+(double)percentage/100);
        if(newStreamlining > body.getMaxStreamlining()) newStreamlining = body.getMaxStreamlining();
        body.setStreamlining((int)newStreamlining);
    }

    public static void overhaulEngine(Engine engine, int percentage) {
        double newHorsepower = engine.getHorsepower()*(1+(double)percentage/100);
        if(newHorsepower > engine.getMaxHorsepower()) newHorsepower = engine.getMaxHorsepower();
        engine.setHorsepower((int)newHorsepower);
    }

    public static void manualOverhaul(Engine engine, int horsepower) throws InappropriateValueException{
        if(horsepower>engine.getMaxHorsepower() || horsepower<1){
            throw new InappropriateValueException("Unacceptable power for this engine");
        } else{
            engine.setPrice(calculatePrice(horsepower));
            engine.setWeight(calculateWeight(horsepower));
            engine.setReliability(calculateReliability(horsepower));
            engine.setHorsepower(horsepower);
        }
    }

}
