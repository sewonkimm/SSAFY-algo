package brroze;

import java.util.Scanner;

public class bj_10039_평균점수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum= 0;
		int input = 0;
		for (int i = 0; i < 5; i++) {
			input = sc.nextInt();
			if(input<40) {
				input= 40;
			}
			sum += input;
			
		}
		System.out.println(sum/5);
	}
}
