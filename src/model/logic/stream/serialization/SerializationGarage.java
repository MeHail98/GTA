package model.logic.stream.serialization;

import model.entity.garage.Garage;

import java.io.*;

public class SerializationGarage {
    private String fileName ;

    public SerializationGarage(String fileName){
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void serializeGarage(Garage garage) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            stream.writeObject(garage);
            stream.flush();
    }
}
