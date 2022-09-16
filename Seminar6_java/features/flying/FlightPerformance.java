package Seminar6_java.features.flying;

public class FlightPerformance {
    private final float liftingForce; // подъемная сила
    private final float climbRate; // скорость набора высоты
    private final int ceiling; // макс высота подъема
    
    public FlightPerformance(float liftingForce, float climbRate, int ceiling) {
        this.liftingForce = liftingForce;
        this.climbRate = climbRate;
        this.ceiling = ceiling;
    }

    @Override
    public String toString() {
        return "FlightPerformance [ceiling=" + ceiling + ", climbRate=" + climbRate + 
               ", liftingForce=" + liftingForce + "]";
    }
    
}
