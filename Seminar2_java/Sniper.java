package Seminar2_java;

public class Sniper extends BaseHero {
    
    public Sniper() {
        super(String.format("Sniper#%d", ++Sniper.number), 15, 12, 10, 32, new int[]{8, 10}, 9);
    }
}
