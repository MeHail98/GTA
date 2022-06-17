package model.logic.partLogic;

public class EngineLogic {

    public static int calculateReliability(int horsepower) {
        int reliability = 1;
        if (horsepower <= 200) reliability = 10;
        if (horsepower > 200 && horsepower <= 300) reliability = 9;
        if (horsepower > 300 && horsepower <= 400) reliability = 8;
        if (horsepower > 400 && horsepower <= 500) reliability = 7;
        if (horsepower > 500 && horsepower <= 600) reliability = 6;
        if (horsepower > 600 && horsepower <= 700) reliability = 5;
        if (horsepower > 700 && horsepower <= 800) reliability = 4;
        if (horsepower > 800 && horsepower <= 900) reliability = 3;
        if (horsepower > 900 && horsepower <= 1000) reliability = 2;
        return reliability;
    }

    public static int calculateWeight(int horsepower) {
        int weight = 450;
        if (horsepower <= 200) weight = 300;
        if (horsepower > 200 && horsepower <= 500) weight = 350;
        if (horsepower > 500 && horsepower <= 1000) weight = 400;
        return weight;
    }

    public static int calculatePrice(int horsepower) {
        int price = 32000;
        if (horsepower <= 200) price = 300;
        if (horsepower > 200 && horsepower <= 300) price = 500;
        if (horsepower > 300 && horsepower <= 400) price = 1000;
        if (horsepower > 400 && horsepower <= 500) price = 2000;
        if (horsepower > 500 && horsepower <= 600) price = 4000;
        if (horsepower > 600 && horsepower <= 700) price = 8000;
        if (horsepower > 700 && horsepower <= 1000) price = 16000;
        return price;
    }
}
