package domain;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Gerecht> gerechten;

    public Menu () {
        gerechten = new ArrayList<>();
    }

    public void addGerecht (Gerecht g) {
        if (g == null) throw new IllegalArgumentException();
        gerechten.add(g);
    }

    public int aantalCalorieen () {
        int aantal = 0;
        for (Gerecht g : gerechten) {
            aantal += g.getCalorieen();
        }
        return aantal;
    }

    public boolean isVeggie () {
        for (Gerecht g : gerechten) {
            if (!g.isVeggie()) return  false;
         }
        return true;
    }

    @Override
    public String toString() {
        String uit = "Deze menu bestaat uit volgende gerechten:\n";
        for (Gerecht g : gerechten) {
            if (g != null)
                uit += g.toString() + "\n";
        }
        uit+= "\n" + (this.isVeggie()? " dit is een vegetarisch menu": "dit is geen vegetarische menu");
        uit+= "\ntotaal aantal calorieën = " + this.aantalCalorieen();
        return uit;
    }
}