package domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class ActiviteitMetInschrijving extends Activiteit {

    public ArrayList<Persoon> inschrijvingen;

    public ActiviteitMetInschrijving(String naam, LocalDate datum) {
        super(naam, datum);
        inschrijvingen = new ArrayList<>();
    }

    public void schrijfIn(Persoon p) {
        if (p == null) throw new DomainException();
        inschrijvingen.add(p);
    }
}
