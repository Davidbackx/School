package domain;

import Exceptions.InputException;

public class Game {
    private String developer, naam, soort;
    private double prijs;

    public Game(String developer, String naam, String soort, double prijs) {
        setDeveloper(developer);
        setNaam(naam);
        setSoort(soort);
        setPrijs(prijs);
    }

    public Game () {

    }

    public void setPrijs(double prijs) {
        if (prijs <= 0) throw new InputException("Prijs");
        this.prijs = prijs;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setDeveloper(String developer) {
        if (developer.trim().isEmpty() || developer == null) throw new InputException("Developer");
        this.developer = developer;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setSoort(String soort) {
        if (soort.trim().isEmpty() || soort == null) throw new InputException("Soort");
        this.soort = soort;
    }

    public String getSoort() {
        return soort;
    }

    public void setNaam(String naam) {
        if (naam.trim().isEmpty() || naam == null) throw new InputException("Naam");
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }
}
