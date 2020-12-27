package domain;

import java.lang.reflect.Array;
import java.net.http.WebSocket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrganisatieNaschoolseActiviteiten {
    private List<Activiteit> activiteiten;

    public OrganisatieNaschoolseActiviteiten() {
        this.activiteiten = new ArrayList<>();
    }

    public void voegActiviteitToe(Activiteit activiteit) {
        if (activiteit == null)
            throw new DomainException("Je probeert een niet-effectieve activiteit te registreren");
        if (activiteiten.contains(activiteit))
            throw new DomainException("Deze activiteit is al geregistreerd");
        activiteiten.add(activiteit);
    }

    public void schrijfIn(Persoon persoon, Activiteit activiteit) {
        if (!activiteiten.contains(activiteit))
            throw new DomainException("Gevraagde activiteit bestaat niet");
        if (activiteit instanceof ActiviteitMetInschrijving) {
            try {
                ((ActiviteitMetInschrijving) activiteit).schrijfIn(persoon);
            } catch (DomainException e) {
                throw new DomainException("Error");
            }
        }

    }

    public List<Wedstrijd> geefWedstrijden() {
        List<Wedstrijd> result = new ArrayList<>();
        for (int i = 0; i < activiteiten.size(); i++) {
            if (activiteiten.get(i) instanceof Wedstrijd) {
                result.add((Wedstrijd) activiteiten.get(i));
            }
        }
        return result;
    }

    public List<Activiteit> geefActiviteitenVoorPersoonOpDag(Persoon persoon, LocalDate dag) {
        List<Activiteit> result = new ArrayList<>();
        for (Activiteit a : activiteiten) {
            if (a.isBeschikbaarVoorPersoon(persoon) && a.getDatum().equals(dag)) {
                result.add(a);
            }
        }
        return result;
    }

    public List<Activiteit> verwijderActiviteitenOpDatum(LocalDate datum) {
        List<Activiteit> result = new ArrayList<>();
        Iterator it =  activiteiten.iterator();
        while (it.hasNext()) {
            Activiteit a = (Activiteit) it.next();
            if (a.getDatum().equals(datum)){
                result.add(a);
                it.remove();
            }
        }
        return  result;
    }

    public int geefAantalGeregistreerdeActiviteiten(){
        return activiteiten.size();
    }

}
