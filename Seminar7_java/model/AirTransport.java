package Seminar7_java.model;

import Seminar7_java.enums.VehicleType;
import Seminar7_java.features.general.*;
import Seminar7_java.features.flying.FlightPerformance;

public abstract class AirTransport extends Vehicle {

    private final FlightPerformance flightPerformance;

    public AirTransport(Brand brand, Engine engine, Transmission transmission, 
        GeneralFeat general, FlightPerformance flightPerformance) {
        super(VehicleType.AIR, brand, engine, transmission, general);
        this.flightPerformance = flightPerformance;
    }

    @Override
    public String toString() {
        return super.toString() + 
                ", flightPerformance=" + flightPerformance;
    }

    public String designateMaxSpeed() {
        return String.format("max speed: %sm/h", super.getMaxSpeed());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && flightPerformance.equals(((AirTransport) obj).flightPerformance);
    }

}
