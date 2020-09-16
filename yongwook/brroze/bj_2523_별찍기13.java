package brroze;

import java.util.Scanner;

public class bj_2523_별찍기13 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		for (int i = 0; i < input; i++) {
			for (int j = 0; j <input ; j++) {
				if(i>=j)
				System.out.print("*");
			}						
			System.out.println();
		}
		
		for (int i = 0; i < input; i++) {
			for (int j = input-1; j >=0 ; j--) {
				if(i<j)
				System.out.print("*");
			}						
			System.out.println();
		}
	}
}
