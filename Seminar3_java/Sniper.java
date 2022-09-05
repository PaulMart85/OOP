package Seminar3_java;

import java.util.List;

public class Sniper extends BaseHero {
    
    public Sniper() {
        super(String.format("Sniper#%d", ++Sniper.number), 15);
        attack = 12;
        defence = 10;
        shot = 32;
        damage = new int[]{8, 10};
        speed = 9;
    }

    @Override
    public void step(List<BaseHero> side) {}

}
