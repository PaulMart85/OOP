package Seminar3_java;


public abstract class BaseHero implements ActionsInterface {
    protected static int number;

    protected String name;
    protected int attack;
    protected int defence;
    protected int shot;
    protected int[] damage;
    protected int health;
    protected int speed;
    protected boolean status;
    
    static {
        number = 0;
    }

    public BaseHero(String name, int health) {
        this.name = name;
        this.health = health;
        status = true;
    }

    /**
     * Полная информация о герое
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
        return name + " H:" + health + " D:" + defence + " A:" + attack + " " + status;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(obj);
    }


}