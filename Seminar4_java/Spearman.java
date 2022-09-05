package Seminar4_java;

import java.util.List;
import java.util.Random;

public class Spearman extends BaseHero {
    
    public Spearman() {
        super(String.format("Spearman#%d", ++Spearman.number), 10);
        attack = 4;
        defence = 5;
        shot = 0;
        damage = new int[]{1, 3};
        speed = 4;
    }

    @Override
    public void step(List<BaseHero> side1, List<BaseHero> side2) {
        int hr = new Random().nextInt(side2.size());
        side2.get(hr).health -= damage[0];
        state = String.valueOf(hr);
        
    }

}
