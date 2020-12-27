package domain;

import java.awt.*;

public class Auto {
    static String[] kleuren = { "zwart", "wit", "rood", "zilver", "blauw" };
    static String[] typeAuto = { "BMW", "Audi", "Mercedes"};

    private String type;
    private String kleur;
    private double prijs;

    public Auto (String type, String kleur, double prijs) {
        if (type == null || kleur == null) throw new IllegalArgumentException();
        boolean correctType = false;
        for (String t : typeAuto) {
            if (t == type) correctType = true;
        }
        if (!correctType) throw new IllegalArgumentException();
        boolean correctKleur = false;
        for (String k : kleuren) {
            if (k == kleur) correctKleur = true;
        }
        if (!correctKleur) throw new IllegalArgumentException();

        setKleur(kleur);
        setPrijs(prijs);
        this.type = type;
    }

    public void setKleur(String kleur) {
        if (kleur == null) throw new IllegalArgumentException();
        this.kleur = kleur;
    }

    public void setPrijs(double prijs) {
        if (prijs < 250000D) throw new IllegalArgumentException();
        this.prijs = prijs;
    }


}
