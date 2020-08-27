package brroze;

import java.util.Scanner;

public class bj_10951 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = 0;
		int b = 0;
		while(sc.hasNextInt()) {
			a = sc.nextInt();
			b= sc.nextInt();
			
			System.out.println(a+b);
		}
	}
}
