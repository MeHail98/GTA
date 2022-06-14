package controller;

import model.entity.garage.Garage;
import model.entity.garage.garageSubtypes.StaticGarage;
import model.entity.vehicle.Vehicle;

import java.util.Arrays;

public class Main {
    //почему когда присваиваешь одному массиву ссылку на другой воид не работает как надо, только
    //если сделать капасити равно намбер оф карс и добавить новый элеемент, как сделать вывод на экран

    public static void main(String[] args) {

        Vehicle vh = new Vehicle();
        Vehicle vh1 = new Vehicle();
        Vehicle vh2 = new Vehicle();
        Vehicle[] veh = {null,null,vh};
        StaticGarage st = new StaticGarage(veh);
        System.out.println(Arrays.toString(st.getVehicles())+""+st.getNumberOfVehicles()+""+st.getCapacity());

        st.add((Vehicle) null);
        System.out.println(Arrays.toString(st.getVehicles())+""+st.getNumberOfVehicles()+""+st.getCapacity());


    }

}
