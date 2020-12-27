package domain;

import java.time.LocalDate;

public class Dropping extends  ActiviteitMetInschrijving implements HeeftMinimumleeftijd {
    private String startplaats;
    private static final int MINIMUM_LEEFTIJD = 10;

    public Dropping(String naam, LocalDate datum, String startplaats) {
        super(naam, datum);
        setStartplaats(startplaats);
    }

    private void setStartplaats(String startplaats) {
        if (startplaats == null || startplaats.trim().isEmpty()) throw new DomainException();
        this.startplaats = startplaats;
    }

    @Override
    public int getMinimumLeeftijd() {
        return MINIMUM_LEEFTIJD;
    }
}
