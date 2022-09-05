package Seminar4_java;

import java.util.List;

public class Arbalester extends BaseHero {
    
    public Arbalester() {
        super(String.format("Arbalester#%d", ++Arbalester.number), 10);
        attack = 6;
        defence = 3;
        shot = 16;
        damage = new int[]{2, 3};
        speed = 4;
    }

    @Override
    public void step(List<BaseHero> side1, List<BaseHero> side2) {
    
        
    }


}
