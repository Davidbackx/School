public class Zwembad extends Locatie implements berekenPrijs{
    private int aantalBanen;
    private double prijsVoor1BaanPerUur;
    public static final int AANTAL_PERSONEN_PER_BAAN = 10;

    public Zwembad(String naam, int aantalBanen, double prijsVoor1BaanPerUur){
        super(naam);
        if (aantalBanen < 1) throw new DomainException();
        if (prijsVoor1BaanPerUur < 0.5) throw new DomainException();
        this.aantalBanen = aantalBanen;
        this.prijsVoor1BaanPerUur = prijsVoor1BaanPerUur;
    }


    @Override
    public int getMaxCapaciteit() {
        return this.aantalBanen * AANTAL_PERSONEN_PER_BAAN;
    }

    @Override
    public double getPrijs(int aantalPersonen) {
        if (aantalPersonen < 1) throw new DomainException();
        int aantalNodigeBanen = (aantalPersonen / AANTAL_PERSONEN_PER_BAAN) + 1;
        if (aantalNodigeBanen > aantalBanen) throw new DomainException();
        return aantalNodigeBanen * prijsVoor1BaanPerUur;
    }
}
