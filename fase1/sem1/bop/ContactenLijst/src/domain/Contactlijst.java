package domain;

import java.util.ArrayList;

public class Contactlijst {
    String naam;
    ArrayList<Contact> contacten;

    public Contactlijst (String naam) {
        if (naam == null || naam.trim().isEmpty()) throw new IllegalArgumentException();
        this.naam = naam;
        contacten = new ArrayList<>();
    }

    public void addContact (Contact c) {
        if (c == null) throw new IllegalArgumentException();
        contacten.add(c);
    }

    public Contact meesteEmails () {
        Contact meeste = null;
        for (Contact c : contacten) {
            if (meeste == null) meeste = c;
            if (c.getAantalEmails() > meeste.getAantalEmails()) meeste = c;
        }
        return meeste;
    }

    public int aantalFavorieten () {
        int aantal = 0;
        for (Contact c : contacten) {
            if (c.isFavoriet()) aantal++;
        }
        return aantal;
    }
}
