package model.entity.part;

import java.io.Serializable;

public class Part implements Cloneable, Serializable {
    protected int weight;
    protected int price;
    protected int defaultPrice;
    protected boolean weightReduced = false;

    protected Part(){
    }

    protected Part(int weight, int price) {
        this.weight = weight;
        this.price = price;
        defaultPrice = price;
    }

    public boolean isWeightReduced(){
        return weightReduced;
    }

    public void markWeightReduced(){
        weightReduced = true;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public int getDefaultPrice(){
        return defaultPrice;
    }

    public String toString(){
        return "weight: " + weight +", price: " + price;
    }

    @Override
    public Part clone() {
        try {
            return (Part) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
