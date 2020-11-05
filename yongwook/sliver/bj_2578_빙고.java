package sliver;

import java.util.Scanner;

public class bj_2578_빙고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int map[][] = new int[5][5];
		int map1[][] = new int[5][5];
		int input[] = new int[25];
		
		int result = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j]= sc.nextInt();
			}
		}
		
		for (int i = 0; i < 25; i++) {
			input[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 5; j++) {
				for (int z = 0; z < 5; z++) {
					if(input[i] == map[j][z] ) {
						map[j][z]= 0;
						result++;
					}
				}
			}
			
		}
		System.out.println(result);
	}
}
