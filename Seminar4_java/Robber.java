package Seminar4_java;

import java.util.List;

public class Robber extends BaseHero {
    
    public Robber() {
        super(String.format("Robber#%d", ++Robber.number), 10);
        attack = 8;
        defence = 3;
        shot = 0;
        damage = new int[]{2, 4};
        speed = 6;
    }

    /**
     * Грабитель разбойничает во вражеском лагере.
     * Он может украсть стрелы у арбалетчика или патроны у снайпера
     * и передать их стрелкам в свой лагерь.
     * Он крадет стрелы/патроны в количестве из диапазона damage.
     * С каждой кражей, attack у грабителя уменьшается на 1 и по достижении 0
     * грабитель больше не крадет. 
     * Тогда он живет (может только перемещаться по полю) до момента, пока его не убьют 
     * или пока его лагерь не победит.
     */
    @Override
    public void step() {
        
        if (currentHealth <= 0) {  // грабитель мертв
            state = "killed";
            return;
        }

        if (attack <= 0) {  // больше не крадет
            state = "hides";
            return;
        }

        // определяем оба лагеря 
        List<BaseHero> alienList = Game.whiteSide;
        List<BaseHero> ownList = Game.darkSide;
        if (Game.whiteSide.contains(this)) {
            alienList = Game.darkSide;
            ownList = Game.whiteSide;
        }

        // грабитель крадет
        int hr = rnd.nextInt(Game.heroesCount);
        BaseHero crntHero;
        crntHero = alienList.get(hr);
        if (crntHero.state.equals("killed")) { // случайный герой чужого лагеря мертв
            state = "stands";
            return;
        }
        
        int stolen = 0; // будет украдено фактически

        if (crntHero.getClass().getSimpleName().equals("Arbalester") ||
        crntHero.getClass().getSimpleName().equals("Sniper")) { // крадем у него стрелы/патроны
            int wouldSteal = damage[0] + (int)(Math.random()*(damage[1] - damage[0] + 1)); // хотим украсть столько
            crntHero.shot -= wouldSteal; // пытаемся украсть 
            if (crntHero.shot <= 0) {
                stolen = wouldSteal - Math.abs(crntHero.shot); // в итоге украли столько
                crntHero.shot = 0;
            } else stolen = wouldSteal; // или столько
            shot += stolen; // теперь у грабителя столько стрел/патронов
        }

        if (shot > 0) { // передача стрел/патронов в свой лагерь
            for (BaseHero hero : ownList)
                if (hero.getClass().getSimpleName().equals("Arbalester") || 
                    hero.getClass().getSimpleName().equals("Sniper")) 
                        if (!hero.state.equals("killed")) {
                            hero.shot += shot; // передаем стрелы/патроны стрелку
                            shot = 0;
                            state = String.valueOf("deliveres #" + ownList.indexOf(hero));
                            break;
                        }
                      
            if (stolen > 0) {
                state = shot==0 ? String.valueOf("steals #" + hr) + " " + state : String.valueOf("steals #" + hr);
                attack--; // уменьшение атаки грабителя с каждой кражей
            }
        } else state = "stands";        
        
    }

    @Override
    public boolean status() {
        return !state.equals("killed");
    }

}
