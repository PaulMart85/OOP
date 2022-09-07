package Seminar4_java;

import java.util.List;
import java.util.Random;

// import static Seminar4_java.Game.darkSide;
// import static Seminar4_java.Game.whiteSide;

public abstract class BaseHero implements ActionsInterface {
    protected static int number;
    Random rnd = new Random();

    protected String name;
    protected int attack;
    protected int defence;
    protected int shot;
    protected int[] damage;
    protected int health; 
    protected int currentHealth;
    protected int speed;
    protected String state;
    protected Vector2 position;
    
    static {
        number = 0;
    }

    public BaseHero(String name, int health) {
        this.name = name;
        currentHealth = this.health = health;
        state = "stands";
    }

    /**
     * Полная информация об исходном герое
     * @return String
     */
    public String getInfo() {
        return String.format("%s: %s  hlth: %d  attk: %d  protect: %d  shot: %d  dmg: %d-%d  speed: %d",
        this.getClass().getSimpleName(), name, health, attack, defence, shot, damage[0], damage[1], speed);
    }

    /**
     * текущее состояние героя
     * @return String
     */
    @Override
    public String indicateState() {
        return name + " H:" + currentHealth + " S:" + shot + " A:" + attack + " " + state;
    }

    /**
     * Общий метод step() для стрелков: Arbalester и Sniper
     */
    public void stepForShooters(BaseHero shooter) {

        if (shooter.currentHealth <= 0) {  // стрелок мертв
            shooter.state = "killed";
            return;
        }

        // определяем лагерь противника
        List<BaseHero> list = Game.whiteSide;
        if (Game.whiteSide.contains(shooter)) {
            list = Game.darkSide;
        }

        // определяем случайного героя из лагеря противника и, если он жив, наносим ему удар
        int hr = rnd.nextInt(Game.heroesCount);
        BaseHero crntHero = list.get(hr);
        if (crntHero.state.equals("killed")) { // случайный герой мертв
            shooter.state = "stands";
            return;
        }

        // наносим удар случайному живому герою противнику
        if (shooter.shot <= 0) { // патроны/стрелы закончились, бой врукопашную
            crntHero.currentHealth -= 1;
            shooter.state = String.valueOf("strikes #" + hr); 
        }
        else { // стреляет из ружья/арбалета
            crntHero.currentHealth -= 
                shooter.damage[0] + (int)(Math.random()*(shooter.damage[1] - shooter.damage[0] + 1));
            shooter.state = String.valueOf("shoots #" + hr); 
            shooter.shot--; // уменьшение количества патронов/стрел с каждым выстрелом
        }
        if (crntHero.currentHealth <= 0) {
            crntHero.currentHealth = 0;
            crntHero.state = "killed";
            shooter.state = String.valueOf("kills #" + hr);
        }
    }

    /**
     * Общий метод step() для доставщиков: Spearman и Peasant
     */
    public void stepForDelivers(List<BaseHero> side, BaseHero deliver) {

        int hr = rnd.nextInt(Game.heroesCount);
        BaseHero crntHero = side.get(hr);
        if (crntHero.state.equals("killed")) { // случайный герой противника мертв
            deliver.state = "stands";
            return;
        }

        // наносим удар случайному живому герою противнику
        crntHero.currentHealth -= 
            deliver.damage[0] + (int)(Math.random()*(deliver.damage[1] - deliver.damage[0] + 1));
        deliver.state = String.valueOf("strikes #" + hr); 
        if (crntHero.currentHealth <= 0) {
            crntHero.currentHealth = 0;
            crntHero.state = "killed";
            deliver.state = String.valueOf("kills #" + hr);
        }
    }

    // все имена уникальны
    @Override
    public boolean equals(Object obj) {
        return name.equals( ((BaseHero) obj).name );
    }


}