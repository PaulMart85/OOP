package Seminar3_java;

import java.util.List;

public class Robber extends BaseHero {
    
    public Robber() {
        super(String.format("Robber#%d", ++Robber.number), 10);
        attack = 8;
        defence = 3;
        shot = 0;
        damage = new int[]{2, 4};
        speed = 6;
    }

    @Override
    public void step(List<BaseHero> side) {}

}
