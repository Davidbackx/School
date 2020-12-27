package domain;

import java.time.LocalDate;

public class Activiteit {
    private String naam;
    private LocalDate datum;

    public Activiteit(String naam, LocalDate datum) {
       setNaam(naam);
       setDatum(datum);
    }

    private void setNaam (String naam) {
        if (naam == null) throw new DomainException();
        this.naam = naam;
    }

    private void setDatum(LocalDate datum) {
        if (datum == null) throw new DomainException();
        this.datum = datum;
    }

    public String getNaam() {
        return naam;
    }

    public LocalDate getDatum() {
        return datum;
    }
}
