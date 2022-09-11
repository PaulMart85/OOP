package Seminar5_java;


public class Sniper extends BaseHero {
    
    /**
     * Снайпер поражает одного случайного героя из чужого лагеря силой в диапазоне damage.
     * Удар он наносит ружьем пока у него имеются патроны. С каждым выстрелом количество их
     * уменьшается на 1. Патроны снайперу доставляют только крестьяне своего лагеря.
     * Как только патроны заканчиваются, снайпер идет врукопашную и наносит удар с силой 1.
     */
    public Sniper() {
        super(String.format("Sniper#%d", ++Sniper.number), 15);
        attack = 12;
        defence = 10;
        shot = 32;
        damage = new int[]{8, 10};
        speed = 9;
    }

    @Override
    public void step() {
        stepForShooters(this);
    }

    @Override
    public boolean status() {
        return !state.equals("killed");
    }
}
