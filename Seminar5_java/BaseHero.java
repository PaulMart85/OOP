package Seminar5_java;

import java.util.List;
import java.util.Random;


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
    protected Coordinates position;
    
    static {
        number = 0;
    }

    public BaseHero(String name, int health) {
        this.name = name;
        currentHealth = this.health = health;
        state = "stands";
        position = new Coordinates(0, 0);
    }

    /**
     * Полная информация об исходном герое.
     * @return String из роль героя, name, исходного health, attack, defence,
     * shot, диапазон силы damage и speed
     */
    public String getInfo() {
        return String.format("%s: %s  hlth: %d  attk: %d  protect: %d  shot: %d  dmg: %d-%d  speed: %d",
        this.getClass().getSimpleName(), name, health, attack, defence, shot, damage[0], damage[1], speed);
    }

    /**
     * Текущее состояние героя.
     * @return String из name, currentHealth, shots если имеются, attack, расстояние до ближайшего героя и state
     */
    @Override
    public String indicateState() {
        return String.format("%s H:%d%s A:%d Dst:%dto#%d St:%s", name, currentHealth, (shot>0?" S:" + shot:""), attack, getDistance().y, getDistance().x, state);
    }

    /**
     * Общий метод step() для стрелков: Arbalester и Sniper.
     */
    public void stepForShooters(BaseHero shooter) {

        if (shooter.currentHealth <= 0) {  // стрелок мертв
            shooter.state = "killed";
            return;
        }

        // определяем лагерь противника
        List<BaseHero> list = Game.redSide;
        if (Game.redSide.contains(shooter)) {
            list = Game.blueSide;
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
     * Общий метод step() для доставщиков: Spearman и Peasant.
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

    // Все имена уникальны
    @Override
    public boolean equals(Object obj) {
        return name.equals( ((BaseHero) obj).name );
    }

    /**
     * Расстояние до ближайшего героя вражеского лагеря. 
     * @return Coordinates(x, y): x - номер героя в списке, y - расстояние до него
     */
    public Coordinates getDistance(){
        
        double dist = Integer.MAX_VALUE; // расстояние до ближайшего героя
        int toHero = 0; // ближайший по отношению к текущему герой из вражеского лагеря
        int dX, dY;
        double tD;

        // определяем лагерь противника
        List<BaseHero> side = Game.redSide;
        if (Game.redSide.contains(this)) {
            side = Game.blueSide;
        }

        for (int i = 0; i < Game.heroesCount; i++) {
            dX = Math.abs(side.get(i).position.x - position.x);
            dY = Math.abs(side.get(i).position.y - position.y);
            tD = Math.sqrt(dX*dX + dY*dY);
            if (dist > tD) {
                toHero = i + 1;
                dist = tD;
            }
        }

        return new Coordinates(toHero, (int) Math.round(dist));
    }

}