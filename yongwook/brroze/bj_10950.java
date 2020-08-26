package brroze;

import java.util.Scanner;

public class bj_10950 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		int a = 0;
		int b = 0;
		for (int i = 0; i < tc; i++) {
			a = sc.nextInt();
			b= sc.nextInt();
			
			System.out.println(a+b);
		}
	}
}
