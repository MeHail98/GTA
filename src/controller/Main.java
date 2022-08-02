package controller;

import exception.logicException.partException.InappropriateValueException;
import exception.logicException.tunerException.BadElementException;
import exception.techException.FileNotFoundException;
import model.entity.vehicle.Vehicle;
import model.logic.stream.byteStream.ByteStreamBuilder;
import model.logic.stream.byteStream.ByteStreamReader;
import model.logic.stream.simpleParsing.UsingScanner;
import model.logic.stream.simpleParsing.VehicleReader;
import model.logic.stream.simpleParsing.VehicleWriter;

import static model.logic.vehicleLogic.vehicleBuilder.RandomVehicleBuilder.createRandomVehicle;

public class Main {
    //почему когда присваиваешь одному массиву ссылку на другой воид не работает как надо, только
    //если сделать капасити равно намбер оф карс и добавить новый элеемент, как сделать вывод на экран
    // останавливается ли выполнение метода при эксепшене

    public static void main(String[] args) throws InappropriateValueException, BadElementException, FileNotFoundException {


//        Vehicle[] array = new Vehicle[10];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = createRandomVehicle();
//        }
//
//        StaticGarage st = new StaticGarage(array);
//        System.out.println(st+"\n\n");
//
//
//        for (Vehicle vh:st) {
//            System.out.println(vh);
//        }

//        Vehicle vehicle = createRandomVehicle();
        String name = "M:/vehicle.txt";
//        VehicleWriter vw = new VehicleWriter(name);
//        vw.writeVehicle(vehicle);

        Vehicle vehicle = UsingScanner.usingScanner(name);
        System.out.println(vehicle);

//        System.out.println(vehicle);
//        ByteStreamBuilder builder = new ByteStreamBuilder(name);
//        builder.saveVehicle(vehicle);
//        ByteStreamReader reader = new ByteStreamReader();
//        Vehicle vehicle1 = reader.createVehicleByteStream(name);
//        System.out.println(vehicle1);
//JAGUAR, streamlining: 8, Standard engine, horsepower: 150, reliability: 10, TRUCK_WHEEL, stability: 4, Colour: blue, weight: 2000, price: 21100




    }

}
