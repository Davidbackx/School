package domain;

import java.time.LocalDate;
import java.time.Period;

public class Persoon {
    private String naam, voornaam;
    private LocalDate geboorteDatum;

    public Persoon(String naam, String voornaam, LocalDate geboorteDatum) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.geboorteDatum = geboorteDatum;
    }

    public int geefLeeftijdOpDag(LocalDate datum) {
        return Period.between(geboorteDatum, datum).getYears();
    }
}
