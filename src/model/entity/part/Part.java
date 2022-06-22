package model.entity.part;

public class Part {
    protected int weight;
    protected int price;

    protected Part(){
        weight = 0;
        price = 0;
    }

    protected Part(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public String toString(){
        return "weight: " + weight +", price: " + price;
    }
}
