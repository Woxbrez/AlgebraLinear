package main;

import java.util.Scanner;

import matriz.Matriz;
import matriz.MetodoGass;

public class Main {
	
	private static Scanner ler;

	public static void main(String[] args) {
		boolean x = true;
		ler = new Scanner(System.in);
		do {
			System.out.printf("Quantidade de linhas e colunas?");
			int m = ler.nextInt();
			int n = m;
			System.out.printf("Cálculo da matriz inversa pelo método Gass;\n");
			Matriz matriz = new Matriz(m, n);
			for(int i = 0; i <matriz.getI(); i++) {
				for(int j = 0; j<matriz.getJ(); j++) {
					System.out.printf("Valor de M[%d][%d]:\n", i, j);
					int y = ler.nextInt();
					matriz.setValores(i, j, y);
				}
			}
			for(int i = 0; i <matriz.getI(); i++) {
				for(int j = 0; j<matriz.getJ(); j++) {
					System.out.printf("(%.2f)", matriz.getValores(i, j));
				}
				System.out.println("\n");
			}
			
			MetodoGass gauss = new MetodoGass(matriz);
			double matrizI[][] = gauss.getMatrizR();
			System.out.println("Matriz Inversa:\n");
			for(int i = 0; i <matriz.getI(); i++) {
				for(int j = 0; j<matriz.getJ()*2; j++) {
					System.out.printf("(%.2f)", matrizI[i][j]);
				}
				System.out.println("\n");
			}			
		}while(x);
		

	}
}
