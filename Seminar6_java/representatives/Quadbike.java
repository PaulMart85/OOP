package Seminar6_java.representatives;

import Seminar6_java.model.GroundTransport;
import Seminar6_java.features.general.*;
import Seminar6_java.features.driving.*;

public class Quadbike extends GroundTransport {

    public Quadbike(Brand brand, Engine engine, Transmission transmission, GeneralFeat general, WheelFeat wheelFeat) {
        super(brand, engine, transmission, general, wheelFeat);
    }

}
