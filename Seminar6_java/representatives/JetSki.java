package Seminar6_java.representatives;

import Seminar6_java.model.WaterTransport;
import Seminar6_java.features.general.*;
import Seminar6_java.features.floating.*;

public class JetSki extends WaterTransport {

    public JetSki(Brand brand, Engine engine, Transmission transmission, GeneralFeat general,
            BuoyancyIndicators buoyancyIndicators) {
        super(brand, engine, transmission, general, buoyancyIndicators);
    }

}
