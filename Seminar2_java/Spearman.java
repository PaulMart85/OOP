package Seminar2_java;

public class Spearman extends BaseHero {
    
    public Spearman() {
        super(String.format("Spearman#%d", ++Spearman.number), 10, 4, 5, 0, new int[]{1, 3}, 4);
    }
}
