package brroze;

import java.util.Scanner;

public class bj_2798블랙잭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int card = sc.nextInt();//카드장수
		int number= sc.nextInt(); // 최대 점수
		int input[] = new int[card+1];
		for (int i = 1; i <= card; i++) {
			input[i] = sc.nextInt();
		}
		
				
	}
}
