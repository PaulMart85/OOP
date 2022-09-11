package Seminar5_java;


public interface ActionsInterface {
    
    // void strike(BaseHero hero);
    // void getDamaged(int damagePower);
    // boolean changePosition();

    /**
     * Проверка статуса героя на предмет 'жив-мертв'.
     * @return true - жив,
     * false - мертв
     */
    boolean status();

    /**
     * Действие каждого героя за один шаг боя.
     */
    void step();

    /**
     * Проверка состояния героя на текущий момент игры.
     * @return String с текущими показателями состояния героя
     */
    String indicateState();

    

}
