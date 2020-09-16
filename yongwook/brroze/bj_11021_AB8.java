package brroze;

import java.util.Scanner;

public class bj_11021_AB8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		int A,B = 0;
		for (int i = 1; i <= T; i++) {
			A = sc.nextInt();
			B= sc.nextInt();
			
			sb.append("Case"+ " #"+i + ":"+ " "+A+" + "+B +" = "+ (A+B) + "\n");
		}
		
		System.out.println(sb);
	}
}
