package domain;

import java.time.LocalDate;

public class Wedstrijd extends ActiviteitMetInschrijving implements HeeftMinimumleeftijd {
    private Sport sport;

    public Wedstrijd(String naam, LocalDate datum, Sport sport) {
        super(naam, datum);
        setSport(sport);
    }

    public void setSport(Sport sport) {
        if (sport == null) throw new DomainException();
        this.sport = sport;
    }

    @Override
    public void schrijfIn(Persoon p) {
        if (sport.heeftMinLeeftijd()){
            if (p.geefLeeftijdOpDag(getDatum()) <= sport.getMinLeeftijd()) {
                throw new DomainException();
            }
        }
        super.schrijfIn(p);
    }

    @Override
    public boolean geschikteLeeftijd(Persoon p) {
        return false;
    }
}
