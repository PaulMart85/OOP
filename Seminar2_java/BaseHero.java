package Seminar2_java;


public abstract class BaseHero {
    protected static int number;

    private String name;
    private int attack;
    private int defence;
    private int shot;
    private int[] damage;
    private int health;
    private int speed;
    private boolean status;
    
    static {
        number = 0;
    }

    public BaseHero(String name, int health) {
        this.name = name;
        this.health = health;
        status = true;
    }

    public BaseHero(String name, int health, int attack, int protection, 
                    int shot, int[] damage, int speed) {
        this(name, health);
        this.attack = attack;
        this.defence = protection;
        this.shot = shot;
        this.damage = damage;
        this.speed = speed;
    }

    public String getInfo() {
        return String.format("%s: %s  hlth: %d  attk: %d  protect: %d  shot: %d  dmg: %d-%d  speed: %d",
        this.getClass().getSimpleName(), name, health, attack, defence, shot, damage[0], damage[1], speed);
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int[] getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getShot() {
        return shot;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean getStatus() {
        return status;
    }

}