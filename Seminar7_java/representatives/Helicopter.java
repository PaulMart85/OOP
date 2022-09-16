package Seminar7_java.representatives;

import Seminar7_java.model.AirTransport;
import Seminar7_java.features.general.*;
import Seminar7_java.features.flying.*;

public class Helicopter extends AirTransport {

    public Helicopter(Brand brand, Engine engine, Transmission transmission, GeneralFeat general,
            FlightPerformance flightPerformance) {
        super(brand, engine, transmission, general, flightPerformance);
    }

}
