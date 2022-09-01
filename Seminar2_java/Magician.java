package Seminar2_java;

public class Magician extends BaseHero {
   
    private boolean magic;

    public Magician() {
        super(String.format("Magician#%d", ++Magician.number), 30, 17, 12, 0, new int[]{-5, 0}, 9);
        magic = true;
    }

    @Override
    public String getInfo() {
        return String.format("%s  magic: %b", super.getInfo(), magic);
    }
}
