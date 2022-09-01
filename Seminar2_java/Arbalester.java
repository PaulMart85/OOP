package Seminar2_java;

public class Arbalester extends BaseHero {
    
    public Arbalester() {
        super(String.format("Arbalester#%d", ++Arbalester.number), 10, 6, 3, 16, new int[]{2, 3}, 4);
    }

}
