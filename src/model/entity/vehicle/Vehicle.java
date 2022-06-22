package model.entity.vehicle;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.Part;
import model.entity.part.body.Body;
import model.entity.part.dye.Dye;
import model.entity.part.engine.Engine;
import model.entity.part.wheel.Wheel;

import java.util.ArrayList;

public class Vehicle {
    private Body body;
    private Engine engine;
    private Wheel wheel;
    private Dye dye;

    private int weight;
    private int price;

    private ArrayList<Part> listOfParts;

    public Vehicle(Body body, Engine engine, Wheel wheel, Dye dye) {
        this.body = body;
        this.engine = engine;
        this.wheel = wheel;
        this.dye = dye;
        weight = body.getWeight() + engine.getWeight() + wheel.getWeight();
        price = body.getPrice()+ engine.getPrice()+ wheel.getPrice();
    }


    //недоделанный метод! Енам и удаление краски не работает по иквалсу
    public void removePart(Part part) throws InappropriateValueException {
        if(part == body) throw new InappropriateValueException("Can't remove body from the vehicle");
        if(part == engine) {
            this.engine = null;
        } else if(part == wheel) {
            this.wheel = null;
        }
    }

    public Vehicle() {

    }



    public String toString (){
        return String.format("%s, price - %d, weight - %d, horsepower - %d, streamlining - %d, reliability - %d "
                ,body.getBodyType().name(),price,weight,engine.getHorsepower()
                , body.getStreamlining(),engine.getReliability());
    }


}
