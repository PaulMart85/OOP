package Seminar6_java.features.general;

public class Brand {

    private final String brand; // марка
    private final String model; // модель
    private final String bodyType; // тип кузова
    private final int passengerCapacity; // пассажировместимость
    
    public Brand(String brand, String model, String bodyType, int passengerCapacity) {
        this.brand = brand;
        this.model = model;
        this.bodyType = bodyType;
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String toString() {
        return "Brand [bodyType=" + bodyType + ", brand=" + brand + ", model=" + model + ", passengerCapacity="
                + passengerCapacity + "]";
    }
    
}
