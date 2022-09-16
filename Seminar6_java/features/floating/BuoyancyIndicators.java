package Seminar6_java.features.floating;

public class BuoyancyIndicators {
    private final float maxDisplacement; // полное водоизмещение
    private final float deadweight; // дедвейт
    
    public BuoyancyIndicators(float maxDisplacement, float deadweight) {
        this.maxDisplacement = maxDisplacement;
        this.deadweight = deadweight;
    }

    @Override
    public String toString() {
        return "BuoyancyIndicators [deadweight=" + deadweight + ", maxDisplacement=" + maxDisplacement + "]";
    }

}
