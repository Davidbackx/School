import java.time.LocalDate;
import java.util.ArrayList;

public class Zwemschool {
    private ArrayList<Niveaugroep> niveaugroepen;
    private ArrayList<Kandidaat> kandidaten;
    private ArrayList<Locatie> locaties;

    public Zwemschool () {
        niveaugroepen = new ArrayList<>();
        kandidaten = new ArrayList<>();
        this.locaties = new ArrayList<>();
    }

    public ArrayList<String> getGeschiktegroepenVoorLeeftijd (int leeftijd) {
        ArrayList<String> result = new ArrayList<>();
        for (Niveaugroep n : niveaugroepen) {
            if (n.geschiktVoorLeeftijd(leeftijd)) result.add(n.getNaam());
        }
        return result;
    }

    public void newNiveaugroep (String naam) {
        Niveaugroep groep = new Niveaugroep(naam);
        if (!niveaugroepen.contains(groep)) niveaugroepen.add(groep);
        else throw new DomainException("Groep bestaat al");
    }

    public void newNiveaugroep (String naam, int minLeeftijd) {
        NiveaugroepMetMinLeeftijd groep = new NiveaugroepMetMinLeeftijd(naam, minLeeftijd);
        if (!niveaugroepen.contains(groep)) niveaugroepen.add(groep);
        else throw new DomainException("Groep bestaat al");
    }

    public void newKandidaat (String naam, LocalDate gebDatum) {
            kandidaten.add(new Kandidaat(naam, gebDatum));
    }

    public void newKandidaat (Kandidaat k) {
        kandidaten.add(k);
    }

    public void addKandidaatToNiveaugroep (String naam, Kandidaat k) {
        for (Niveaugroep n : niveaugroepen){
            if (n.getNaam().equals(naam))  {
                n.addKandidaat(k);
                kandidaten.remove(k);
                k.setInNiveaugroep(true);
            }
        }
    }

    public void print () {
        System.out.println("Groepen:");
        for (Niveaugroep n : niveaugroepen){
            System.out.println(n.getNaam() + "\n-----------------");
            System.out.println("Kandidaten:");
            n.print();
            System.out.println("\n-----------------");
        }
        System.out.println("Kandidaten in zwemschool:");
        for (Kandidaat n : kandidaten){
            System.out.println(n.getNaam());
        }
    }

    public int aantalKandidaten() {
        return kandidaten.size();
    }

    public Kandidaat volgendeKandidaat(String naamGroep){
        for (Niveaugroep g: this.niveaugroepen) {
            if (g.getNaam().equals(naamGroep)) return g.getEersteKandidaat();
        }
        return null;
    }

    public void voegLocatieToe(Locatie locatie){
        if (locatie == null) throw new DomainException();
        this.locaties.add(locatie);
    }

    public Locatie geefLocatie(int aantalPersonen, double budget){
        ArrayList<Locatie> mogelijkeLocaties = new ArrayList<>();
        for (Locatie l: this.locaties){
            if (l.isGrootGenoeg(aantalPersonen)){
                if (l instanceof berekenPrijs){
                    if (((berekenPrijs)l).getPrijs(aantalPersonen) <= budget){
                        mogelijkeLocaties.add(l);
                    }
                } else mogelijkeLocaties.add(l);
            }
        }

        if (mogelijkeLocaties.size() == 0) return null;
        else {
            Locatie res = mogelijkeLocaties.get(0);
            for (int i = 0; i < mogelijkeLocaties.size();i++){
                if (mogelijkeLocaties.get(i).getMaxCapaciteit() > res.getMaxCapaciteit()){
                    res = mogelijkeLocaties.get(i);
                }
            }

            return res;
        }
    }
}
