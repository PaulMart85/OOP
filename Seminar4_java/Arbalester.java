package Seminar4_java;


public class Arbalester extends BaseHero {
    
    public Arbalester() {
        super(String.format("Arbalester#%d", ++Arbalester.number), 10);
        attack = 6;
        defence = 3;
        shot = 16;
        damage = new int[]{2, 3};
        speed = 4;
    }

    /**
     * Арбалетчик поражает одного случайного героя из чужого лагеря силой в диапазоне damage.
     * Удар он наносит стрельбой пока у него имеются стрелы. С каждым ударом количество выстрелов
     * уменьшается на 1. Стрелы арбалетчику доставляют только копейщики своего лагеря.
     * Как только стрелы заканчиваются, арбалетчик идет врукопашную и наносит удар с силой 1.
     */
    @Override
    public void step() {
        stepForShooters(this);
    }

    @Override
    public boolean status() {
        return !state.equals("killed");
    }

}
