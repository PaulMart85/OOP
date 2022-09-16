package Seminar6_java.features.general;

import java.util.Arrays;

public class GeneralFeat {
    protected float vehicleWeight; // масса средства
    protected float maxSpeed; // максимально возможная скорость движения
    protected float[] dimensions; // габариты TC
    
    public GeneralFeat(float vehicleWeight, float maxSpeed, float[] dimensions) {
        this.vehicleWeight = vehicleWeight;
        this.maxSpeed = maxSpeed;
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return "GeneralFeat [dimensions=" + Arrays.toString(dimensions) + ", maxSpeed=" + maxSpeed + ", vehicleWeight="
                + vehicleWeight + "]";
    }

    public void setVehicleWeight(float vehicleWeight) {
        this.vehicleWeight = vehicleWeight;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setDimensions(float[] dimensions) {
        this.dimensions = dimensions;
    }

}
