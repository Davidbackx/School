package domain;

import java.time.LocalDate;
import java.time.Period;

public class Persoon {
    private String naam, voornaam;
    private LocalDate geboorteDatum;

    public Persoon(String naam, String voornaam, LocalDate geboorteDatum) {
        setNaam(naam);
        setVoornaam(voornaam);
        setGeboorteDatum(geboorteDatum);
    }

    public int geefLeeftijdOpDag(LocalDate datum) {
        return Period.between(geboorteDatum, datum).getYears();
    }

    private void setNaam (String naam) {
        if (naam == null) throw new DomainException();
        this.naam = naam;
    }

    private void setVoornaam (String voornaam) {
        if (voornaam == null) throw new DomainException();
        this.naam = voornaam;
    }

    private void setGeboorteDatum(LocalDate geboorteDatum) {
        if (geboorteDatum == null) throw new DomainException();
        this.geboorteDatum = geboorteDatum;
    }
}
