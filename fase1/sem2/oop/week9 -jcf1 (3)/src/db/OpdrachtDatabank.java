package db;

import domain.Opdracht;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpdrachtDatabank {
    private List<Opdracht> opdrachten;

    public OpdrachtDatabank(String fileNaam){
        this.opdrachten = new ArrayList<>();
        File personenFile = new File(fileNaam);
        try {
            Scanner scannerFile = new Scanner(personenFile);
            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] delen = s.split("\\t");
                Opdracht opdracht = new Opdracht(Integer.parseInt(delen[0]),delen[1],delen[2],
                        (delen[3].equals("true")?true:false),
                        delen[4],delen[5],delen[6]);

                this.opdrachten.add(opdracht);
            }
        }  catch (FileNotFoundException ex1) {
            throw new IllegalArgumentException();
        } catch (NumberFormatException ex2){
            throw new IllegalArgumentException();
        }
    }

    public List<Opdracht> getOpdrachten() {
        return this.opdrachten;
    }

    public void voegToe(Opdracht o) {
        if (o == null) throw new IllegalArgumentException();
        if (this.opdrachten.contains(o)) throw new IllegalArgumentException();
        this.opdrachten.add(o);
    }
}
