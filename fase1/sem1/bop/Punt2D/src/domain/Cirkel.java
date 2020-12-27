package domain;

import java.awt.*;

public class Cirkel {
    private Punt2D middelpunt;
    private Color kleur;
    private int straal;

    public  Cirkel () {
        this(Color.black, new Punt2D(1,1), 1);
    }


    public Cirkel (Color kleur, Punt2D middelpunt, int straal) {
        setMiddelpunt(middelpunt);
        setKleur(kleur);
        setStraal(straal);
    }

    public int getStraal() {
        return straal;
    }

    public Color getKleur() {
        return kleur;
    }

    public Punt2D getMiddelPunt() {
        return middelpunt;
    }

    public void setMiddelpunt(Punt2D middelpunt) {
        if(middelpunt == null){
            throw new IllegalArgumentException("Mag niet leeg zijn");
        } else {
            this.middelpunt = middelpunt;
        }
    }

    public void setKleur(Color kleur) {
        if(kleur == null){
            throw new IllegalArgumentException("Mag niet leeg zijn");
        } else {
            this.kleur = kleur;
        }
    }

    public void setStraal(int straal) {
        if(straal <= 0 || straal > 100){
            throw new IllegalArgumentException("Mag niet leeg zijn");
        } else {
            this.straal = straal;
        }
    }

    public void veranderKleur (Color kleur) {
        if(kleur == null){
            throw new IllegalArgumentException("Mag niet leeg zijn");
        } else {
            this.kleur = kleur;
        }
    }

    public boolean bevatPunt(Punt2D p){
        if(p == null){
            throw new IllegalArgumentException("Mag niet leeg zijn");
        } else {
            if(p.berekenAfstandTot(middelpunt) <= straal){
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean overlapt(Cirkel c){
        if(c == null){
            throw new IllegalArgumentException("Mag niet leeg zijn");
        } else {
            if(c.middelpunt.berekenAfstandTot(this.middelpunt) < straal){
                return true;
            } else {
                return false;
            }
        }
    }

    public void verdubbel () {
        straal *= 2;
    }

    public void halveer () {
        straal /= 2;
    }

    public void move (int x, int y) {
        middelpunt.moveHorizontaal(x);
        middelpunt.moveVerticaal(y);
    }

    public String format () {
        return "cirkel met middelpunt " + middelpunt.format() + " en straal " + straal;
    }

}
