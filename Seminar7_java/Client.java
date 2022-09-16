package Seminar7_java;

import java.util.ArrayList;
import java.util.List;

import Seminar7_java.enums.*;
import Seminar7_java.features.general.*;
import Seminar7_java.features.driving.*;
import Seminar7_java.features.floating.*;
import Seminar7_java.features.flying.*;
import Seminar7_java.model.*;
import Seminar7_java.representatives.*;

// BMW G 310 R - мотоцикл
    // KAWASAKI NINJA 400 - мотоцикл
    // SUZUKI SV650 ABS (SV650A)- мотоцикл
    // YAMAHA XJ6 - мотоцикл
    // BMW F 800 GT- мотоцикл
    // HARLEY-DAVIDSON SUPERLOW- мотоцикл
    // Ford Fiesta - автомобиль
    // Kia Picanto- автомобиль
    // Infiniti QX60- автомобиль
    // Nissan Juke- автомобиль
    // Audi А3- автомобиль
    // Lexus ES 200- автомобиль
    // Honda Talon 1000X- автомобиль
    // RM 800 DUO - квадроцикл
    // Stels ATV 650 Guepard ST - квадроцикл
    // Yamaha YFZ450R SE - квадроцикл
    // CFMOTO CFORCE 600 S EPS - квадроцикл
    // Polaris Sportsman 570 - квадроцикл
    // SEA-DOO PERFORMANCE RXP-X 300 - гидроцикл
    // YAMAHA FX CRUISER SVHO - гидроцикл
    // SEA-DOO SPARK TRIXX 3UP- гидроцикл
    // GEN H-4 - вертолет
    // Air Scooter 2  - вертолет
    // Dynali H2S  - вертолет
    // DF Helicopters DF334  - вертолет

public class Client {

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new Brand("Ford", "Fiesta", "sedan", 5), 
                    new Engine(EngineType.I, "Ford VI", 1.5f, FuelType.A92),
                       new Transmission(GearBox.AUTO, SteeringWheelType.WHEEL, BreakClutchType.MECHANICAL, BreakClutchType.HYDRAULIC),
                          new GeneralFeat(650.0f, 190.0f, new float[]{3.0f, 1.75f, 1.65f}), 
                             new WheelFeat("4x2", 245)));
        cars.add(new Car(new Brand("Kia", "Picanto", "hatchback", 4), 
                    new Engine(EngineType.J, "KIA M-I", 1.4f, FuelType.A92),
                       new Transmission(GearBox.AUTO, SteeringWheelType.WHEEL, BreakClutchType.MECHANICAL, BreakClutchType.HYDRAULIC),
                          new GeneralFeat(550.0f, 170.0f, new float[]{2.4f, 1.42f, 1.7f}), 
                             new WheelFeat("4x2", 200)));
        cars.add(new Car(new Brand("Infiniti", "QX60", "van", 5), 
                    new Engine(EngineType.V, "HONDA VMI", 3.3f, FuelType.A105),
                        new Transmission(GearBox.AUTO, SteeringWheelType.WHEEL, BreakClutchType.MECHANICAL, BreakClutchType.HYDRAULIC),
                            new GeneralFeat(950.0f, 290.0f, new float[]{3.4f, 1.95f, 1.85f}), 
                                new WheelFeat("4x4", 280)));

        List<Motorbike> motorbikes = new ArrayList<>();
        motorbikes.add(new Motorbike(new Brand("YAMAHA", "XJ6", "chopper", 2), 
                          new Engine(EngineType.I, "KAWASAKI S300", 2.3f, FuelType.A95),
                             new Transmission(GearBox.MANUAL, SteeringWheelType.KLIPON, BreakClutchType.MECHANICAL, BreakClutchType.HYDRAULIC),
                                new GeneralFeat(220.0f, 310.0f, new float[]{2.0f, 0.55f, 1.55f}), 
                                   new WheelFeat("2x1", 186)));
        motorbikes.add(new Motorbike(new Brand("HARLEY-DAVIDSON", "SUPERLOW", "street", 3), 
                            new Engine(EngineType.I, "TOYOTA A40", 2.0f, FuelType.DIESEL),
                                new Transmission(GearBox.AUTO, SteeringWheelType.KLIPON, BreakClutchType.MECHANICAL, BreakClutchType.HYDRAULIC),
                                    new GeneralFeat(280.0f, 300.0f, new float[]{2.4f, 0.55f, 1.6f}), 
                                        new WheelFeat("2x1", 205)));

        List<Quadbike> quads = new ArrayList<>();
        quads.add(new Quadbike(new Brand("Polaris", "Sportsman 570", "buggy", 3), 
                          new Engine(EngineType.U, "KAWASAKI A100", 1.9f, FuelType.ELECTRIC_BATTERY),
                             new Transmission(GearBox.MANUAL, SteeringWheelType.KLIPON, BreakClutchType.MECHANICAL, BreakClutchType.HYDRAULIC),
                                new GeneralFeat(240.0f, 170.0f, new float[]{2.2f, 1.45f, 1.5f}), 
                                   new WheelFeat("4x4", 190)));

        List<JetSki> jetskis = new ArrayList<>();
        jetskis.add(new JetSki(new Brand("SEA-DOO", "PERFORMANCE RXP-X 300", "double seat", 2), 
                          new Engine(EngineType.J, "Yamaha WR10", 1.5f, FuelType.A93),
                             new Transmission(GearBox.MANUAL, SteeringWheelType.KLIPON, BreakClutchType.PNEUMATIC, BreakClutchType.HYDRAULIC),
                                new GeneralFeat(140.0f, 110.0f, new float[]{1.8f, 0.95f, 1.4f}), 
                                   new BuoyancyIndicators(88, 120)));
        jetskis.add(new JetSki(new Brand("YAMAHA", "FX CRUISER SVHO", "MI", 2), 
                        new Engine(EngineType.J, "YAMA 100", 1.6f, FuelType.A93),
                            new Transmission(GearBox.MANUAL, SteeringWheelType.KLIPON, BreakClutchType.PNEUMATIC, BreakClutchType.HYDRAULIC),
                                new GeneralFeat(150.0f, 120.0f, new float[]{1.9f, 0.85f, 1.5f}), 
                                    new BuoyancyIndicators(90, 120)));   
        
        List<Helicopter> helicopters = new ArrayList<>();
        helicopters.add(new Helicopter(new Brand("Air", "Scooter 2", "stels", 2), 
                          new Engine(EngineType.I, "Lycoming", 3.3f, FuelType.KEROSENE),
                             new Transmission(GearBox.HYBRID, SteeringWheelType.HELM, BreakClutchType.MECHANICAL, BreakClutchType.ELECTRIC),
                                new GeneralFeat(1950.0f, 350.5f, new float[]{3.75f, 1.95f, 3.5f}), 
                                   new FlightPerformance(1000, 95, 3500)));
        helicopters.add(new Helicopter(new Brand("Dynali", "H2S", "military", 6), 
                            new Engine(EngineType.V, "Rotax", 4.8f, FuelType.KEROSENE),
                                new Transmission(GearBox.HYBRID, SteeringWheelType.HELM, BreakClutchType.MECHANICAL, BreakClutchType.ELECTRIC),
                                    new GeneralFeat(2150.0f, 300.0f, new float[]{4.05f, 2.15f, 3.7f}), 
                                        new FlightPerformance(900, 75, 3000)));

        List<Vehicle> transport = new ArrayList<>();
        transport.addAll(cars);
        transport.addAll(motorbikes);
        transport.addAll(quads);
        transport.addAll(jetskis);
        transport.addAll(helicopters);

        transport.forEach(vehicle -> 
                    System.out.println(String.format("%s %s %s:\n{%s}  {max speed: %s}  {%s}\n", vehicle.getClass().getSimpleName(), vehicle.getBrand().getBrand(), vehicle.getBrand().getModel(),
                                            vehicle.toString(), vehicle.getMaxSpeed(), vehicle.getEnvironment())));
        
        // System.out.println(car);    
        // tranThisCar.setGearBox(GearBox.MANUAL);
        // gener.setMaxSpeed(320.0f);
        // wheels.setWheelArrangement("4x4");
        // wheels.setWheelBase(255);
        // System.out.println(car);
        // System.out.println(car.getWheelsCount(wheels));
        // System.out.println(car.getHaulageType());
    }
    
}