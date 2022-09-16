package Seminar6_java.model;

import Seminar6_java.enums.VehicleType;
import Seminar6_java.features.general.*;
import Seminar6_java.iface.Haulage;

public abstract class Vehicle implements Haulage {

    private final VehicleType vehicleType; // тип ТС (наземный, воздушный...)
    private final GeneralFeat general; // масса, скорость, габариты     
    private final Engine engine; // хар-ки двигателя
    private final Brand brand; // хар-ки марки
    private final Transmission transmission; // хар-ки трансмиссии

    public Vehicle(VehicleType vehicleType, Brand brand, Engine engine, Transmission transmission, GeneralFeat general) {
        this.vehicleType = vehicleType;
        this.engine = engine;
        this.brand = brand;
        this.transmission = transmission;
        this.general = general;
    }

    @Override
    public String toString() {
        return "vehicleType=" + vehicleType + ", brand=" + brand + ", engine=" + engine +
               ", transmission=" + transmission + ", general=" + general;
    }

    @Override
    public String getHaulageType() {
        if (vehicleType.equals(VehicleType.AIR)) return "to the launch point";
        if (vehicleType.equals(VehicleType.GROUND)) return "with flexible hitch";
        if (vehicleType.equals(VehicleType.WATER)) return "push towing";
        return "Can't tow";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((engine == null) ? 0 : engine.hashCode());
        result = prime * result + ((vehicleType == null) ? 0 : vehicleType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehicle other = (Vehicle) obj;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (engine == null) {
            if (other.engine != null)
                return false;
        } else if (!engine.equals(other.engine))
            return false;
        if (vehicleType != other.vehicleType)
            return false;
        return true;
    }

}