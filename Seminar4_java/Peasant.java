package Seminar4_java;

import java.util.List;

public class Peasant extends BaseHero {

    private boolean delivery;

    public Peasant() {
        super(String.format("Peasant#%d", ++Peasant.number), 1);
        attack = 1;
        defence = 1;
        shot = 0;
        damage = new int[]{1, 2};
        speed = 3;
        delivery = true;  
    }

    @Override
    public String getInfo() {
        return String.format("%s  delivery: %b", super.getInfo(), delivery);
    }

    /**
     * Крестьянин доставляет патроны снайперам своего лагеря, а также наносит удар противнику
     * камнем. За одну доставку он может передать снайперу магазин (10 шт) патронов в количестве 
     * магазинов из диапазона damage или нанести удар противнику с силой из этого же диапазона.  
     * С каждой доставкой магазинов, attack у крестьянина уменьшается на 1, и по достижении 0 
     * крестьянин уже не может достать патронов. Тогда он бьется только камнем. 
     * Если в лагере нет снайперов, то крестьяне воюют только камнями.
     */
    @Override
    public void step() {
        
        if (currentHealth <= 0) {  // крестьянин мертв
            state = "killed";
            return;
        }

        // определяем оба лагеря
        List<BaseHero> alienList = Game.whiteSide;
        List<BaseHero> ownList = Game.darkSide;
        if (Game.whiteSide.contains(this)) {
            alienList = Game.darkSide;
            ownList = Game.whiteSide;
        }

        // больше нет возможности доставать патроны, и крестьянин бьет камнем
        if (!delivery) { 
            stepForDelivers(alienList, this);
            return;
        }
        
        // есть возможность доставлять патроны
        int hr = rnd.nextInt(Game.heroesCount);
        BaseHero crntHero;
        crntHero = ownList.get(hr);
        if (crntHero.state.equals("killed")) { // случайный герой своего лагеря мертв
            state = "stands";
            return;
        }

        if (crntHero.getClass().getSimpleName().equals("Sniper")) { // доставляем ему патроны
            ((Sniper) crntHero).shot += 10 * ( damage[0] + (int)(Math.random()*(damage[1] - damage[0] + 1)) );
            state = String.valueOf("deliveres #" + hr);
            attack--; // уменьшение атаки крестьянина с каждой доставкой
            delivery = attack > 0; // проверка возможности доставлять патроны
        }
        else { // или бьем камнем противника
            stepForDelivers(alienList, this);
        }
        
    }

    @Override
    public boolean status() {
        return !state.equals("killed");
    }
}
