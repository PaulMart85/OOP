package Seminar6_java.model;

import Seminar6_java.enums.VehicleType;
import Seminar6_java.features.general.*;
import Seminar6_java.features.driving.WheelFeat;

public abstract class GroundTransport extends Vehicle {

    private final WheelFeat wheelFeat;

    public GroundTransport(Brand brand, Engine engine, Transmission transmission, 
                GeneralFeat general, WheelFeat wheelFeat) {
        super(VehicleType.GROUND, brand, engine, transmission, general);
        this.wheelFeat = wheelFeat;
    }

    @Override
    public String toString() {
        return super.toString() + 
               ", wheelFeat=" + wheelFeat;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && wheelFeat.equals(((GroundTransport) obj).wheelFeat);
    }

}
