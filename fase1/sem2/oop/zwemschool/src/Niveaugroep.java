import java.util.ArrayList;

public class Niveaugroep {

    private String naam;
    private ArrayList<Kandidaat> kandidaten;
    public static final int MINIMUM_LEEFTIJD = 10;

    public Niveaugroep(String naam) {
        if (naam == null) throw new DomainException("Naam is null");
        this.naam = naam;
        kandidaten = new ArrayList<>();
    }

    public Kandidaat getEersteKandidaat () {
        return kandidaten.size() == 0 ? null : kandidaten.get(0);
    }

    public String getNaam() {
        return naam;
    }

    public boolean geschiktVoorLeeftijd (int leeftijd) {
        return leeftijd >= MINIMUM_LEEFTIJD;
    }

    public void addKandidaat (Kandidaat k) {
        if (k == null) throw new DomainException();
        kandidaten.add(k);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Niveaugroep groep = (Niveaugroep) o;
        return naam.equals(groep.naam);
    }

    public void print () {
        for (Kandidaat k : kandidaten) {
            System.out.println(k.getNaam());
        }
    }
}
