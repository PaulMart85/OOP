package Seminar6_java.iface;

import Seminar6_java.features.driving.WheelFeat;

public interface Wheels {

    int getWheelsCount(WheelFeat wheelArrangement); // запросить количество колес 
    
    int[] getTiresSize(); // получить маркировку шины

}
