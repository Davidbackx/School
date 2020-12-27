public abstract class Locatie {
    private String naam;

    public Locatie(String naam){
        this.naam = naam;
    }

    public abstract int getMaxCapaciteit();

    public boolean isGrootGenoeg(int aantalPersonen){
        return this.getMaxCapaciteit() >= aantalPersonen;
    }

    public String toString(){
        return this.getClass().getSimpleName() + " " + this.naam + " " + this.getMaxCapaciteit();
    }

}
