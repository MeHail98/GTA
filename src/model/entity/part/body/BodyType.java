package model.entity.part.body;

public enum BodyType {

    MARK_II(1000, 10_000), FERRARI(1200, 20_000),
    MUSTANG(1500, 30_000), JAGUAR(1500,20_000), VOLGA(2000,10_000),
    THUNDERBIRD(3000,30_000);

    private final int weight;
    private final int price;

    BodyType(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    int getWeight() {
        return weight;
    }

    int getPrice() {
        return price;
    }
}
