package model.entity.part.dye;

public enum Dye {
    RED("red"),BLUE("blue"),SILVER("silver"),GOLDEN("golden");

    private final String colour;

    Dye(String colour){
        this.colour = colour;
    }

    public String getColour(){
        return colour;
    }
}
