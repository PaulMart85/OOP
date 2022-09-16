package Seminar7_java.representatives;

import Seminar7_java.model.GroundTransport;
import Seminar7_java.features.general.*;
import Seminar7_java.features.driving.*;

public class Quadbike extends GroundTransport {

    public Quadbike(Brand brand, Engine engine, Transmission transmission, GeneralFeat general, WheelFeat wheelFeat) {
        super(brand, engine, transmission, general, wheelFeat);
    }

}
