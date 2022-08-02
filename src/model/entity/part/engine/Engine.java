package model.entity.part.engine;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.Part;
import model.entity.part.body.Body;

import java.util.Objects;

import static model.logic.partLogic.EngineLogic.*;

public class Engine extends Part {
    private static final int MAX_RELIABILITY = 10;
    private int horsepower;
    private int reliability;
    private EngineType engineType;

    public Engine(EngineType engineType, int horsepower) throws InappropriateValueException {
        super(calculateWeight(horsepower), calculatePrice(horsepower));
        if (horsepower > engineType.getMaxHorsepower() || horsepower < 1)
            throw new InappropriateValueException("Inappropriate horsepower for this engine");
        this.reliability = calculateReliability(horsepower);
        this.engineType = engineType;
        this.horsepower = horsepower;
    }

    public Engine (EngineType engineType){
        super(engineType.getWeight(), engineType.getPrice());
        this.engineType = engineType;
        this.horsepower = engineType.getHorsepower();
        this.reliability = engineType.getReliability();
    }

    public Engine(){
        super(EngineType.STANDARD_ENGINE.getWeight(), EngineType.STANDARD_ENGINE.getPrice());
        engineType = EngineType.STANDARD_ENGINE;
        horsepower = engineType.getHorsepower();
        reliability = engineType.getReliability();
    }

    public int getMaxHorsepower(){
        return engineType.getMaxHorsepower();
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getReliability() {
        return reliability;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setReliability(int reliability) {
        this.reliability = reliability;
    }

    public int getMaxReliability(){
        return MAX_RELIABILITY;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return engineType == engine.engineType && horsepower == engine.horsepower && reliability == engine.reliability;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        int hash = prime + Objects.hash(engineType);
        hash = hash*prime + Objects.hash(horsepower);
        hash = hash*prime + Objects.hash(reliability);
        return hash;
    }

    @Override
    public String toString(){
        return String.format(engineType.getName()+", horsepower: %d, reliability: %d",horsepower,reliability);
    }



}
