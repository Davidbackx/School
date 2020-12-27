public class NiveaugroepMetMinLeeftijd extends Niveaugroep {
    private int minLeeftijd;
    public static final int MINIMUM_LEEFTIJD = 5;

    public NiveaugroepMetMinLeeftijd(String naam, int minLeeftijd) {
        super(naam);
        if (minLeeftijd < NiveaugroepMetMinLeeftijd.MINIMUM_LEEFTIJD) throw new DomainException();
        this.minLeeftijd = minLeeftijd;
    }

    @Override
    public boolean geschiktVoorLeeftijd(int leeftijd) {
        return leeftijd >= minLeeftijd;
    }
}