package db;

import domain.Opdracht;

import java.util.Comparator;

public class ComparatorByCategorie implements Comparator<Opdracht> {
    @Override
    public int compare(Opdracht o1, Opdracht o2) {
        if (o1 == null || o2 == null) return 1;
        return  o1.getCategorie().compareTo(o2.getCategorie());
    }
}
