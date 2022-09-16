package Seminar6_java.model;

import Seminar6_java.enums.VehicleType;
import Seminar6_java.features.general.*;
import Seminar6_java.features.flying.FlightPerformance;

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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && flightPerformance.equals(((AirTransport) obj).flightPerformance);
    }

}
