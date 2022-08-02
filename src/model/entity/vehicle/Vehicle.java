package model.entity.vehicle;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.Part;
import model.entity.part.body.Body;
import model.entity.part.dye.Dye;
import model.entity.part.engine.Engine;
import model.entity.part.wheel.Wheel;

import java.util.*;

import static model.logic.vehicleLogic.VehicleLogic.*;

public class Vehicle implements Iterable<Part>{

    private List<Part> listOfParts;

    public Vehicle(){
        listOfParts = new ArrayList<>();
    }

    public Vehicle(Body body, Engine engine, Wheel wheel, Dye dye) throws InappropriateValueException {

        ArrayList<Part> checkList = new ArrayList<>(Arrays.asList(body,engine,wheel,dye));
        for (Part part:checkList) {
            if(part == null) throw new InappropriateValueException("Consists null elements");
        }
        listOfParts = checkList;
    }

    public Vehicle(List<Part> listOfParts) throws InappropriateValueException{
        if(areAllPartsAppropriate(listOfParts)) {
            this.listOfParts = listOfParts;
        } else throw new InappropriateValueException("Needed: body,engine,wheel,dye");
    }

    public void removePart(Part part) {
        listOfParts.remove(part);
    }

    public void addPart(Part part) throws InappropriateValueException{
        if(isPossibleToAdd(listOfParts,part)){
            listOfParts.add(part);
        } else throw new InappropriateValueException("Vehicle is full or already have this element");
    }

    public void setPart(Part part){
        for (int i = 0; i < listOfParts.size(); i++) {
            if(part.getClass() == listOfParts.get(i).getClass()){
                listOfParts.set(i,part);
            }
        }
    }

    public Engine getEngine() {
        for (Part part: listOfParts) {
            if (part instanceof Engine) return (Engine) part;
        } return null;
    }
    public Body getBody() {
        for (Part part: listOfParts) {
            if (part instanceof Body) return (Body) part;
        } return null;
    }
    public Wheel getWheel() {
        for (Part part: listOfParts) {
            if (part instanceof Wheel) return (Wheel) part;
        } return null;
    }
    public Dye getDye() {
        for (Part part: listOfParts) {
            if (part instanceof Dye) return (Dye) part;
        } return null;
    }

    public Vehicle cloneVehicle(){

        List<Part> newList = new ArrayList<>();
        for (Part part:listOfParts) {
            newList.add(part.clone());
        }
        Vehicle vehicle = new Vehicle();
        vehicle.listOfParts = newList;
        return vehicle;
    }

    public List<Part> getListOfParts(){
        return listOfParts;
    }

    public int getWeight(){
        return calculateWeight(listOfParts);
    }

    public int getPrice(){
        return calculatePrice(listOfParts);
    }

    public int getDefaultPrice(){
        return calculateDefaultPrice(listOfParts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(listOfParts, vehicle.listOfParts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfParts);
    }

    public String toString (){
        if(listOfParts.isEmpty()) return "Some abstract vehicle with no parts";
        StringBuilder builder = new StringBuilder();
        for (Part part:listOfParts) {
            builder.append(part).append(", ");
        }
        return builder+String.format("weight: %d, price: %d"
                ,calculateWeight(listOfParts),calculatePrice(listOfParts) );
    }

    @Override
    public Iterator<Part> iterator() {
        return listOfParts.iterator();
    }
}
