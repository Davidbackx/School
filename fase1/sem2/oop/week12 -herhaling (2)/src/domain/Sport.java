package domain;

public abstract class Sport {
    private String naam;


    protected Sport(String naam) {
        setNaam(naam);
    }

    public void setNaam(String naam) {
        if (naam == null || naam.trim().isEmpty()) throw new DomainException();
        this.naam = naam;
    }

    @Override
    public String toString() {
        return naam;
    }

}
