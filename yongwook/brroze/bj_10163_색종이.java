package brroze;

import java.util.Scanner;

public class bj_10163_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int tc =sc.nextInt();
		int map[][] = new int[101][101];
		
		
		for (int i = 1; i <= tc; i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			for (int j = a; j < a+c; j++) {
				for (int z = b; z < b+d; z++) {
					map[j][z] = i;
				}
			}
					
		}
	
		int cnt = 0;
		for (int i = 1; i <= tc; i++) {
			cnt = 0;
			for (int j = 0; j < 101; j++) {
				for (int k = 0; k < 101; k++) {
					if(map[j][k] == i ) cnt++;
				}
			}
			System.out.println(cnt);
		}
		
			
	}
}
