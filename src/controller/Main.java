package controller;

import exception.logicException.garageException.NullElementException;
import exception.logicException.partException.InappropriateValueException;
import model.entity.garage.garageSubtypes.DynamicGarage;
import model.entity.part.body.Body;
import model.entity.part.body.BodyType;
import model.entity.part.dye.Dye;
import model.entity.part.engine.Engine;
import model.entity.part.engine.StandardEngine;
import model.entity.part.wheel.Wheel;
import model.entity.part.wheel.WheelType;
import model.entity.vehicle.Vehicle;

public class Main {
    //почему когда присваиваешь одному массиву ссылку на другой воид не работает как надо, только
    //если сделать капасити равно намбер оф карс и добавить новый элеемент, как сделать вывод на экран

    public static void main(String[] args) throws InappropriateValueException {

        StandardEngine eng = new StandardEngine(200);
        Body body = new Body(BodyType.JAGUAR);
        Wheel wheel = new Wheel(WheelType.RACING_WHEEL);

        Vehicle vh = new Vehicle(body,eng,wheel,Dye.RED);
        System.out.println(vh);


        Vehicle vh1 = new Vehicle();


    }

}
