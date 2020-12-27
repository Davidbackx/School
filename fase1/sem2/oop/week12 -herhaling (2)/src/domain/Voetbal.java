package domain;

public class Voetbal extends Sport implements HeeftMinimumleeftijd {

    private static final int MINIMUM_LEEFTIJD = 5;

    public Voetbal() {
        super("Voetbal");
    }

    @Override
    public int getMinimumLeeftijd() {
        return MINIMUM_LEEFTIJD;
    }
}
