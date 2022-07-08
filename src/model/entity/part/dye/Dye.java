package model.entity.part.dye;

import model.entity.part.Part;
import model.entity.part.body.Body;

import java.util.Objects;

public class Dye extends Part {

    private DyeType dyeType;
    public Dye(DyeType colour){
        super(0, colour.getPrice());
        dyeType = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Dye dye = (Dye) o;
        return dyeType == dye.dyeType;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        return prime + Objects.hash(dyeType);
    }

    public DyeType getDyeType() {
        return dyeType;
    }

    public void setDyeType(DyeType dyeType) {
        this.dyeType = dyeType;
    }

    @Override
    public String toString(){
        return "Colour: " + dyeType.name();
    }
}
