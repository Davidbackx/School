package db;

import domain.Opdracht;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class OpdrachtDatabank {

    private ArrayList opdrachten;

    public OpdrachtDatabank (String fileName) {
        this.opdrachten = new ArrayList<>();
        File opfile = new File(fileName);
        try {
            Scanner scannerFile = new Scanner(opfile);
            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] delen = s.split("\\t");
                Opdracht opdracht = new Opdracht(Integer.parseInt(delen[0]), delen[1], delen[2], Boolean.parseBoolean(delen[3]), delen[4], delen[5], delen[6]);
                this.opdrachten.add(opdracht);
            }
        }
        catch (FileNotFoundException ex1) {
            throw new IllegalArgumentException();
        } catch (NumberFormatException ex2){
            throw new IllegalArgumentException();
        }
    }

    public ArrayList<Opdracht> getOpdrachten () {
        return this.opdrachten;
    }

    public void voegToe (Opdracht opdracht) {
        if (opdracht == null) throw new IllegalArgumentException();
        opdrachten.add(opdracht);
    }

    public ArrayList<Opdracht> getOpdrachtenGesorteerdOpCategorie () {
        ArrayList<Opdracht> n =  (ArrayList<Opdracht>) opdrachten.clone();
        n.sort(new ComparatorByCategorie());
        return n;
    }
}
