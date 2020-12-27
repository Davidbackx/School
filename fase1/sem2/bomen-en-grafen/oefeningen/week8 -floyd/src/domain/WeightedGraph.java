package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

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
        int aantal = getAantalKnopen();
        int[][] P = new int[aantal][aantal];
        double[][] D = this.gewichtenMatrix.clone();
        for(int i = 0; i < D.length; i++) {
            D[i] = D[i].clone();
        }

        for (int k = 0; k < aantal; k++) {
            for (int i = 0; i < aantal; i++) {
                for (int j = 0; j < aantal; j++) {
                    if (D[i][k] + D[k][j] < D[i][j]){
                        D[i][j] = D[i][k] + D[k][j];
                        P[i][j] = k + 1;
                    }
                }
            }
        }
		return P;
	}

	public List<Integer> getShortestPath(int i, int j, int[][] path) {
		List<Integer> res = new ArrayList<>();

		if (i == j) return res;
        else {
            int via = path[i - 1][j - 1];
            if (via == 0) {
                res.add(i);
                res.add(j);
            }
            else {
                res = getShortestPath(i, via, path);
                res.remove(res.size() - 1);
                res.addAll(getShortestPath(via, j, path));
            }
        }

		return res;
	}

	public int berekenLengte(List<Integer> pad) {
		int som = 0;
	    // oefening 2.5

        int aantal = pad.size();
        int huidige, volgende;

        for (int i = 0; i < aantal - 1; i++) {
            huidige = pad.get(i);
            volgende = pad.get(i + 1);
            som += this.gewichtenMatrix[huidige - 1][volgende - 1];
        }
		return som;
	}
}
