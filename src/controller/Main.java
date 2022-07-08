package controller;

import exception.logicException.partException.InappropriateValueException;
import exception.logicException.tunerException.BadElementException;
import model.entity.garage.Garage;
import model.entity.garage.garageSubtypes.DynamicGarage;
import model.entity.part.Part;
import model.entity.part.body.Body;
import model.entity.part.body.BodyType;
import model.entity.part.dye.Dye;
import model.entity.part.dye.DyeType;
import model.entity.part.engine.Engine;
import model.entity.part.engine.EngineType;
import model.entity.part.wheel.Wheel;
import model.entity.part.wheel.WheelType;
import model.entity.tuning.Tuner;
import model.entity.vehicle.Vehicle;
import model.logic.comparator.HorsepowerCompareAsc;
import model.logic.comparator.PriceCompareAsc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static model.logic.garageLogic.GarageBuilder.RandomGarageBuilder.createRandomGarage;
import static model.logic.vehicleLogic.vehicleBuilder.RandomVehicleBuilder.createRandomVehicle;

public class Main {
    //почему когда присваиваешь одному массиву ссылку на другой воид не работает как надо, только
    //если сделать капасити равно намбер оф карс и добавить новый элеемент, как сделать вывод на экран
    // останавливается ли выполнение метода при эксепшене

    public static void main(String[] args) throws InappropriateValueException, BadElementException {


        for (int i = 0; i < 50; i++) {
            Garage garage = createRandomGarage();
            System.out.println(garage);
        }



    }

}
