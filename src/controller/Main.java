package controller;

import controller.vehicleCreationController.ManualVehicleCreationController;
import controller.vehicleCreationController.ReadFileVehicleCreationController;
import exception.logicException.garageException.CapacityException;
import exception.logicException.garageException.NullElementException;
import model.entity.garage.Garage;
import model.entity.garage.garageSubtypes.DynamicGarage;
import model.entity.garage.garageSubtypes.StaticGarage;
import model.entity.part.Part;
import model.entity.vehicle.Vehicle;
import model.logic.garageLogic.GarageBuilder.RandomGarageBuilder;

public class Main {
    //почему когда присваиваешь одному массиву ссылку на другой воид не работает как надо, только
    //если сделать капасити равно намбер оф карс и добавить новый элеемент, как сделать вывод на экран
    // останавливается ли выполнение метода при эксепшене

    public static void main(String[] args) throws NullElementException, CapacityException {

        Controller.start();
////            Garage garage = new StaticGarage();
////            ManualCreationController.createStaticGarage();
//
//        Garage garage = RandomGarageBuilder.createRandomGarage(1);
//        assert garage != null;
//        ReadFileVehicleCreationController.writeVehicleInFile(garage);

    }

}
