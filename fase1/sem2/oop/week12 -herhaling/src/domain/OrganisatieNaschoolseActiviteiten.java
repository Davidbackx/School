package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class OrganisatieNaschoolseActiviteiten {
    private List<Activiteit> activiteiten;

    public OrganisatieNaschoolseActiviteiten() {
        this.activiteiten = new ArrayList<>();
    }

    public void voegActiviteitToe(Activiteit activiteit) {
        if (activiteit == null) throw new DomainException();
        if (!activiteiten.contains(activiteit))
            activiteiten.add(activiteit);
    }

    public void schrijfIn(Persoon persoon, Activiteit activiteit) {
        if (activiteit == null || persoon == null) throw new DomainException();
        activiteiten.add(activiteit);
    }

    public List<Wedstrijd> geefWedstrijden() {
        List<Wedstrijd> w = new ArrayList<>();
        for (int i = 0; i < activiteiten.size(); i++) {
            if (activiteiten.get(i) instanceof Wedstrijd){
                w.add((Wedstrijd) activiteiten.get(i));
            }
        }
        return w;
    }

    public List<Activiteit> geefActiviteitenVoorPersoonOpDag(Persoon persoon, LocalDate dag) {
        List<Activiteit> w = new ArrayList<>();
        for (int i = 0; i < activiteiten.size(); i++) {
            if (activiteiten.get(i).getDatum().equals(dag)) {
                if (activiteiten.get(i) instanceof Wedstrijd) {
                    Wedstrijd wed = (Wedstrijd) activiteiten.get(i);
                    if (wed.geschikteLeeftijd(persoon)){
                        w.add(activiteiten.get(i));
                    }
                }
            }
        }
        return w;
    }

    public List<Activiteit> verwijderActiviteitenOpDatum(LocalDate datum) {
        Iterator<Activiteit> activiteitIterator = activiteiten.iterator();

        while (activiteitIterator.hasNext()) {
            Activiteit a = activiteitIterator.next();
            if (a.getDatum().equals(datum)) {
                activiteitIterator.remove();
            }
        }
        return activiteiten;
    }

    public int geefAantalGeregistreerdeActiviteiten(){
        return activiteiten.size();
    }

    public String geefAantalActiviteiten() {
        return Integer.toString(geefAantalGeregistreerdeActiviteiten());
    }
}
