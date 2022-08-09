package model.entity.tuning.tuneType;

import exception.logicException.tunerException.BadBodyKitException;
import exception.logicException.tunerException.ImpossibleToTuneException;
import model.entity.part.body.Body;
import model.entity.tuning.kit.BodyKit;
import model.entity.vehicle.Vehicle;
import model.logic.tunerLogic.TunerLogic;

public class BodyKitSetter extends TuneType {

        private Vehicle vehicle;
        private BodyKit bodyKit;
        public static final int ADD_BODY_KIT_COST = 3000;

        public BodyKitSetter(Vehicle vehicle, BodyKit bodyKit){
            this.vehicle = vehicle;
            this.bodyKit = bodyKit;
        }

        public BodyKit getBodyKit(){
            return bodyKit;
        }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

        public void setBodyKit(BodyKit bodyKit){
            this.bodyKit = bodyKit;
        }
        @Override
        public int getCost() {
            return bodyKit.getCost()+ADD_BODY_KIT_COST;
        }

        @Override
        public void applyTuning() throws BadBodyKitException, ImpossibleToTuneException {
            if(bodyKit == null) {
                throw new BadBodyKitException("Not valid body kit");
            }else if(vehicle.getBody() == null){
                throw new ImpossibleToTuneException("No body to tune in this vehicle");
            } else TunerLogic.improveStreamlining(vehicle.getBody(), bodyKit.getImprovement_percentage());
        }

        @Override
        public String toString() {
            return "body kit - " + bodyKit + ", work cost " + ADD_BODY_KIT_COST;
        }
}
