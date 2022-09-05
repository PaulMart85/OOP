package Seminar4_java;

import java.util.List;

public interface ActionsInterface {
    
    // void strike(BaseHero hero);
    // void getDamaged(int damagePower);
    // boolean changePosition();
    void step(List<BaseHero> side1, List<BaseHero> side2);
    String indicateState();

}
