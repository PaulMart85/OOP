package Seminar5_java;

public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return x==((Coordinates) obj).x && y==((Coordinates) obj).y;
    }
}
