package Seminar7_java.features.general;

import Seminar7_java.enums.BreakClutchType;
import Seminar7_java.enums.GearBox;
import Seminar7_java.enums.SteeringWheelType;

public class Transmission {
    protected GearBox gearBox; // коробка передач
    private final SteeringWheelType steeringWheelType; // тип рулевого управления
    private final BreakClutchType clutchType; // тип сцепления
    private final BreakClutchType breakeSystemType; // тип тормозной системы

    public Transmission(GearBox gearBox, SteeringWheelType steeringWheelType, BreakClutchType clutchType,
            BreakClutchType breakeSystemType) {
        this.gearBox = gearBox;
        this.steeringWheelType = steeringWheelType;
        this.clutchType = clutchType;
        this.breakeSystemType = breakeSystemType;
    }

    @Override
    public String toString() {
        return "Transmission [breakeSystemType=" + breakeSystemType + ", clutchType=" + clutchType + ", gearBox="
                + gearBox + ", steeringWheelType=" + steeringWheelType + "]";
    }

    public void setGearBox(GearBox gearBox) {
        this.gearBox = gearBox;
    }

}
