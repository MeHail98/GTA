package model.logic.stream.simpleParsing;

import exception.logicException.partException.InappropriateValueException;
import model.entity.part.body.Body;
import model.entity.part.body.BodyType;
import model.entity.part.dye.Dye;
import model.entity.part.dye.DyeType;
import model.entity.part.engine.Engine;
import model.entity.part.engine.EngineType;
import model.entity.part.wheel.Wheel;
import model.entity.part.wheel.WheelType;
import model.entity.vehicle.Vehicle;
import model.logic.stream.PartEnum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class UsingScanner {

        public static Vehicle usingScanner(String filePath) throws InappropriateValueException {
            Vehicle vehicle = new Vehicle();

            try(BufferedReader reader = new BufferedReader( new FileReader(filePath))){
                Scanner scanner = new Scanner(reader);
                while (scanner.hasNextLine()){
                    String str = scanner.nextLine();
                    String[] line = str.split(" ");
                    switch (PartEnum.values()[Integer.parseInt(line[0])]){
                        case BODY -> {
                            BodyType bodyType = BodyType.values()[Integer.parseInt(line[1])];
                            Body body = new Body(bodyType);
                            vehicle.addPart(body);
                        }
                        case ENGINE -> {
                            EngineType engineType = EngineType.values()[Integer.parseInt(line[1])];
                            Engine engine = new Engine(engineType);
                            vehicle.addPart(engine);
                        }
                        case DYE -> {
                            DyeType dyeType = DyeType.values()[Integer.parseInt(line[1])];
                            Dye dye = new Dye(dyeType);
                            vehicle.addPart(dye);
                        }
                        case WHEEL ->  {
                            WheelType wheelType = WheelType.values()[Integer.parseInt(line[1])];
                            Wheel wheel = new Wheel(wheelType);
                            vehicle.addPart(wheel);
                        }
                    }
                }

            } catch (IOException e){
                System.err.println(Arrays.toString(e.getStackTrace()));
            }
            return vehicle;
        }
    }
