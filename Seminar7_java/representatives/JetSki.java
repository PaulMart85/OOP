package Seminar7_java.representatives;

import Seminar7_java.model.WaterTransport;
import Seminar7_java.features.general.*;
import Seminar7_java.features.floating.*;

public class JetSki extends WaterTransport {

    public JetSki(Brand brand, Engine engine, Transmission transmission, GeneralFeat general,
            BuoyancyIndicators buoyancyIndicators) {
        super(brand, engine, transmission, general, buoyancyIndicators);
    }

}
