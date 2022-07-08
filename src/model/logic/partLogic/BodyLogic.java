package model.logic.partLogic;

import model.entity.part.body.BodyType;

public class BodyLogic {

    public static int calculateStreamlining(BodyType bodyType){
        int streamlining = 0;
        switch (bodyType){
            case VOLGA -> streamlining = 3;
            case THUNDERBIRD -> streamlining = 4;
            case JAGUAR -> streamlining = 6;
            case MUSTANG -> streamlining = 7;
            case MARK_II -> streamlining = 8;
            case FERRARI -> streamlining = 9;
        }
        return streamlining;
    }
}
