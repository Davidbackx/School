package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private final boolean[][] verbindingsMatrix;
    public static final int infty = Integer.MAX_VALUE;

    public Graph(int[][] matrix) {
        if (!isGeldigeVerbindingsMatrix(matrix))
            throw new IllegalArgumentException("No valid verbindingsmatrix");

        this.verbindingsMatrix = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                this.verbindingsMatrix[i][j] = matrix[i][j] == 1;
    }

    private boolean isGeldigeVerbindingsMatrix(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length)
            return false;

        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][i] != 0)
                return false;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                if (matrix[i][j] != 0 && matrix[i][j] != 1)
                    return false;
        return true;
    }

    private int getAantalKnopen() {
        return this.verbindingsMatrix.length;
    }

    private int[] findAncestors(int start, int destination) {// nummering van
        // start-knoop
        // (1..aantal_knopen)
        // naar
        // eindKnoop
        // (destination)
        int[] ancestors = new int[this.getAantalKnopen()];
        initArray(ancestors, infty);

        Queue<Integer> queue = new LinkedList<>();
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html
        queue.add(start);
        ancestors[start - 1] = 0;
        int huidig = queue.remove();
        while (start != destination) {

            for (int i = 1; i <= getAantalKnopen(); i++) {
                if (ancestors[i - 1] == infty && rechtstreeksteVerbinding(huidig, i)) {
                    queue.add(i);
                    ancestors[i - 1] = huidig;
                }
            }
            if (!queue.isEmpty())
                huidig = queue.remove();
            else break;
        }
        // oefening 1.4

        return ancestors;
    }

    public boolean rechtstreeksteVerbinding (int van, int naar) {
        return verbindingsMatrix[van - 1][naar - 1];
    }

    public List<Integer> findPath(int start, int destination) {
        if (start <= 0 || start > this.getAantalKnopen() || destination <= 0 || destination > this.getAantalKnopen())
            throw new IllegalArgumentException();

        int[] ancestors = this.findAncestors(start, destination);
        List<Integer> path = new LinkedList<>();

        // oefening 1.5
        int ouder = ancestors[destination - 1];
        while (ouder != 0 && ouder != infty) {
            path.add(0,destination);
            destination = ouder;
            ouder = ancestors[destination - 1];
        }
        if (ouder == 0)
            path.add(0, destination);
        return path;
    }

    private void initArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++)
            array[i] = value;
    }


    // methode om tussenliggend resultaat te kunnen schrijven naar het scherm
    public String geefAncestors(int start, int destination) {
        String res = "Ancestors van " + start + " naar " + destination + ":\n";
        int[] ancestors = this.findAncestors(start, destination);
        for (int a = 0; a < ancestors.length; a++)
            res += ancestors[a] != infty ? ancestors[a] : "infty" + " ";

        return res;
    }

    public Integer isVergeetput () {
        for (int i = 0; i < getAantalKnopen(); i++) {
            boolean[] fromRow = verbindingsMatrix[i];
            boolean vergeetputFound = true;
            for (int j = 0; j < getAantalKnopen(); j++) {
                if (fromRow[j] || (!verbindingsMatrix[j][i] && i != j)) {
                    vergeetputFound = false;
                    break;
                }
            }
            if (vergeetputFound) return i + 1;
        }

        return null;
    }

    public ArrayList<Double> verdeel (int persoon, double bedrag) {
        ArrayList<Double> verdeelt = new ArrayList<>();
        ArrayList<Integer> delers = new ArrayList<>();

        for (int i = 0; i < getAantalKnopen(); i++) {
            if (persoon == i) {
                verdeelt.add(bedrag);
                delers.add(persoon);
            }
            else {
                verdeelt.add(0.0);
            }
        }
        return verdeelHelper(verdeelt, delers);
    }

    private ArrayList<Double> verdeelHelper (ArrayList<Double> verdeelt, ArrayList<Integer> delers) {
        if (delers.size() == 0)
            return verdeelt;
        else {
            ArrayList<Integer> nieuwDelers = new ArrayList<>();
            for (int i = 0; i < delers.size(); i++) {
                int deler = delers.get(i);
                boolean[] kinderen = this.verbindingsMatrix[deler];
                ArrayList<Integer> deelMetKinderen = new ArrayList<>();
                for (int j = 0; j < kinderen.length; j++) {
                    if (kinderen[j] && verdeelt.get(j) == 0.0) {
                        deelMetKinderen.add(j);
                    }
                }
                if (deelMetKinderen.size() != 0) {
                    double verdeelvalue = verdeelt.get(deler) / 2;
                    verdeelt.set(deler, verdeelvalue);
                    verdeelvalue /= deelMetKinderen.size();

                    for (int j = 0; j < deelMetKinderen.size(); j++) {
                        int kind = deelMetKinderen.get(j);
                        verdeelt.set(kind, verdeelvalue);
                        if (!nieuwDelers.contains(kind)) nieuwDelers.add(kind);
                    }
                }
            }
            return verdeelHelper(verdeelt, nieuwDelers);
        }
    }
}