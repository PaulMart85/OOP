package Seminar6_java.representatives;

import Seminar6_java.model.GroundTransport;
import Seminar6_java.features.general.*;
import Seminar6_java.iface.Doors;
import Seminar6_java.iface.Wheels;
import Seminar6_java.features.driving.*;

public class Car extends GroundTransport implements Wheels, Doors {

    // здесь могут располагаться еще поля, характерные для сущности автомобиль

    public Car(Brand brand, Engine engine, Transmission transmission, GeneralFeat general, WheelFeat wheelFeat) {
        super(brand, engine, transmission, general, wheelFeat);
    }

    @Override
    public int getWheelsCount(WheelFeat wheelArrangement) {
        return Integer.parseInt(wheelArrangement.getWheelArrangement().split("x")[0]);
    }

    @Override
    public int[] getTiresSize() {
        return new int[]{195, 55, 16};
    }

    @Override
    public int getDoorsCount() {
        return 4;
    }

}
