package Seminar3_java;

import java.util.List;

public class Monk extends BaseHero {

    private boolean magic;

    public Monk() {
        super(String.format("Monk#%d", ++Monk.number), 30);
        attack = 12;
        defence = 7;
        shot = 0;
        damage = new int[]{-4, 0};
        speed = 5;
        magic = true;
    }

    @Override
    public String getInfo() {
        return String.format("%s  magic: %b", super.getInfo(), magic);
    }

    @Override
    public void step(List<BaseHero> side) {}

}
