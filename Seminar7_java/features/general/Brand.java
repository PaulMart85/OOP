package Seminar7_java.features.general;

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
        return "Brand [brand=" + brand + ", bodyType=" + bodyType + ", model=" + model + ", passengerCapacity="
                + passengerCapacity + "]";
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
    
}
