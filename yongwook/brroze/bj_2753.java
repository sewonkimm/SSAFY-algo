package brroze;

import java.util.Scanner;

public class bj_2753 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		boolean a = false;
		if( N % 4 ==0 && N % 100 != 0 || (N %400==0 ))
			a = true;
	
		
		if(a)
		System.out.println("1");
		else
			System.out.println("0");
	}
}
