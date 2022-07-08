package model.entity.part.body;

public enum BodyType {

    MARK_II(1000, 10_000, 8,10)
    , FERRARI(1200, 20_000, 9,10)
    , MUSTANG(1500, 30_000, 7,9)
    , JAGUAR(1500,20_000, 8,9)
    , VOLGA(2000,10_000, 3,6)
    , THUNDERBIRD(3000,30_000, 4,7);

    private final int maxStreamlining;
    private final int weight;
    private final int price;
    private final int streamlining;

    BodyType(int weight, int price, int streamlining, int maxStreamlining) {
        this.weight = weight;
        this.price = price;
        this.streamlining = streamlining;
        this.maxStreamlining = maxStreamlining;
    }

    int getMaxStreamlining(){
        return maxStreamlining;
    }

    int getStreamlining(){
        return streamlining;
    }

    int getWeight() {
        return weight;
    }

    int getPrice() {
        return price;
    }
}
