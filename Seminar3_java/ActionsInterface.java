package Seminar3_java;

import java.util.List;

public interface ActionsInterface {
    
    // void strike(BaseHero hero);
    // void getDamaged(int damagePower);
    // boolean changePosition();
    void step(List<BaseHero> side);
    String indicateState();

}
