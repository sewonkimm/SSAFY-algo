package brroze;

import java.util.Scanner;

public class bj_5543상근날드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int min = Integer.MAX_VALUE;
		int min1 = Integer.MAX_VALUE;
		int input =0;
		for (int i = 0; i < 3; i++) {
			input =sc.nextInt();
			if(min>input) {
				min = input;
			}
		}
		for (int i = 0; i < 2; i++) {
			input = sc.nextInt();
			if(min1>input) {
				min1 = input;
			}
		}
		System.out.println(min1+min-50);
	}
}
