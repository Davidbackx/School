package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

    public WeightedGraph(double[][] matrix) {
        if (!isGeldigeGewichtenmatrix(matrix))
            throw new IllegalArgumentException("No valid gewichtenmatrix");
        this.gewichtenMatrix = matrix;
    }

    private boolean isGeldigeGewichtenmatrix(double[][] matrix) {
        return matrix != null && matrix.length == matrix[0].length;
    }

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }

    public int[][] findDistances() {
        int[][] p = new int[getAantalKnopen()][getAantalKnopen()];
        double[][] d = this.gewichtenMatrix.clone();

        for (int k = 0; k < getAantalKnopen(); k++) {
            for (int i = 0; i < getAantalKnopen(); i++) {
                for (int j = 0; j < getAantalKnopen(); j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        p[i][j] = k + 1;
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
		return p;
	}

	public List<Integer> getShortestPath(int van, int tot, int[][] p) {
		List<Integer> pad = new ArrayList<>();

		if (van == tot){
		    return pad;
        }
		else {
            int via = p[van - 1][tot - 1];
            if (via == 0) {
                pad.add(van);
                pad.add(tot);
            }
            else {
                pad = getShortestPath(van, via, p);
                pad.remove(pad.size() - 1); // Haalt de "via" dubbels eruit
                pad.addAll(getShortestPath(via, tot, p));
            }
        }
		return pad;
	}

	public int berekenLengte(List<Integer> pad) {
		int som = 0;
		int huidig, volgende;

        for (int i = 0; i < pad.size() - 1; i++) {
            huidig = pad.get(i);
            volgende = pad.get(i+1);
            som += this.gewichtenMatrix[huidig - 1][volgende - 1];
        }
		
		return som;
	}

}
