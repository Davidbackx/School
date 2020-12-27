package db;

import domain.Opdracht;

import java.util.Comparator;

public class ComperatorByCategoryAndId implements Comparator<Opdracht> {
    @Override
    public int compare(Opdracht o1, Opdracht o2) {
        if (o1 == null || o2 == null) return 1;
        int i = o1.getCategorie().compareTo(o2.getCategorie());
        if (i == 0)
            i = o1.getOpdrachtID() -  o2.getOpdrachtID();
        return i;
    }
}
