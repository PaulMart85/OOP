package Seminar5_java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.fusesource.jansi.AnsiConsole;

public class Game { // реализация однопоточная

    protected static final int heroesCount;  // количество игроков в команде

    protected static final List<BaseHero> blueSide; // команда синих
    protected static final List<BaseHero> redSide; // команда красных

    protected static int step; // текущий шаг игры
    protected static WhsMv whoseMove; // чей сейчас ход
    protected static boolean blueFlag, redFlag; // знамёна команд
    protected static final ColoredNumber[][] battleField; // поле брани

    static {
        heroesCount = 10;
        blueSide = new ArrayList<>(heroesCount);
        redSide = new ArrayList<>(heroesCount);
        step = 0;
        whoseMove = WhsMv.BLUE_SIDE;
        blueFlag = true;
        redFlag = true;
        battleField = new ColoredNumber[heroesCount][heroesCount];
    }

    static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        AnsiConsole.systemInstall(); // для работы с цветом текста консоли (архив jansi.jar: org.fusesource.jansi)

        sidesInit();  
        forcesAlignment();
        view(step);
        toss();
                
        try (in) {
            String input = "N";

            while (true) {

                if (input.equals("N")) {

                    makeAMove();    
                    view(++step);
                    if (verify()) return;

                }

                if (input.equals("Q")) break;
                
                System.out.println("\nEnter 'N' for next step;  Enter 'Q' for exit");
                input = in.nextLine();

            }
        }

        System.out.println("\n\t\tG A M E   O V E R\n");
    }
    
    
    /**
     * Наполнение команд. Для равенства сил в каждой команде обязательно 
     * присутствуют по одному все герою, а также случайным образом 
     * команда добирается до нужного количества героев, число которых задается heroesCount.
     * 
     */
    private static void sidesInit() {
        
        blueSide.add(new Peasant());
        blueSide.add(new Arbalester());
        blueSide.add(new Magician());
        blueSide.add(new Monk());
        blueSide.add(new Spearman());
        blueSide.add(new Robber());
        blueSide.add(new Sniper());

        Random rnd = new Random();
        for (int i = 0; i < heroesCount-7; i++)
            switch (rnd.nextInt(heroesCount-6)){
                case 0:
                    blueSide.add(new Peasant());
                    break;
                case 1:
                    blueSide.add(new Robber());
                    break;
                case 2:
                    blueSide.add(new Sniper());
                    break;
                default:
                    blueSide.add(new Monk());
            }

        redSide.add(new Arbalester());
        redSide.add(new Magician());
        redSide.add(new Peasant());
        redSide.add(new Sniper());
        redSide.add(new Monk());
        redSide.add(new Robber());
        redSide.add(new Spearman());

        for (int i = 0; i < heroesCount-7; i++)
            switch (rnd.nextInt(heroesCount-6)){
                case 0:
                    redSide.add(new Peasant());
                    break;
                case 1:
                    redSide.add(new Robber());
                    break;
                case 2:
                    redSide.add(new Sniper());
                    break;
                default:
                    redSide.add(new Monk());
            }

    }

    /**
     * Расстановка сил на поле битвы. Размер поля [heroesCount х heroesCount].
     * Команды располагаются на крайних левой и правой сторонах поля.
     */
    private static void forcesAlignment() {

        int posX = 0;
        for (BaseHero hero : blueSide) {
            hero.position = new Coordinates(posX, 0);
            battleField[posX][0] = new ColoredNumber(posX++ +1, 'b');
        }
        posX = 0;
        for (BaseHero hero : redSide) {
            hero.position = new Coordinates(posX, heroesCount-1);
            battleField[posX][heroesCount-1] = new ColoredNumber(posX++ +1, 'r');
        }

    }

    /**
     * Обзор текущего состояния игры, которое задается шагом step.
     * @param step - текущий шаг игры.
     */
    private static void view(int step) {

        String sb, sr;
        final int[] tmp = {0, 0};

        blueFlag = false; 
        redFlag = false;

        if (step == 0) System.out.println("\nInitial alignment of forces");
        else System.out.printf("Step: %s    %s move\n", Integer.toString(step), whoseMove.getWhsMv());
        
        blueSide.forEach(hero -> tmp[0] = Math.max( tmp[0], hero.indicateState().length() )); 
        redSide.forEach(hero -> tmp[1] = Math.max( tmp[1], hero.indicateState().length() )); 
        
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.print("\tBlue side" + String.valueOf(" ").repeat(tmp[0]+1) + "Red side");
        System.out.println(String.valueOf(" ").repeat(tmp[1]-16) + String.valueOf("*").repeat(heroesCount*3 + 1));
        for (int i = 0; i < heroesCount; i++) {
            sb = blueSide.get(i).indicateState();
            sr = redSide.get(i).indicateState();
            System.out.print((i+1) + " " + sb); 
            System.out.print(String.valueOf(" ").repeat( tmp[0]+4 - sb.length() - String.valueOf(i+1).length() ));
            System.out.print((i+1) + " " + sr);
            System.out.print(String.valueOf(" ").repeat( tmp[1]+4 - sr.length() - String.valueOf(i+1).length() ));
            System.out.print("|");
            for (int j = 0; j < heroesCount; j++) 
                System.out.print(getCell(battleField[i][j]) + "|");
            System.out.println();
            System.out.println(String.valueOf(" ").repeat(tmp[0]+tmp[1]+10) + String.valueOf("*").repeat(heroesCount*3 + 1));

            if (blueSide.get(i).status()) blueFlag = true; 
            if (redSide.get(i).status()) redFlag = true;
        }

        if (whoseMove.equals(WhsMv.RED_SIDE)) whoseMove = WhsMv.BLUE_SIDE;
        else whoseMove = WhsMv.RED_SIDE;

    }

    /**
     * Жеребьевка первого хода.
     */ 
    private static void toss() {

            System.out.println("\nWHO MOVES FIRST?  Enter 'B' for blueSide or 'R' for redSide...");
            String firstMove;
            while (true) {
                firstMove = in.nextLine();
                if (firstMove.equals("B")) {whoseMove = WhsMv.BLUE_SIDE; break;}
                if (firstMove.equals("R")) {whoseMove = WhsMv.RED_SIDE; break;}
            }        

    }

    /**
     * Выполнение хода одной из команд. 
     * Организована поочередная последовательность ходов.
     */
    private static void makeAMove() {

        if (whoseMove.equals(WhsMv.RED_SIDE))
            redSide.forEach(BaseHero :: step);
        else
            blueSide.forEach(BaseHero :: step);
            
    }

    /**
     * Проверка возможности продолжения игры.
     * @return true - игра окончена с одним из результатов.
     */
    private static boolean verify() {

        if (!blueFlag && !redFlag) { // в обеих лагерях все мертвы - НИЧЬЯ
            System.out.println("\n\t\t\t!!!GAME DRAWN  -  NO SIDES!!!\n");
            return true;
        }

        if (!blueFlag) { // в лагере синих все мертвы - ПОБЕДА КРАСНЫХ
            System.out.println("\n\t\t\t!!! R E D   W O N !!!\n");
            return true;
        }

        if (!redFlag) { // в лагере красных все мертвы - ПОБЕДА СИНИХ
            System.out.println("\n\t\t\t!!! B L U E   W O N !!!\n");
            return true;
        }

        blueFlag = false;
        redFlag = false;
        // если в лагере остались только эти герои, то лагерь воевать не сможет
        Set<String> roles = new HashSet<>( Arrays.asList(  
                    "Robber",
                    "Monk",
                    "Magician"
                                ));
                        
        for (BaseHero hero : blueSide) {
            if (!roles.contains(hero.getClass().getSimpleName())) {
                blueFlag = true;
                break;
            }
        }
        for (BaseHero hero : redSide) {
            if (!roles.contains(hero.getClass().getSimpleName())) {
                redFlag = true;
                break;
            }
        }

        if (!blueFlag && !redFlag) { // в обеих лагерях остались герои, которые не могут убивать - НИЧЬЯ
            System.out.println("\n\t\t\t!!!GAME DRAWN  -  NO SIDES!!!\n");
            return true;
        }

        return false;

    }

    /**
     * Заполнение ячейки поля.
     * @param cn ColoredNumber(int, char) номер и цвет ячейки
     * @return String, который заполнит ячейку поля заданным числом и разукрасит его в заданный цвет
     */
    private static String getCell(ColoredNumber cn) {

        if (cn == null) return "  ";

        String out = (cn.color=='b' ? AnsiColors.ANSI_BLUE : AnsiColors.ANSI_RED) + String.valueOf(cn.number) + AnsiColors.ANSI_RESET;
        return (int)cn.number/10 == 0 ? " " + out : out;

    }
}

