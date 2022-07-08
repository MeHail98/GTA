package model.logic.vehicleLogic;

import model.entity.part.Part;
import model.entity.part.body.Body;
import model.entity.part.dye.Dye;
import model.entity.part.engine.Engine;
import model.entity.part.wheel.Wheel;

import java.util.ArrayList;
import java.util.List;

public class VehicleLogic {

    public static int calculateWeight(List<Part> listOfParts){
        int weight = 0;
        for (Part part:listOfParts) {
            weight += part.getWeight();
        }
        return weight;
    }

    public static int calculatePrice(List<Part> listOfParts){
        int price = 0;
        for (Part part:listOfParts) {
            price += part.getPrice();
        }
        return price;
    }

    public static int calculateDefaultPrice(List<Part> listOfParts){
        int defPrice = 0;
        for (Part part:listOfParts) {
            defPrice += part.getDefaultPrice();
        }
        return defPrice;
    }

    public static boolean areAllPartsAppropriate(List<Part> listOfParts) {
        List<Part> newList= new ArrayList<>(listOfParts);
        for (int i = 0; i < newList.size(); i++) {
            if(newList.get(i) instanceof Body) {
                newList.remove(i);
                break;
            }
        }
        for (int i = 0; i < newList.size(); i++) {
            if(newList.get(i) instanceof Engine) {
                newList.remove(i);
                break;
            }
        }
        for (int i = 0; i < newList.size(); i++) {
            if(newList.get(i) instanceof Wheel) {
                newList.remove(i);
                break;
            }
        }
        for (int i = 0; i < newList.size(); i++) {
            if(newList.get(i) instanceof Dye) {
                newList.remove(i);
                break;
            }
        }
        return newList.size() == 0;
    }

    public static boolean isPossibleToAdd(List<Part> listOfParts, Part part){

        if(listOfParts.size()>=4) return false;
        for (Part element:listOfParts) {
            if(part.getClass() == element.getClass()) return false;
        }
        return true;
    }
}
