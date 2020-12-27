package db;

import domain.Opdracht;

import java.util.Comparator;

public class ComparatorById implements Comparator<Opdracht> {
    @Override
    public int compare(Opdracht o1, Opdracht o2) {
        if (o1 == null || o2 == null) return 1;
        else return o1.getOpdrachtID() - o2.getOpdrachtID();
    }
}
