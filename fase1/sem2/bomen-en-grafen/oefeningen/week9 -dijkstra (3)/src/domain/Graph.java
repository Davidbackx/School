package domain;

import java.util.ArrayList;

public class Graph {
	private final int[][] gewichtenMatrix;
    private final int inf = Integer.MAX_VALUE;

	public Graph(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
			throw new IllegalArgumentException();
		}

		this.gewichtenMatrix = matrix.clone();
	}

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }


	private int[][] initMatrixDijkstra(int vanKnoop) {
        int[][] res = new int[this.gewichtenMatrix.length + 1][this.gewichtenMatrix.length];
		// laatste rij is rij met kortste lengtes vanuit vanKnoop

		for (int i = 0; i < getAantalKnopen(); i++) {
			for (int j = 0; j < getAantalKnopen(); j++) {
				res[i][j] = (gewichtenMatrix[i][j] == inf ? 0 : gewichtenMatrix[i][j]);
				res[getAantalKnopen()][i] = inf;
			}
		}
		for (int i = 0; i <= getAantalKnopen(); i++) {
			res[i][vanKnoop - 1] = 0;
		}

		return res;
	}

	public int[][] Dijkstra(int vanKnoop) {
		int[][] res = initMatrixDijkstra(vanKnoop);
		
		System.out.println("Initiele matrix: \n");
		printIntMatrix(res);

		for (int i = 0; i < getAantalKnopen(); i++) {
			int min = inf;
			int[] knopenpaar = {inf, inf};
			for (int j = 0; j < getAantalKnopen(); j++) {
				if (res[getAantalKnopen()][j] != inf) {
					for (int k = 0; k < getAantalKnopen(); k++) {
						if (res[getAantalKnopen()][k] == inf && res[j][k] != 0 && res[getAantalKnopen()][j] + res[j][k] < min) {
							knopenpaar[0] = j;
							knopenpaar[1] = k;
							min = res[getAantalKnopen()][j] + res[j][k];
						}
					}
				}
			}
			if (knopenpaar[0] != inf && knopenpaar[1] != inf) {
				res[getAantalKnopen()][knopenpaar[1]] = min;
				for (int j = 0; j < getAantalKnopen() - 1; j++) {
					if (j != knopenpaar[0])
						res[j][knopenpaar[1]] = 0;
				}
			}
		}

		return res;
	}

	private ArrayList<Integer> vindPad(int vanKnoop, int naarKnoop, int[][] res) {
		ArrayList<Integer> pad = new ArrayList<>();
		pad.add(naarKnoop);
		while (vanKnoop != naarKnoop) {
			int k = 1;
			while (k - 1 < getAantalKnopen() && res[k - 1][naarKnoop - 1] == 0) {
				k++;
			}
			pad.add(0, k);
			naarKnoop = k;
		}
		return pad;
	}

	public String berekenPaden(int vanKnoop) {
        String uit = "";
        int[][] res = this.Dijkstra(vanKnoop);

        System.out.println("Resulterende matrix: \n");
        printIntMatrix(res);

        for (int i = 0; i < getAantalKnopen(); i++) {
            if ((i + 1) != vanKnoop) {
                if (res[getAantalKnopen()][i] == Integer.MAX_VALUE) {
                    uit += "Er is geen pad van " + vanKnoop + " naar " + (i + 1) + "\n";
                } else {
                    uit += "Kortste afstand van " + vanKnoop + " naar " + (i + 1) + " = " + res[getAantalKnopen()][i] + "\n";
                    uit += "via ";

                    int j = (i + 1);
                    ArrayList<Integer> pad = vindPad(vanKnoop, j, res);
                    uit += pad + "\n";
                }
            }
        }

		return uit;
	}
	
	private static void printIntMatrix(int[][] matrix) {
		String result ="";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				result += (matrix[i][j] == Integer.MAX_VALUE ? "inf" : matrix[i][j]) + "\t";
			}
			result += "\n";
		}
		result += "\n";
		
		System.out.println(result);		
	}

}
