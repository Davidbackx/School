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
        int[][] P = new int[getAantalKnopen()][getAantalKnopen()];
        double[][] D =this.gewichtenMatrix.clone();
        for(int i = 0; i < D.length; i++) {
            D[i] = D[i].clone();
        }

		// oefening 2.3
        for (int k = 0; k < getAantalKnopen(); k++) {
            for (int i = 0; i < getAantalKnopen(); i++) {
                for (int j = 0; j < getAantalKnopen(); j++) {
                    if (D[i][k] + D[k][j] < D[i][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                        P[i][j] = k + 1;
                    }
                }
            }
        }

		return P;
	}

	public List<Integer> getShortestPath(int van, int tot, int[][] P) {
		List<Integer> res = new ArrayList<>();

		if (van == tot) {
		    return res;
        }
        else {
            int via = P[van - 1][tot - 1];
            if (via == 0) {
                res.add(van);
                res.add(tot);
            }
            else {
                res = getShortestPath(van, via, P);
                res.remove(res.size() - 1);
                res.addAll(getShortestPath(via, tot, P));
            }
        }
		return res;

	}

	public int berekenLengte(List<Integer> pad) {
		int som = 0;

        for (int i = 0; i < pad.size() - 1; i++) {
            int huidige = pad.get(i);
            int volgende = pad.get(i + 1);

            som += gewichtenMatrix[huidige - 1][volgende - 1];
        }
		
		return som;
	}

}
