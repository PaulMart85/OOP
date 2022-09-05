package Seminar4_java;

import java.util.List;
import java.util.Random;

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
    public void step(List<BaseHero> side1, List<BaseHero> side2) {
        int hr = new Random().nextInt(side2.size());
        side2.get(hr).health -= damage[0];
        state = String.valueOf(hr);   
    }

}
