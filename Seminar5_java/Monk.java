package Seminar5_java;

import java.util.List;

public class Monk extends BaseHero {

    private boolean magic;

     /**
     * Монах лечит одного случайного героя из своего лагеря, в том числе может и себя.
     * Если случайный герой маг, то лечение монахом мага заключается в восстановлении 
     * у мага магической силы, но не здоровья.
     * При этом атака монаха уменьшается с каждым лечением на 1.
     * При достижении атаки монаха значения 0, монах теряет магическую силу и не может лечить.
     * Тогда он живет (может только перемещаться по полю) до момента, пока его не убьют 
     * или пока его лагерь не победит.
     */
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
    public void step() {

        if (currentHealth <= 0) {  // монах мертв
            state = "killed";
            return;
        }

        if (!magic) {  // у монаха закончилась магическая сила
            state = "no magic";
            return;
        }

        // определяем лагерь монаха
        List<BaseHero> list = Game.redSide;
        if (Game.blueSide.contains(this)) {
            list = Game.blueSide;
        }

        // определяем случайного героя из лагеря монаха и, если он жив, лечим его
        int hr = rnd.nextInt(Game.heroesCount);
        BaseHero crntHero = list.get(hr);
        if (crntHero.state.equals("killed")) { // случайный герой мертв
            state = "stands";
            return;
        }

        if (crntHero.getClass().getSimpleName().equals("Magician")) { // восстанавливаем магическую силу магу
            crntHero.attack +=1;
            ((Magician) crntHero).setMagic(true);
            state = String.valueOf("recoveres #" + hr);
        }
        else {
            crntHero.currentHealth -= damage[0]; // или лечим случайного живого героя
            if (crntHero.currentHealth > crntHero.health) 
                crntHero.currentHealth = crntHero.health;
            state = String.valueOf("cures #" + hr);
        }
        
        attack--; // уменьшение атаки монаха с каждым лечением
        magic = attack > 0; // проверка наличия магической силы       
    }

    @Override
    public boolean status() {
        return !state.equals("killed");
    }

}
