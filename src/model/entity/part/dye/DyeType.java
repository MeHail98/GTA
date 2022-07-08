package model.entity.part.dye;

public enum DyeType {
    RED("red", 500),BLUE("blue",400)
    ,SILVER("silver",1000),GOLDEN("golden",2000);

    private final String colour;
    private final int price;

    DyeType(String colour, int price){
        this.colour = colour;
        this.price = price;
    }

    public String getColour(){
        return colour;
    }

    public int getPrice(){
        return price;
    }
}
