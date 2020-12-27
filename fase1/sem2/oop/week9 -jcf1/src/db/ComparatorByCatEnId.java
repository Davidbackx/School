package db;

import domain.Opdracht;

import java.util.Comparator;

public class ComparatorByCatEnId implements Comparator<Opdracht> {
    @Override
    public int compare(Opdracht o1, Opdracht o2) {
        if (o1 == null || o2 == null) return 1;
        int i =  o1.getCategorie().compareTo(o2.getCategorie());
        if (i != 0) return i;
        else return o1.getOpdrachtID() - o2.getOpdrachtID(); // negatief als o1 zijn id < o2 zijn id
    }
}
