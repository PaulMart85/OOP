package Seminar4_java;

import java.util.List;

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

    public void setMagic(boolean magica) {
        magic = magica;
    }

    @Override
    public String getInfo() {
        return String.format("%s  magic: %b", super.getInfo(), magic);
    }

    /**
     * Маг лечит одного случайного героя из своего лагеря, в том числе может и себя.
     * При этом атака мага уменьшается с каждым лечением на 1.
     * При достижении атаки мага значения 0, маг теряет магическую силу и не может лечить.
     * Магическую силу магу могут восстанавливать только монахи своего лагеря.
     */
    @Override
    public void step() {

        if (currentHealth <= 0) {  // маг мертв
            state = "killed";
            return;
        }

        if (!magic) {  // у мага закончилась магическая сила
            state = "no magic";
            return;
        }

        // определяем лагерь мага
        List<BaseHero> list = Game.whiteSide;
        if (Game.darkSide.contains(this)) {
            list = Game.darkSide;
        }

        // определяем случайного героя из лагеря мага и, если он жив, лечим его
        int hr = rnd.nextInt(Game.heroesCount);
        BaseHero crntHero = list.get(hr);
        if (crntHero.state.equals("killed")) { // случайный герой мертв
            state = "stands";
            return;
        }
        crntHero.currentHealth -= damage[0]; // лечим случайного живого героя
        if (crntHero.currentHealth > crntHero.health) 
            crntHero.currentHealth = crntHero.health;
        attack--; // уменьшение атаки мага с каждым лечением
        magic = attack > 0; // проверка наличия магической силы
        state = String.valueOf("cures #" + hr);
    }

    @Override
    public boolean status() {
        return !state.equals("killed");
    }

}
