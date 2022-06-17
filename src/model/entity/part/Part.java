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

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String toString(){
        return "weight = " + weight +", price = " + price;
    }
}
