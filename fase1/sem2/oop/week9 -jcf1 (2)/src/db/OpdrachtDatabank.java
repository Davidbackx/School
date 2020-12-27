package db;

import domain.Opdracht;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OpdrachtDatabank {
    ArrayList<Opdracht> opdrachten;

    public OpdrachtDatabank(String filename) {
        opdrachten = new ArrayList<>();
        File file = new File(filename);
        TextToDatebase(file);
    }

    public void TextToDatebase (File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\\t");
                Opdracht opdracht = new Opdracht(Integer.parseInt(line[0]), line[1], line[2], Boolean.parseBoolean(line[3]), line[4], line[5], line[6]);
                voegToe(opdracht);
            }
        }
        catch (FileNotFoundException ex1) {
            throw new IllegalArgumentException();
        } catch (NumberFormatException ex2){
            throw new IllegalArgumentException();
        }
    }

    public ArrayList<Opdracht> getOpdrachten() {
        return opdrachten;
    }

    public void voegToe(Opdracht opdracht) {
        if (opdracht == null || opdrachten.contains(opdracht)) {
            throw new IllegalArgumentException();
        }
        opdrachten.add(opdracht);
    }

    public ArrayList<Opdracht> getOpdrachtenGesorteerdOpCategorie() {
        opdrachten.sort(new ComparatorByCategory());
        return opdrachten;
    }

    public ArrayList<Opdracht> getOpdrachtenGesorteerdOpCategorieEnId() {
        opdrachten.sort(new ComparatorByCategoryAndId());
        return opdrachten;
    }

    public ArrayList<Opdracht> getOpdrachtenGesorteerdOpId() {
        opdrachten.sort(new ComparatorById());
        return opdrachten;
    }
}
