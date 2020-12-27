import java.lang.reflect.Array;
import java.util.ArrayList;

public class Parking {
    private String naam;
    private ParkeerPlaats[] plaatsen;

    public Parking (String naam, int MinEtage, int[] parkeerPlaatsen) {
        if (naam.trim().isEmpty() || naam == null) throw new IllegalArgumentException();
        if (parkeerPlaatsen == null || parkeerPlaatsen.length <= 0) throw new IllegalArgumentException();

        this.naam = naam;

        int Aantal = 0;
        for (int i = 0; i < parkeerPlaatsen.length; i++) {
            Aantal += parkeerPlaatsen[i];
        }
        plaatsen = new ParkeerPlaats[Aantal];

        int index = 0;
        for (int verdiep = 0; verdiep < parkeerPlaatsen.length; verdiep++) {
            for (int plek = 0; plek < parkeerPlaatsen[verdiep]; plek++ ){
                String code = (verdiep + MinEtage) + "*" + (plek + 1);
                plaatsen[index] = new ParkeerPlaats(code);
                index++;
            }
        }
    }

    public Parking (String naam) {
        this(naam, -2, new int[]{50, 50, 50});
    }

    public String geefNaam() {
        return naam;
    }

    public int geefTotaalAantalPlaatsen() {
        return plaatsen.length;
    }

    public int geefMinimumEtage () {
        int minEtage = Integer.MAX_VALUE;
        for (ParkeerPlaats p : plaatsen) {
            int verdiep = p .geefVerdiepingNummer();
            if (verdiep < minEtage) minEtage = verdiep;
        }
        return  minEtage;
    }

    public int geefMaximumEtage () {
        int maxEtage = Integer.MIN_VALUE;
        for (ParkeerPlaats p : plaatsen) {
            int verdiep = p .geefVerdiepingNummer();
            if (verdiep > maxEtage) maxEtage = verdiep;
        }
        return  maxEtage;
    }

    public int geefAantalVrijePlaatsen () {
        int aantal = 0;
        for (ParkeerPlaats p : plaatsen) {
            if (p.beschikbaar()) aantal++;
        }
        return aantal;
    }

    public ParkeerPlaats geefVrijeParkeerPlaats () {
        for (int i = plaatsen.length - 1; i > 0; i--){
            if (plaatsen[i].beschikbaar()) return plaatsen[i];
        }
        return  null;
    }

    // TODO :
    public void zetParkeerPlaatsBezet (int verdiep, int nummer) {
        for (int i = 0; i < plaatsen.length; i ++) {
            if (plaatsen[i].geefVerdiepingNummer()== verdiep) {
                plaatsen[i + nummer - 1].zetBezet();
                return;
            }
        }
    }
    public String geefStringVorm () {
        String uit = naam;
        for (ParkeerPlaats p : plaatsen) {
            uit += "\n" + p.geefStringVorm();
        }
        return uit;
    }
}
