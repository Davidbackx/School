package domain;

import javax.management.ObjectName;
import java.util.ArrayList;

public class GamesDB {
    private ArrayList<Game> games = new ArrayList<>();

    public GamesDB () {
        addGame(new Game("Obsidian", "Fallout: NV", "RPG", 20d));
        addGame(new Game("CD Project Red", "Witcher 3: Wild Hunt", "RPG", 30d));
        addGame(new Game("CD Project Red", "Cyberpunk 2077", "RPG", 60d));
        addGame(new Game("Assembly", "Total War: Warhammer II", "Strategy", 60d));
        addGame(new Game("Ludeon Studios", "RimWorld", "Colony Sim", 30d));
    }

    public void addGame (Game g) {
        if (g == null) throw new IllegalArgumentException();
        games.add(g);
    }

    public String duursteGame () {
        Game duurste = null;
        for (Game g : games) {
            if (duurste == null || g.getPrijs() > duurste.getPrijs()){
                duurste = g;
            }
        }
        return duurste.getNaam();
    }

    public ArrayList<Game> GetDatabase () {
        return games;
    }

    public void remove(String developer, String naam) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getNaam().equals(naam) && games.get(i).getDeveloper().equals(developer)){
                System.out.println("Verwijderd - " + developer + " " + naam);
                games.remove(games.get(i));
                return;
            }

        }
    }

    public ArrayList<Game> GetGamesOfDev(String developer) {
        ArrayList<Game> gm = new ArrayList<>();
        for (Game g : games) {
            if (g.getDeveloper().equals(developer)){
                System.out.println(g.getNaam());
                gm.add(g);
            }
        }
        System.out.println(gm);
        return gm;
    }
}
