package model.entity.tuning.kit;

public enum EngineKit {
    MEDIUM_KIT(20,1000)
    , EXTREME_KIT(50,10_000)
    , NOT_STABLE_KIT(100,20_000);

    private final int improvement_percentage;
    private final int cost;

    EngineKit(int improvement_percentage, int cost){
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
