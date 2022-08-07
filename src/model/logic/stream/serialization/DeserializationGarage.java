package model.logic.stream.serialization;

import model.entity.garage.Garage;

import java.io.*;

public class DeserializationGarage {

    public static Garage deserializeGarage(String fileName) throws IOException, ClassNotFoundException{
        Garage garage;
        ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            garage = (Garage) stream.readObject();
        return garage;
    }
}
