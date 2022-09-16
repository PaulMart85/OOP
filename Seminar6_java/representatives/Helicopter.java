package Seminar6_java.representatives;

import Seminar6_java.model.AirTransport;
import Seminar6_java.features.general.*;
import Seminar6_java.features.flying.*;

public class Helicopter extends AirTransport {

    public Helicopter(Brand brand, Engine engine, Transmission transmission, GeneralFeat general,
            FlightPerformance flightPerformance) {
        super(brand, engine, transmission, general, flightPerformance);
    }

}
