package brroze;

import java.util.Scanner;

public class bj_10872_팩토리얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		System.out.println(factorial(a));
	}
	
	public static int factorial(int N) {
		 
		if(N <= 1)
			return 1;
		
		return factorial(N-1)* N ;
	}
}
