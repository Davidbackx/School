package domain;

public class Voetbal extends Sport implements HeeftMinimumleeftijd {

    private static final int MIN_LEEFTIJD = 5;

    public Voetbal () {
        super("Voetbal");
    }

    @Override
    public boolean geschikteLeeftijd(Persoon p) {
        return false;
    }

    @Override
    public int getMinLeeftijd () {
        if (!heeftMinLeeftijd()) throw new DomainException();
        else return MIN_LEEFTIJD;
    }
}
