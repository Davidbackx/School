package domain;

public class Weekmenu {
    static String[] dagen = { "maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag", "zondag"};

    private int jaartal, weeknummer;
    private Menu[] menus;

    public Weekmenu (int jaartal, int weeknummer) {
        if (jaartal < 2019 || weeknummer < 1 || weeknummer > 52) throw new IllegalArgumentException();
        this.jaartal = jaartal;
        this.weeknummer = weeknummer;
        menus = new Menu[7];
    }

    public void addMenu (Menu menu, int dag) {
        if (dag < 1 || dag > 7) throw new IllegalArgumentException();
        if (menus[dag - 1] != null) throw new IllegalArgumentException();
        menus[dag - 1] = menu;
    }

    @Override
    public String toString() {
        String uit = "Weekmenu voor week " + weeknummer + "/" + jaartal + "\n\n";

        for (int i = 0 ; i < 7 ; i++){
            uit += dagen[i] + ":\n" + (menus[i] != null ?menus[i].toString():"verrassingsmenu") + "\n\n";
        }
        return uit;
    }
}
