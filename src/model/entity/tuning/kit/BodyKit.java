package model.entity.tuning.kit;

public enum BodyKit {
    MEDIUM_KIT(10,1000), EXTREME_KIT(20,2000);

    private final int improvement_percentage;
    private final int cost;

    BodyKit(int improvement_percentage, int cost){
        this.improvement_percentage = improvement_percentage;
        this.cost = cost;
    }

    public int getImprovement_percentage(){
        return improvement_percentage;
    }

    public int getCost(){
        return cost;
    }
}
