package domain;

import java.util.ArrayList;

public class Garage {
    private String naam;
    private ArrayList<Auto> autos;

    public Garage (String naam) {
        setNaam(naam);
        autos = new ArrayList<>();
    }

    public void setNaam(String naam) {
        if (naam.trim().isEmpty() || naam == null) throw new IllegalArgumentException();
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void voegAutoToe (Auto auto) {
        if (auto == null) throw new IllegalArgumentException();
        autos.add(auto);
    }
}
