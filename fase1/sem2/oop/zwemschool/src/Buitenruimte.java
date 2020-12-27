public class Buitenruimte extends Locatie {
    public static final int MAX_CAPACITEIT = 100;

    public Buitenruimte(String naam){
        super(naam);
    }

    @Override
    public int getMaxCapaciteit() {
        return MAX_CAPACITEIT;
    }

}
