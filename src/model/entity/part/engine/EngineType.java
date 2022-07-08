package model.entity.part.engine;

public enum EngineType {
    STANDARD_ENGINE("Standard engine",400, 150,10,300,300),
    TOYOTA_JZ_ENGINE("Toyota JZ engine",1000,500,7,350,2000),
    FERRARI_ENGINE("Ferrari engine",1500,750,4,350,10000);


    private final String name;
    private final int maxHorsepower;
    private final int horsepower;
    private final int reliability;
    private final int weight;
    private final int price;


    EngineType(String name, int maxHorsepower, int horsepower,int reliability,int weight,int price){
        this.name = name;
        this.maxHorsepower = maxHorsepower;
        this.horsepower = horsepower;
        this.reliability = reliability;
        this.weight = weight;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getReliability() {
        return reliability;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public int getMaxHorsepower() {
        return maxHorsepower;
    }
}
