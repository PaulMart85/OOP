package Seminar4_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    protected static final int heroesCount;  // количество игроков в команде

    protected static final List<BaseHero> darkSide; // команда черных
    protected static final List<BaseHero> whiteSide; // команда белых

    static {
        heroesCount = 10;
        darkSide = new ArrayList<>(heroesCount);
        whiteSide = new ArrayList<>(heroesCount);
    }

    public static void main(String[] args) {

        // наполнение команд
        darkSide.add(new Peasant());
        darkSide.add(new Arbalester());
        darkSide.add(new Magician());
        darkSide.add(new Monk());
        darkSide.add(new Spearman());
        darkSide.add(new Robber());
        darkSide.add(new Sniper());

        Random rnd = new Random();
        for (int i = 0; i < heroesCount-7; i++) {
            switch (rnd.nextInt(heroesCount-6)){
                case 0:
                    darkSide.add(new Peasant());
                    break;
                case 1:
                    darkSide.add(new Robber());
                    break;
                case 2:
                    darkSide.add(new Sniper());
                    break;
                default:
                    darkSide.add(new Monk());
            }
        }

        whiteSide.add(new Arbalester());
        whiteSide.add(new Magician());
        whiteSide.add(new Peasant());
        whiteSide.add(new Sniper());
        whiteSide.add(new Monk());
        whiteSide.add(new Robber());
        whiteSide.add(new Spearman());

        for (int i = 0; i < heroesCount-7; i++) {
            switch (rnd.nextInt(heroesCount-6)){
                case 0:
                    whiteSide.add(new Peasant());
                    break;
                case 1:
                    whiteSide.add(new Robber());
                    break;
                case 2:
                    whiteSide.add(new Sniper());
                    break;
                default:
                    whiteSide.add(new Monk());
            }
        }

        // расстановка сил
        int posX = 0;
        for (BaseHero hero : darkSide) {
            hero.position = new Vector2(posX++, 0);
        }
        posX = 0;
        for (BaseHero hero : whiteSide) {
            hero.position = new Vector2(posX++, heroesCount-1);
        }

        String ss;
        System.out.println("\nInitial alignment of forces");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("\tDark side\t\t\t\t\t\tWhite side");
        for (int i = 0; i < heroesCount; i++) {
                ss = darkSide.get(i).indicateState();
                System.out.print(i + " " + ss); 
                System.out.print(String.valueOf(" ").repeat(50 - ss.length()));
                System.out.println(i + " " + whiteSide.get(i).indicateState());
        }


        int step = 1;
        boolean darkFlag = false, 
                whiteFlag = false,
                swap = true;
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("\nWho moves first?  Enter 'Dark' for darkSide or 'White' for whiteSide");
            String firstMove;
            while (true) {
                firstMove = in.nextLine();
                if (firstMove.equals("Dark")) {swap = false; break;};
                if (firstMove.equals("White")) {swap = true; break;};
            }

            String input = "N";
            while (true) {
                if (input.equals("N")) {
                    System.out.printf("Step: %s\t\t%sSide move\n", Integer.toString(step++), firstMove);
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("\tDark side\t\t\t\t\t\tWhite side");

                    if (swap) { // посменные ходы
                        // ход белых
                        whiteSide.forEach(hero -> hero.step());
                        // ход черных
                        darkSide.forEach(hero -> hero.step());
                        swap = false;
                        firstMove = "Dark";
                    } 
                    else {
                        // ход черных
                        darkSide.forEach(hero -> hero.step());
                        // ход белых
                        whiteSide.forEach(hero -> hero.step());
                        swap = true;
                        firstMove = "White";
                    }

                    for (int i = 0; i < heroesCount; i++) {
                        ss = darkSide.get(i).indicateState();
                        System.out.print(i + " " + ss); 
                        System.out.print(String.valueOf(" ").repeat(50 - ss.length()));
                        System.out.println(i + " " + whiteSide.get(i).indicateState());
                        if (darkSide.get(i).status()) darkFlag = true; 
                        if (whiteSide.get(i).status()) whiteFlag = true;
                    }

                    if (!darkFlag && !whiteFlag) {
                        System.out.println("\n\t\t\t!!!GAME DRAWN  -  NO SIDES!!!\n");
                        return;
                    }
                    if (!darkFlag) {
                        System.out.println("\n\t\t\t!!! W H I T E   W O N !!!\n");
                        return;
                    }
                    if (!whiteFlag) {
                        System.out.println("\n\t\t\t!!! D A R K   W O N !!!\n");
                        return;
                    }  
                }
                if (input.equals("Q")) break;
                
                System.out.println("\nEnter 'N' for next step;  Enter 'Q' for exit");
                input = in.nextLine();
            }
        }

        System.out.println("\n\t\t\tG A M E   O V E R\n");
    }
}
