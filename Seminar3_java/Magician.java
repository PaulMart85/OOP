package Seminar3_java;

import java.util.List;
import java.util.Random;

public class Magician extends BaseHero {
   
    private boolean magic;

    public Magician() {
        super(String.format("Magician#%d", ++Magician.number), 30);
        attack = 17;
        defence = 12;
        shot = 0;
        damage = new int[]{-5, 0};
        speed = 9;
        magic = true;
    }

    @Override
    public String getInfo() {
        return String.format("%s  magic: %b", super.getInfo(), magic);
    }

    /**
     * маг лечит одного случайного героя из своего лагея, в том числе и себя
     */
    @Override
    public void step(List<BaseHero> side) {
        side.get(new Random().nextInt(side.size())).health -= damage[0];
    }
}
