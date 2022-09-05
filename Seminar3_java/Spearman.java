package Seminar3_java;

import java.util.List;

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
    public void step(List<BaseHero> side) {}

}
