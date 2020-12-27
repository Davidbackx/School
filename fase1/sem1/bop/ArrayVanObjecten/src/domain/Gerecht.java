package domain;

public class Gerecht {
    private String naam;
    private boolean isVeggie;
    private int calorieen;

    public Gerecht(String naam, boolean isVeggie, int calorieen) {
        if (naam == null || naam.trim().isEmpty()) throw new IllegalArgumentException();
        this.naam = naam;
        this.isVeggie = isVeggie;
        setCalorieen(calorieen);
    }

    public Gerecht(String naam) {
        this(naam, false, 0);
    }

    public int getCalorieen() {
        return calorieen;
    }

    public void setCalorieen(int calorieen) {
        if (calorieen < 0) throw new IllegalArgumentException();
        this.calorieen = calorieen;
    }

    public boolean isVeggie() {
        return isVeggie;
    }

    @Override
    public String toString() {
        return naam + (isVeggie ? " is een vegetarisch gerect " : " is geen vegetarisch gerecht ") + "en bevat " + calorieen + ".";
    }
}
