package controller;

import exception.logicException.garageException.NullElementException;
import model.entity.garage.garageSubtypes.DynamicGarage;
import model.entity.vehicle.Vehicle;

public class Main {
    //почему когда присваиваешь одному массиву ссылку на другой воид не работает как надо, только
    //если сделать капасити равно намбер оф карс и добавить новый элеемент, как сделать вывод на экран

    public static void main(String[] args) {

        Vehicle vh = new Vehicle();
        Vehicle vh1 = new Vehicle();
        Vehicle vh2 = new Vehicle();
        Vehicle vh3 = null;
        Vehicle[] veh = {vh1,vh2,vh3};
        DynamicGarage st = new DynamicGarage(veh);
        System.out.println(st);
        try{
            st.add(vh);
        } catch (NullElementException e){
            System.out.println("");
        }
        System.out.println(st);


    }

}
