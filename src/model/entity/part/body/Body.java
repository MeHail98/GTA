package model.entity.part.body;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.Part;

import java.util.Objects;

public class Body extends Part {

    private BodyType bodyType;
    private int streamlining;

    public Body(BodyType bodyType){
        super(bodyType.getWeight(), bodyType.getPrice());
        this.bodyType = bodyType;
        streamlining = bodyType.getStreamlining();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return streamlining == body.streamlining && bodyType == body.bodyType;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        int hash;
        hash = prime + Objects.hash(bodyType);
        hash = hash*prime + Objects.hash(streamlining);
        return hash;
    }

    public void setBodyType(BodyType bodyType){
        this.bodyType = bodyType;
    }

    public int getMaxStreamlining(){
        return bodyType.getMaxStreamlining();
    }

    public int getStreamlining(){
        return streamlining;
    }

    public void setStreamlining(int streamlining) {
        this.streamlining = streamlining;
    }

    public BodyType getBodyType(){
        return bodyType;
    }

    @Override
    public String toString (){
        return bodyType.name()+", streamlining: " + streamlining;
    }

}
