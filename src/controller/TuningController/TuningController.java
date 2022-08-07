package controller.TuningController;

import controller.Utils;
import model.entity.garage.Garage;
import model.entity.vehicle.Vehicle;

public class TuningController {

    public static void TuneVehicle(Garage garage){
        System.out.println("\nPlease choose vehicle you want to tune from your garage :");
        int count = 0;
        for (Vehicle vehicle: garage) {
            if(vehicle == null) break;
            count++;
            System.out.println(count + ". " + vehicle);
        }
        int input = Utils.inputCheck(garage.getNumberOfVehicles());

    }

    public static void ChooseTuning(){
        System.out.println("""
                Here are different types of tuning you can apply to your vehicle, please choose one
                1. Set body kit
                2. Set engine kit
                3. Add new engine
                4. Repaint
                5. Reduce weight
                6. Manual engine overhaul (experimental)
                """);
        int input = Utils.inputCheck(6);

    }

}
