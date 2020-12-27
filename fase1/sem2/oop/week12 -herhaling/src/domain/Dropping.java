package domain;

import java.time.LocalDate;

public class Dropping extends ActiviteitMetInschrijving implements HeeftMinimumleeftijd {

    private String startplaats;
    private static final int MIN_LEEFTIJD = 10;

    public Dropping(String naam, LocalDate datum, String startplaats) {
        super(naam, datum);
        setStartplaats(startplaats);
    }

    private void setStartplaats(String startplaats) {
        if (startplaats == null) throw new DomainException();
        this.startplaats = startplaats;
    }


    @Override
    public boolean geschikteLeeftijd(Persoon p) {
        if (p == null) throw new DomainException();
        return p.geefLeeftijdOpDag(getDatum()) > MIN_LEEFTIJD;
    }
}
