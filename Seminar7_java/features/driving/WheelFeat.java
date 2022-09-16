package Seminar7_java.features.driving;

public class WheelFeat {

    protected String wheelArrangement; // колесная формула
    protected int wheelBase; // колесная база
    
    public WheelFeat(String wheelArrangement, int wheelBase) {
        this.wheelArrangement = wheelArrangement;
        this.wheelBase = wheelBase;
    }

    @Override
    public String toString() {
        return "WheelFeat [wheelArrangement=" + wheelArrangement + ", wheelBase=" + wheelBase + "]";
    }

    public void setWheelArrangement(String wheelArrangement) {
        this.wheelArrangement = wheelArrangement;
    }

    public String getWheelArrangement() {
        return wheelArrangement;
    }

    public void setWheelBase(int wheelBase) {
        this.wheelBase = wheelBase;
    }

}
