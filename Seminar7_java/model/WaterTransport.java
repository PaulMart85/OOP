package Seminar7_java.model;

import Seminar7_java.enums.VehicleType;
import Seminar7_java.features.general.*;
import Seminar7_java.features.floating.BuoyancyIndicators;

public abstract class WaterTransport extends Vehicle {

    private final BuoyancyIndicators buoyancyIndicators;

    public WaterTransport(Brand brand, Engine engine, Transmission transmission, 
        GeneralFeat general, BuoyancyIndicators buoyancyIndicators) {
        super(VehicleType.WATER, brand, engine, transmission, general);
        this.buoyancyIndicators = buoyancyIndicators;
    }

    @Override
    public String toString() {
        return super.toString() + 
                ", buoyancyIndicators=" + buoyancyIndicators;
    }

    public String designateMaxSpeed() {
        return String.format("max speed: %skn", super.getMaxSpeed());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && buoyancyIndicators.equals(((WaterTransport) obj).buoyancyIndicators);
    }

}
