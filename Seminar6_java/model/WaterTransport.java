package Seminar6_java.model;

import Seminar6_java.enums.VehicleType;
import Seminar6_java.features.general.*;
import Seminar6_java.features.floating.BuoyancyIndicators;

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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && buoyancyIndicators.equals(((WaterTransport) obj).buoyancyIndicators);
    }

}
