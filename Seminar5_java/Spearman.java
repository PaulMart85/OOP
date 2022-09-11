package Seminar5_java;

import java.util.List;

public class Spearman extends BaseHero {

    private boolean delivery;
    
     /**
     * Копейщик доставляет стрелы арбалетчикам своего лагеря, а также наносит удар противнику
     * копьем. За одну доставку он может поднести арбалетчику стрелы в количестве из диапазона damage 
     * или нанести удар противнику с силой из этого же диапазона.  
     * С каждой доставкой стрел, attack у копейщика уменьшается на 1, и по достижении 0 копейщик уже 
     * не может достать стрел. Тогда он бьется только копьем. 
     * Если в лагере нет арбалетчиков, то копейщик воюет только копьем.
     */
    public Spearman() {
        super(String.format("Spearman#%d", ++Spearman.number), 10);
        attack = 4;
        defence = 5;
        shot = 0;
        damage = new int[]{1, 3};
        speed = 4;
        delivery = true; 
    }

    @Override
    public String getInfo() {
        return String.format("%s  delivery: %b", super.getInfo(), delivery);
    }


    @Override
    public void step() {

        if (currentHealth <= 0) {  // копейщик мертв
            state = "killed";
            return;
        }

        // определяем оба лагеря
        List<BaseHero> alienList = Game.redSide;
        List<BaseHero> ownList = Game.blueSide;
        if (Game.redSide.contains(this)) {
            alienList = Game.blueSide;
            ownList = Game.redSide;
        }

        // больше нет возможности доставать стрелы, и копейщик бьет копьем
        if (!delivery) { 
            stepForDelivers(alienList, this);
            return;
        }
        
        // есть возможность доставлять стрелы
        int hr = rnd.nextInt(Game.heroesCount);
        BaseHero crntHero;
        crntHero = ownList.get(hr);
        if (crntHero.state.equals("killed")) { // случайный герой своего лагеря мертв
            state = "stands";
            return;
        }

        if (crntHero.getClass().getSimpleName().equals("Arbalester")) { // доставляем ему стрелы
            ((Arbalester) crntHero).shot += damage[0] + (int)(Math.random()*(damage[1] - damage[0] + 1));
            state = String.valueOf("deliveres #" + hr);
            attack--; // уменьшение атаки копейщика с каждой доставкой
            delivery = attack > 0; // проверка возможности доставлять стрелы
        }
        else { // или бьем копьем противника
            stepForDelivers(alienList, this);
        }
        
    }

    @Override
    public boolean status() {
        return !state.equals("killed");
    }

}
