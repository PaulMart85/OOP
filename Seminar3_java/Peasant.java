package Seminar3_java;

import java.util.List;

public class Peasant extends BaseHero {

    private boolean delivery;

    public Peasant() {
        super(String.format("Peasant#%d", ++Peasant.number), 1);
        attack = 1;
        defence = 1;
        shot = 0;
        damage = new int[]{1, 0};
        speed = 3;
        delivery = true;  
    }

    @Override
    public String getInfo() {
        return String.format("%s  delivery: %b", super.getInfo(), delivery);
    }

    @Override
    public void step(List<BaseHero> side) {}
}
