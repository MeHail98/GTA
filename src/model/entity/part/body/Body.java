package model.entity.part.body;

import model.entity.part.Part;

public class Body extends Part {

    //показатель обтекаемости кузова и максимальое его значение
    private int streamlining;
    private static final int MAX_STREAMLINING = 10;
    private BodyType bodyType;

    public Body(BodyType bodyType){
        super(bodyType.getWeight(), bodyType.getPrice());
        this.bodyType = bodyType;
        switch (bodyType){
            case VOLGA -> streamlining = 3;
            case THUNDERBIRD -> streamlining = 4;
            case JAGUAR -> streamlining = 6;
            case MUSTANG -> streamlining = 7;
            case MARK_II -> streamlining = 8;
            case FERRARI -> streamlining = 9;
        }
    }

    public int getMaxStreamlining(){
        return MAX_STREAMLINING;
    }

    public int getStreamlining(){
        return streamlining;
    }
    public BodyType getBodyType(){
        return bodyType;
    }

    @Override
    public String toString (){
        return bodyType.name()+String.format(", streamlining: %d, ", streamlining)+super.toString();
    }

}
