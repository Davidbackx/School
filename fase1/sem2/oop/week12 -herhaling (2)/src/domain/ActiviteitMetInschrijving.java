package domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class ActiviteitMetInschrijving extends Activiteit {
    public ArrayList<Persoon> inschrijvingen;

    public ActiviteitMetInschrijving(String naam, LocalDate datum) {
        super(naam, datum);
        this.inschrijvingen = new ArrayList<>();
    }

    public void schrijfIn(Persoon p) {
        if (isBeschikbaarVoorPersoon(p)) {
            inschrijvingen.add(p);
        }
        else throw new DomainException();
    }

    @Override
    public boolean isBeschikbaarVoorPersoon(Persoon persoon) {
        if (persoon == null)
            throw new DomainException("Gegeven persoon is niet effectief");
        if (isIngeschreven(persoon))
            return false;
        if (this instanceof HeeftMinimumleeftijd && persoon.geefLeeftijdOpDag(this.getDatum()) < ((HeeftMinimumleeftijd) this).getMinimumLeeftijd())
            return false;
        return true;
    }

    public boolean isIngeschreven(Persoon persoon) {
        return inschrijvingen.contains(persoon);
    }

    @Override
    public String toString() {
        return super.toString()+"\nAantal deelnemers: "+ inschrijvingen.size();
    }
}
