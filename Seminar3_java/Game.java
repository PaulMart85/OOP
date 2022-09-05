package Seminar3_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        
        List<BaseHero> darkSide = new ArrayList<>();
        List<BaseHero> whiteSide = new ArrayList<>();

        darkSide.add(new Peasant());
        darkSide.add(new Robber());
        darkSide.add(new Sniper());

        Random rnd = new Random();
        for (int i = 0; i < 5; i++) {
            switch (rnd.nextInt(4)){
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
                    darkSide.add(new Magician());
            }
        }

        whiteSide.add(new Monk());
        whiteSide.add(new Arbalester());
        whiteSide.add(new Spearman());

        for (int i = 0; i < 5; i++) {
            switch (rnd.nextInt(4)){
                case 0:
                    whiteSide.add(new Monk());
                    break;
                case 1:
                    whiteSide.add(new Arbalester());
                    break;
                case 2:
                    whiteSide.add(new Spearman());
                    break;
                default:
                    whiteSide.add(new Magician());
            }
        }
        

        System.out.println("First step");
        System.out.println("--------------------------------------------");
        System.out.println("Dark side\t\t\t\t\t\t\tWhite side");
        for (int i = 0; i < darkSide.size(); i++) {
            if (darkSide.get(i).indicateState().length() > 32) {
                System.out.println(darkSide.get(i).indicateState() + "\t:\t" + whiteSide.get(i).indicateState());
            } else {
                System.out.println(darkSide.get(i).indicateState() + "\t\t:\t" + whiteSide.get(i).indicateState());
            }
        }

        System.out.println("Enter 'N' for next step;  Enter 'Q' for exit");

        int step = 2, i;
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                String input = in.nextLine();
                if (input.equals("N")) {
                    System.out.println("Step: " + Integer.toString(step++));
                    System.out.println("--------------------------------------------");
                    System.out.println("Dark side\t\t\t\t\t\t\tWhite side");
                    for (BaseHero hero : whiteSide) {
                        hero.step(whiteSide);
                    }
                    for (BaseHero hero : darkSide) {
                        hero.step(darkSide);
                    }
                    for (i = 0; i < darkSide.size(); i++) {
                        if (darkSide.get(i).indicateState().length() > 32) {
                            System.out.println(darkSide.get(i).indicateState() + "\t:\t" + whiteSide.get(i).indicateState());
                        } else {
                            System.out.println(darkSide.get(i).indicateState() + "\t\t:\t" + whiteSide.get(i).indicateState());
                        }
                    }
                }
                if (input.equals("Q")) break;
            }
        }

        // маг лечит одного случайного героя из своего лагея, в том числе и себя

        System.out.println("G A M E   O V E R");
    }
}
