package Seminar7_java.iface;

import Seminar7_java.features.driving.WheelFeat;

public interface Wheels {

    int getWheelsCount(WheelFeat wheelArrangement); // запросить количество колес 
    
    int[] getTiresSize(); // получить маркировку шины

}
