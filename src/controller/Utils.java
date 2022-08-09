package controller;

import exception.logicException.garageException.CapacityException;
import exception.logicException.garageException.NullElementException;
import model.entity.garage.Garage;
import model.entity.vehicle.Vehicle;

import java.util.Scanner;

public class Utils {

    static Scanner scanner = new Scanner(System.in);


    public static String scanConsole(){
        return scanner.nextLine();
    }

    public static int inputCheck(int max){
        boolean notAppropriate = true;
        int intInput = 0;
        while (notAppropriate) {
            String input = scanner.nextLine();
            if (!isNumber(input)) {
                System.out.println("Please type an integer number");
            } else {
                intInput = convertToInt(input);
                if (!isAppropriate(intInput, max)) {
                    System.out.println("Please type a number from 1 to " + max);
                } else notAppropriate = false;
            }
        }
        return intInput;
    }

    public static boolean isAppropriate(int input, int max){
        return input <= max && input > 0;
    }

    public static boolean isNumber(String s){
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public static int convertToInt(String s){
        int number;
        try {
            number = Integer.parseInt(s);
        } catch(NumberFormatException e){
            return 0;
        } return number;
    }

    public static boolean isEnough(Garage garage){
        System.out.println("Here is your garage now: " + garage);
        System.out.println("""
        Is that's it or you want to do one more?
        1. One more 
        2. That's it
        """);
        int input = Utils.inputCheck(2);
        return input != 1;
    }
}
