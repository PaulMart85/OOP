package Seminar2_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        Map<String, List<BaseHero>> mapOfHeroes= new HashMap<>();
        Set<String> roles = new HashSet<>();
        roles.add("Peasant");
        roles.add("Robber");
        roles.add("Sniper");
        roles.add("Magician");
        roles.add("Spearman");
        roles.add("Arbalester");
        roles.add("Monk");

        for (String role : roles) {
            mapOfHeroes.put(role, new ArrayList<>());
        }
        for (int i = 0; i < 5; i++) {
            mapOfHeroes.get("Peasant").add(new Peasant());
            mapOfHeroes.get("Robber").add(new Robber());
            mapOfHeroes.get("Sniper").add(new Sniper());
            mapOfHeroes.get("Magician").add(new Magician());
            mapOfHeroes.get("Spearman").add(new Spearman());
            mapOfHeroes.get("Arbalester").add(new Arbalester());
            mapOfHeroes.get("Monk").add(new Monk());       
        }

        for (List<BaseHero> list : mapOfHeroes.values()) {
            System.out.println();
            for (BaseHero hero : list) 
                System.out.println(hero.getInfo());
        }

    }
}
