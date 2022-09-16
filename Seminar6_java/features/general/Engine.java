package Seminar6_java.features.general;

import Seminar6_java.enums.EngineType;
import Seminar6_java.enums.FuelType;

public class Engine {

    private final EngineType engineType; // тип двигателя
    private final String engineBrand; // марка двигателя
    private final float engineVolume; // объем двигателя
    private final FuelType fuel; // топливо

    public Engine(EngineType engineType, String engineBrand, float engineVolume, FuelType fuel) {
        this.engineType = engineType;
        this.engineBrand = engineBrand;
        this.engineVolume = engineVolume;
        this.fuel = fuel;
    } 

    @Override
    public String toString() {
        return "Engine [engineBrand=" + engineBrand + ", engineType=" + engineType + ", engineVolume=" + engineVolume
                + ", fuel=" + fuel + "]";
    }

}
