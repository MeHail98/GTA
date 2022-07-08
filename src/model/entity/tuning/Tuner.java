package model.entity.tuning;

import exception.logicException.partException.InappropriateValueException;
import exception.logicException.tunerException.BadElementException;
import exception.logicException.tunerException.ImpossibleToTuneException;
import model.entity.part.Part;
import model.entity.part.dye.Dye;
import model.entity.part.engine.Engine;
import model.entity.tuning.kit.BodyKit;
import model.entity.tuning.kit.EngineKit;
import model.entity.vehicle.Vehicle;
import model.logic.tunerLogic.TunerLogic;

public class Tuner {
    private static final int MAX_ELEMENT_WEIGHT_REDUCE_PERCENTAGE = 50;

    public static void addNewEngine(Vehicle vehicle, Engine newEngine)throws InappropriateValueException{
        if(newEngine == null) {
            throw new InappropriateValueException("Not valid engine");
        }else if(vehicle.getEngine() == null){
            vehicle.addPart(newEngine);
        } else vehicle.setPart(newEngine);
    }

    public static void manualOverhaulEngine(Vehicle vehicle, int horsepower) throws InappropriateValueException{
        if(vehicle == null) throw new InappropriateValueException("Not valid vehicle");
        if(vehicle.getEngine() == null) throw new InappropriateValueException("No engine in vehicle");
        TunerLogic.manualOverhaul(vehicle.getEngine(),horsepower);
    }

    public static void reduceWeightGeneral(Vehicle vehicle, int percentage)
            throws InappropriateValueException{
        if(percentage<=MAX_ELEMENT_WEIGHT_REDUCE_PERCENTAGE){
            for (Part elem:vehicle.getListOfParts()) {
                if(!elem.isWeightReduced()) {
                    TunerLogic.reduceWeight(elem, percentage);
                    elem.markWeightReduced();
                }
            }
        } else throw new InappropriateValueException("Max reduce percentage is "+MAX_ELEMENT_WEIGHT_REDUCE_PERCENTAGE);
    }

    public static void reduceWeight(Vehicle vehicle, Part part, int percentage)
            throws InappropriateValueException, BadElementException, ImpossibleToTuneException{
        if(part.isWeightReduced()) throw new ImpossibleToTuneException("Element already has reduced weight");
        if(percentage > MAX_ELEMENT_WEIGHT_REDUCE_PERCENTAGE)
            throw new InappropriateValueException("Max reduce percentage is "+MAX_ELEMENT_WEIGHT_REDUCE_PERCENTAGE);
        boolean hasElement = false;
        for (Part element: vehicle.getListOfParts()) {
            if(element == part) {
                TunerLogic.reduceWeight(element,percentage);
                element.markWeightReduced();
                hasElement = true;
                break;
            }
        }
        if(!hasElement) throw new BadElementException("No such element in this vehicle");
    }

    public static void repaint(Vehicle vehicle, Dye newDye) throws InappropriateValueException{
        if(newDye == null) {
            throw new InappropriateValueException("Not valid dye type");
        }else if(vehicle.getDye() == null){
            vehicle.addPart(newDye);
        } else vehicle.setPart(newDye);
    }


    public static void setBodyKit(Vehicle vehicle, BodyKit bodyKit)
            throws InappropriateValueException, ImpossibleToTuneException{
        if(bodyKit == null) throw new InappropriateValueException("Not valid bodyKit");
        if(vehicle == null) throw new InappropriateValueException("Not valid vehicle");
        if(vehicle.getBody() == null) throw new ImpossibleToTuneException("No body in vehicle");
        TunerLogic.improveStreamlining(vehicle.getBody(), bodyKit.getImprovement_percentage());
    }

    public static void setEngineKit(Vehicle vehicle, EngineKit engineKit) throws InappropriateValueException{
        if(engineKit == null) throw new InappropriateValueException("Not valid engine kit");
        if(vehicle == null) throw new InappropriateValueException("Not valid vehicle");
        if(vehicle.getEngine() == null) throw new InappropriateValueException("No engine in vehicle");
        TunerLogic.overhaulEngine(vehicle.getEngine(), engineKit.getImprovement_percentage());
    }
}
