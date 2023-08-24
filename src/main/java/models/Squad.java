package models;

import java.util.ArrayList;

public class Squad {
    private static int nextId = 1;
    private int maxSize;
    private String name;
    private  String cause;
    private int id;

    public static ArrayList<Squad> squads = new ArrayList<>();

    private ArrayList<Hero> heroes;

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Squad(int maxSize, String name, String cause) {
        this.maxSize = maxSize;
        this.name = name;
        this.cause = cause;
        id = nextId;
        heroes = new ArrayList<>();
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public int getId() {
        return id;
    }
    public void addHero(Hero hero) {
        if(hero.getSquadId() != -1) {
            throw new IllegalArgumentException("The hero is already in a squad");
        }
        heroes.add(hero);
        hero.setSquadId(id);
    }

}