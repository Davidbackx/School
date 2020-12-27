package domain;

public abstract class Sport {

    private String naam;

    public Sport(String naam) {
        setNaam(naam);
    }

    public boolean heeftMinLeeftijd () {
        return false;
    }

    public int getMinLeeftijd () {
        if (!heeftMinLeeftijd()) throw new DomainException();
        else return 0;
    }

    private void setNaam(String naam) {
        if (naam == null) throw new DomainException();
        this.naam = naam;
    }
}
