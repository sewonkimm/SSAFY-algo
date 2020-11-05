package gold;

import java.util.Scanner;

public class bj_1976_여행가자 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int town = sc.nextInt();
		int plan = sc.nextInt();
		int arrtown[][] = new int[town+1][town+1];
		int arrplan[] = new int[plan+1];
		for (int i = 1; i <= town; i++) {
			for (int j = 1; j <= town; j++) {
				arrtown[i][j]= sc.nextInt();
			}
		}
		
		for (int i = 0; i < plan; i++) {
			arrplan[i]= sc.nextInt();
		}
		
		
		
	}
	
	public static make_set() {
		for (int i = 0; i < town; i++) {
			parent[i] = i;
			
		}
	}
	public static void find_set(int x) {
		if(parent[x] == x)
			return x;
		return parent[x] = find_set(parent[x]);
	}
	public static void union(int x, int y) {
		int a = find_set(x);
		int y = find_set(y);
		
		if(a == y)
			return;
		
		if()
	}
}
