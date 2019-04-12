package matriz;

public class MetodoGass {
	double matrizR[][];
	Matriz matriz;
	int m, n;

	public MetodoGass(Matriz m) {
		this.matriz = m;
		this.inicializar();
	}

	public void inicializar() {
		m = matriz.getI();
		n = matriz.getJ() * 2;
		double matrizG[][] = new double[m][n];
		for (int i = 0; i < matriz.getI(); i++) {
			for (int j = 0; j < matriz.getJ(); j++) {
				matrizG[i][j] = matriz.getValores(i, j);
			}

		}
		for (int i = 0; i < m; i++) {
			for (int j = matriz.getJ(); j < n; j++) {
				if (j - i == matriz.getI()) {
					matrizG[i][j] = 1;
				}
				if (matrizG[i][j] != 1) {
					matrizG[i][j] = 0;
				}
			}
		}

		boolean z = true;
		for (int j = 0; j < matriz.getJ(); j++) {
			for (int i = 0; i < m; i++) {
				int aux2 = 0;
				while (i < j) {
					if (z == false) {
						z = true;
						break;
					}
					i++;
					aux2++;
				}
				if (i == j && matrizG[i][j] != 1) {
					if (matrizG[i][j] == 0) {
						for (int y = 0; y < m; y++) {
							if (matrizG[y][i] != 0) {
								for (int a = 0; a < n; a++) {
									matrizG[i][a] = matrizG[i][a] + matrizG[y][a];
								}
								break;
							}
						}
					}
					double aux = matrizG[i][j];
					for (int y = 0; y < n; y++) {
						if (aux == 0) {
							matrizG[i][y] = 0;
						} else {
							matrizG[i][y] = matrizG[i][y] / aux;
						}
					}
					z = false;
					i = i - aux2;
					aux2 = 0;
				}
				if (i != j && matrizG[i][j] != 0) {
					double aux = (matrizG[i][j] / matrizG[j][j]) * -1;
					for (int y = 0; y < n; y++) {
						matrizG[i][y] = aux * matrizG[j][y] + matrizG[i][y];
					}
				}
			}
		}
		this.setMatrizR(matrizG);

	}

	public double[][] getMatrizR() {
		return matrizR;
	}

	public void setMatrizR(double m[][]) {
		this.matrizR = m;
	}

}
