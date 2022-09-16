package Seminar7_java.model;

import Seminar7_java.enums.VehicleType;
import Seminar7_java.features.general.*;
import Seminar7_java.iface.Haulage;
import Seminar7_java.iface.Interface;

public abstract class Vehicle implements Haulage, Interface {

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
    public String getEnvironment() {
        if (vehicleType.equals(VehicleType.AIR)) 
            return String.format("wind speed: %sm/s, Meteominimum: %s, cloudiness: %sm", 7, "3B", 250);
        if (vehicleType.equals(VehicleType.GROUND)) 
            return String.format("air temperature: %s C, precipitation: %s, road surface condition: %s", -3, "wet snow", "sleet");
        if (vehicleType.equals(VehicleType.WATER)) 
            return String.format("water temperature: %s C, phase state of precipitation: %s, wind direction: %s", 12, "shower", "SW");
        return "undefined";
    }

    @Override
    public int getMaxSpeed() {
        return (int) general.getMaxSpeed();
    }

    @Override
    public String getHaulageType() {
        if (vehicleType.equals(VehicleType.AIR)) return "to the launch point";
        if (vehicleType.equals(VehicleType.GROUND)) return "with flexible hitch";
        if (vehicleType.equals(VehicleType.WATER)) return "push towing";
        return "can't tow";
    }

    public Brand getBrand() {
        return brand;
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