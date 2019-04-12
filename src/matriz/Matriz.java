package matriz;

public class Matriz {
	private int i = 0;
	private int j = 0;
	private double m[][];
	
	public Matriz(int i, int j) {
		this.setI(i);
		this.setJ(j);
		double matriz[][] = new double[this.i][this.j];
		this.setM(matriz);
	}
	
	public void atualizaM() {
		double matriz[][] = new double[this.i][this.j];
		this.setM(matriz);
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public double[][] getM() {
		return m;
	}

	public void setM(double m[][]) {
		this.m = m;
	}
	
	public void setValores(int i, int j, int x) {
		this.m[i][j] = x;
	}
	
	public double getValores(int i, int j) {
		return this.m[i][j];
	}
	
	
}
