package Seminar7_java.model;

import Seminar7_java.enums.VehicleType;
import Seminar7_java.features.general.*;
import Seminar7_java.features.driving.WheelFeat;

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

    public String designateMaxSpeed() {
        return String.format("max speed: %skm/h", super.getMaxSpeed());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && wheelFeat.equals(((GroundTransport) obj).wheelFeat);
    }

}
