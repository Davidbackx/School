public class Binnenruimte extends Locatie implements berekenPrijs{
    private int maxCapaciteit;
    private double prijsPerUur;

    public Binnenruimte(String naam, int maxCapaciteit, double prijsPerUur){
        super(naam);
        if (maxCapaciteit < 1) throw new DomainException();
        if (prijsPerUur <= 0) throw new DomainException();
        this.maxCapaciteit = maxCapaciteit;
        this.prijsPerUur = prijsPerUur;
    }


    @Override
    public int getMaxCapaciteit() {
        return this.maxCapaciteit;
    }

    @Override
    public double getPrijs(int aantalPersonen) {
        if (aantalPersonen < 1) throw new DomainException();
        return this.prijsPerUur;
    }
}
